package com.example.fotomomentos;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fotomomentos.dummy.DummyContent;

public class HomeActivity extends AppCompatActivity implements  usuarioListaFragment.OnListFragmentInteractionListener,
 usuarioDetalle.OnFragmentInteractionListener, ComunicaFragment{

    ImageView imagen;

    usuarioListaFragment listahome;
    usuarioDetalle detallehome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listahome=new usuarioListaFragment();



        getSupportFragmentManager().beginTransaction().
                replace(R.id.homefragment,listahome).commit();
    }


    /*public void onClick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("imagen/");
        startActivityForResult(intent.createChooser(intent,"seleccione"),10);

    }*/

    protected void onActivityResult(int RequestCode,int ResultCode, Intent data){
        super.onActivityResult(RequestCode,ResultCode,data);

        if (ResultCode==RESULT_OK){
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }


    // toolbar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //menu acciones




    //esconder menu
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.menumomento) {
            //cargarImagen();
            Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("imagen/");
            startActivityForResult(intent.createChooser(intent,"seleccione"),10);
            Toast.makeText(this,"momento",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuidioma){
            Toast.makeText(this,"idioma",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuayuda){
            Toast.makeText(this,"ayuda",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menubuscar){
            Toast.makeText(this,"buscar",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menucompartir){
            Toast.makeText(this,"compartir",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menuagregar){
            Toast.makeText(this,"agregar",Toast.LENGTH_SHORT).show();
            //cargarImagen();
            Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("imagen/");
            startActivityForResult(intent.createChooser(intent,"seleccione"),10);




        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void enviarPersonje(UsuarioV usuario) {
        detallehome=new usuarioDetalle();
        Bundle bundleenvio=new Bundle();
    bundleenvio.putSerializable("objeto",usuario);
    detallehome.setArguments(bundleenvio);

    getSupportFragmentManager().beginTransaction().replace(R.id.homefragment,detallehome).addToBackStack(null).commit();


    }
}

