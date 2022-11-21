package com.finsol.tarea2_3m1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Imagen extends AppCompatActivity {
    //Blob
    byte[] accImage;
    ImageView imagen;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        imagen = findViewById(R.id.image);
        //Verificando si enviaron datos
        Bundle datos = getIntent().getExtras();
         String id = ""+datos.getString("id");
        getCurrentAccount(id);
    }

    public void getCurrentAccount(String id) {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        String sql = "SELECT * FROM "+Transacciones.TablaImagenes+ " where id = "+id;

        Cursor cursor = db.rawQuery(sql, new String[]{});
        while (cursor.moveToNext()) {

            String image  = cursor.getString(1);
            imagen.setImageBitmap(ConvertBase64toImage(image));
        }
        
       db.close();

    }

    private Bitmap ConvertBase64toImage(String Base64String)
    {
        //String base64Image  = Base64String.split(",")[1];
        String base64Image  = Base64String;
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
}