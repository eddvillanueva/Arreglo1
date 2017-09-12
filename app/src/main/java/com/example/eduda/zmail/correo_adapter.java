package com.example.eduda.zmail;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public abstract class correo_adapter extends BaseAdapter{                      // revisar porque anda solo con abstract

    private List<claseCorreo> correos;

    public correo_adapter(List<claseCorreo> correos){
        this.correos = correos;
    }

    @Override
    public int getCount() {
        return correos.size();
    }

    @Override
    public Object getItem(int position) {
        return correos.get(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;


        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_correo,parent,false);
        }else{
            view = convertView;
        }

        claseCorreo contacto = (claseCorreo) getItem(position);

        TextView txtRemitente = (TextView) view.findViewById(R.id.txtRemitente);
        TextView txtAsunto = (TextView) view.findViewById(R.id.txtAsunto);
        TextView txtLetra = (TextView) view.findViewById(R.id.txtLetra);


        txtRemitente.setText(contacto.getRemitente());
        txtAsunto.setText(contacto.getAsunto());
        txtLetra.setText(contacto.getRemitente().substring(0,1).toUpperCase());
        txtLetra.getBackground().setColorFilter(Color.parseColor(contacto.getColor()), PorterDuff.Mode.SRC);
        return view;
    }

}
