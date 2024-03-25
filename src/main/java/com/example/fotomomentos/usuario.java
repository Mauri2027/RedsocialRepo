package com.example.fotomomentos;
public class usuario {

    private String nombre;
    private  String descripcion;
    private int imagenId;
    private String info;
    private String task;

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTask() {
        return task;
    }

    public String getInfo() {
        return info;
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

    public usuario(){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.imagenId=imagenId;
    }




}
