package com.finsol.tarea2_3m1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Imagenes> implements View.OnClickListener
{
    private List<Imagenes> dataset;
    private Context mContext;

    public static class ViewHolder{
        TextView id, descripcion;
        ImageView foto;
    }

    public CustomAdapter(List<Imagenes> data, Context context) {
        super(context, R.layout.mylist, data);

        this.dataset = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);

        Imagenes datModel = (Imagenes) object;
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Imagenes datosModel = getItem(position);
        ViewHolder viewHolder = null;
        final View Result;

        if(convertView == null){
            viewHolder = new ViewHolder();


            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.mylist, parent, false);

            viewHolder.id = convertView.findViewById(R.id.txtUserID);
            viewHolder.descripcion = convertView.findViewById(R.id.txtDescripcion);
            viewHolder.foto = convertView.findViewById(R.id.image);
            Result = convertView;
            convertView.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) convertView.getTag();
            convertView.setTag(viewHolder);
        }

        viewHolder.id.setText("ID: "+String.valueOf(datosModel.getId()));
        viewHolder.descripcion.setText("Descripcion: "+datosModel.getDescripcion().toString());
        if (datosModel.getImage().length()>0){
            Log.i("LOG",""+datosModel.getImage().length());
            viewHolder.foto.setImageBitmap(ConvertBase64toImage(datosModel.image));
        }

        return convertView;
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
