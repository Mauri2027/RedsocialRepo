package com.example.fotomomentos;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.fotomomentos.R.layout.activity_registrer;

public class RegistroActivity extends Activity {
    Button btnRegistrar;
    EditText txtUsuario, txtMail, txtPassword;
    DatabaseHelper helper = new DatabaseHelper(RegistroActivity.this);



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);
        btnRegistrar= findViewById(R.id.btnRegistrar2);
        txtUsuario=findViewById(R.id.userRegistro);
        txtMail=findViewById(R.id.mailRegistro);
        txtPassword=findViewById(R.id.passRegistro);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrir();
                helper.insertarRegistro(String.valueOf(txtUsuario.getText()),
                        String.valueOf(txtMail.getText()),
                        String.valueOf(txtPassword.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(),"Se registro nuevo usuario",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });





    }

}




