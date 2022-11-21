package com.finsol.tarea2_3m1;

public class Imagenes {
    public Integer id;
    public String image, descripcion;


    //Constructor de la clase
    public Imagenes(){
        //Todo
    }

    public Imagenes(Integer id, String image, String descripcion) {
        this.id = id;
        this.image = image;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
