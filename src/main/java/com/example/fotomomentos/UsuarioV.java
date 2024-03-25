package com.example.fotomomentos;

import java.io.Serializable;

public class UsuarioV implements Serializable {
    private String nombre;
    private  String descripcion;
    private int imagenId;
    private String descripcioncompleta;
    private String task;

    public void setInfo(String info) {
        this.descripcioncompleta = info;
    }

    public String getTask() {
        return task;
    }

    public String getInfo() {
        return descripcioncompleta;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public UsuarioV(String nombre, String descripcion, int imagemId,String descripcioncompleta,String task){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.imagenId=imagemId;
        this.descripcioncompleta=descripcioncompleta;
        this.task=task;
    }


}
