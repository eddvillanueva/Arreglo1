package com.example.eduda.zmail;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by eduda on 10/09/2017.
 */


public class mainMensaje extends AppCompatActivity {

  //  SpannableString negrita = new SpannableString("Remitente :" + "Asunto :");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String remitente ="Remitente :";
        String asunto = "Asunto :";
        String mensaje ="Mensaje :";

        //negrita.setSpan(new RelativeSizeSpan(2f), 0, 10, 0);
     //   negrita.setSpan(new StyleSpan(Typeface.BOLD), 12, 21, 0);



        Bundle paramet  = getIntent().getExtras();

        TextView txtRemit = (TextView) findViewById(R.id.txtRemit);
        TextView txtAsunt = (TextView) findViewById(R.id.txtAsunt);
        TextView txtMensa = (TextView) findViewById(R.id.txtMensa);

        String txtRem = paramet.getString("PASA_REMIT");
        String txtAsu = paramet.getString("PASA_ASUNT");
        String txtMe = paramet.getString("PASA MENSA");

        txtRemit.setText (remitente + txtRem);
        txtAsunt.setText(asunto + txtAsu);
        txtMensa.setText(txtMe);


    }

}