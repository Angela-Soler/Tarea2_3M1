package com.finsol.tarea2_3m1;

public class Transacciones {
    //Nombre de la Base de Datos
    public static final String NameDatabase = "PMT2_3M1";

    /*Creacion de la base de Datos*/
    public static final String TablaImagenes = "imagenes";

    /*Creación de la tabla Imagenes*/
    public static final String id = "id";
    public static final String image = "image";
    public static final String descripcion = "descripcion";

    //DDL
    public static final String createTableImagenes = "CREATE TABLE "+Transacciones.TablaImagenes+
            " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "image BLOB,"+
            "descripcion TEXT)";

    public static final String GetImagenes = "SELECT * FROM "+Transacciones.TablaImagenes;

    public static final String DropTableImagenes = "DROP TABLE IF EXISTS Imagenes";

    public static final String DeleteRegistro = "DELETE FROM "+TablaImagenes;

}

