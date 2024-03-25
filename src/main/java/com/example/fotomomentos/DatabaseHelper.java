package com.example.fotomomentos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BD";
    private static final int DATABASE_VERSION = 1;
    //private static final String DATABASE_CREATE ="CREATE TABLE Personas (id integer primary key autoincrement, " + "Usuario text not null, Password text not null);";
    private SQLiteDatabase bd;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String querycrear ="CREATE TABLE Personas (id integer primary key autoincrement, "
                + "Usuario text not null, Mail text not null, Password text not null);";
        //agregar tabla
        //String queryotraTabla="CREATE TABLE Momentos (id integer primary key autoincrement, "
        //        + "idMomento integer,titulo text not null, task text not null, foreign key(idMomento) references Personas(id));";

        try {
            db.execSQL(querycrear);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*try{
            db.execSQL(queryotraTabla);

        }catch (SQLException e){
            e.printStackTrace();
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Personas");
        onCreate(db);
    }



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void abrir() {
        this.getWritableDatabase();
    }
    public void cerrar() {
        this.close();
    }

    public void insertarRegistro(String nombre, String mail, String password){
        ContentValues valores = new ContentValues();
        valores.put("Usuario",nombre);
        valores.put("Mail",mail);
        valores.put("Password",password);
        this.getWritableDatabase().insert("Personas",null,valores);
    }

    //--------------validar si existe usuario  --------------------------------
    public Cursor ConsultarUsuario(String usuario, String password) throws SQLException {
        Cursor mcursor = null;
        mcursor=this.getReadableDatabase().query("Personas", new String[]{"id",
                "Usuario","Mail","Password"},"Mail like '"+usuario+"'and Password like'"+password+"'",
                null,null,null,null);
        return mcursor;
    }

}







