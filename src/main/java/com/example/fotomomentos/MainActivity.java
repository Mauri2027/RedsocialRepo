package com.example.fotomomentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnRegistrar;
    Button btnIngresar;
    DatabaseHelper helper = new DatabaseHelper(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrar=findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro= new Intent(MainActivity.this,RegistroActivity.class);
                startActivity(registro);
            }
        });

        btnIngresar=findViewById(R.id.btnIniciar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtusuario=findViewById(R.id.nombreLogin);
                EditText txtpass=findViewById(R.id.passwordLogin);

                try {
                    Cursor cursor = helper.ConsultarUsuario(txtusuario.getText().toString(), txtpass.getText().toString());

                    if (cursor.getCount()>0){
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                    Toast.makeText(getApplicationContext(),"usuario y/o incorrecto",Toast.LENGTH_SHORT).show();
                    }
                    txtpass.setText("");
                    txtusuario.setText("");
                    txtusuario.findFocus();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


    }





}


























     /*
        btnRegistrar=findViewById(R.id.btnRegistrar);
        Button btnlogin=findViewById(R.id.btnIniciar);
        final EditText Enombre=findViewById(R.id.nomnuevo);
        Email=findViewById(R.id.mail);
        final EditText Epassword=findViewById(R.id.password);
        databaseHelper = new DatabaseHelper(MainActivity.this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(MainActivity.this,RegistroActivity.class);
                startActivity(registro);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase bd = databaseHelper.open();
                String query = "SELECT * FROM Personas where Usuario = '"+Enombre+"' and Password = '"+Epassword+"'";
                try{
                    Cursor c = bd.rawQuery(query,null);







                    if (c.moveToFirst()){
                        Intent home = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(home);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"No existe el usuario",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"error al ejecutar la query",Toast.LENGTH_SHORT).show();
                }
                finally{
                    bd.close();
                }

            }
        });



    */







