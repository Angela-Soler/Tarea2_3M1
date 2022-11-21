package com.finsol.tarea2_3m1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listPerson;
    ArrayList<Imagenes> lista;
    ArrayList<String> listaConcatenada;
    private static CustomAdapter adaptercustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listPerson = (ListView) findViewById(R.id.listImagenes);

        GetListPerson();


        adaptercustom = new CustomAdapter(lista, getApplicationContext());
        //ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaConcatenada);
        listPerson.setAdapter(adaptercustom);

        listPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = lista.get(i).getId().toString();
                Toast.makeText(ActivityList.this, "Cargando Imagen...", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(ActivityList.this, Activity_Imagen.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    private void GetListPerson() {
        SQLiteDatabase db = conexion.getReadableDatabase(); //Base de Datos en modo lectura
        Imagenes listPersonas;

        lista = new ArrayList<>(); //lista de objetos de imagenes
        Cursor cursor = db.rawQuery(Transacciones.GetImagenes,null);

        while (cursor.moveToNext()){
            listPersonas = new Imagenes();
            listPersonas.setId(cursor.getInt(0));
            listPersonas.setImage(cursor.getString(1));
            listPersonas.setDescripcion(cursor.getString(2));

            lista.add(listPersonas);
        }
        cursor.close();

        //llenarLista();
    }

   /* private void llenarLista() {

        listaConcatenada = new ArrayList<>();

        for (int i=0; i < lista.size(); i++){
            listaConcatenada.add("ID: "+lista.get(i).getId()+" \nImagen: "+
                    lista.get(i).getImage());
        }
    }*/
}