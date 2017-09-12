package com.example.eduda.zmail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.password;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private ListView lista_correos;
    private Context contexto;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        contexto = MainActivity.this;

        lista_correos = (ListView) findViewById(R.id.lista_correos);

        cargarLista();

        lista_correos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                claseCorreo item = (claseCorreo) lista_correos.getItemAtPosition(position);

                String pasaremit = item.getRemitente();
                String pasaasunt = item.getAsunto();
                String pasamensa = item.getMensaje();

                Intent i = new Intent(parent.getContext(), mainMensaje.class);

                i.putExtra("PASA_REMIT", pasaremit);
                i.putExtra("PASA_ASUNT", pasaasunt);
                i.putExtra("PASA MENSA", pasamensa);

                startActivity(i);


              // Toast.makeText(contexto, item.getRemitente() + "  " + item.getMensaje(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void cargarLista() {

        final List<claseCorreo> correos = new ArrayList<>();

        correos.add(new claseCorreo("Homero Simpson", "HomeroSimpson@gmail.com", "Feliz Cumpleaños", "Te deseo feliz cumpleaños", "#8bc34a"));
        correos.add(new claseCorreo("Pepe Grillo", "PepeGrillo@gmail.com", "Saludos", "Te mando saludos", "#afb42b"));
        correos.add(new claseCorreo("Sofia Pilar Diaz", "SofiaPilar@gmail.com", "Nacimiento", "Te comunico que acabo de nacer", "#303f9f"));
        correos.add(new claseCorreo("Marcelo Tinelli", "MarceloTinelli@gmail.com", "Renuncia", "Renuncio al Bailando !!!", "#eeff41"));
        correos.add(new claseCorreo("Huracan Irma", "HuracanIrma@gmail.com", "Acabo de llegar", "Acabo de LLegar a Maiami pero hay mal tiempo", "#e51c23"));
        correos.add(new claseCorreo("Lucas Alario", "LucasAlario@gmail.com", "Aviso", "Si no llego para el partido de River ... arranquen", "#e040fb"));
        correos.add(new claseCorreo("Eduardo Villanueva", "EduardoV@gmail.com", "Android", "Este programa me ca... el finde", "#ffab40"));
        correos.add(new claseCorreo("Luisana Lopilato", "LuisanaL@gmail.com", "Pregunta", "Estoy solo esta noche !!!... Venis?", "#e040fb"));
        correos.add(new claseCorreo("Roger Hodgson", "RogerHodgson@gmail.com", "Invitiación", "Te invito a mi proximo concierto, te espero", "#18ffff"));


        lista_correos.setAdapter(new correo_adapter(correos) {
            @Override
            public long getItemId(int position) {
                return 0;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuOpcion1:
                Toast.makeText(MainActivity.this, "Seleccione Refrescar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuOpcion2:
                Toast.makeText(MainActivity.this, "Seleccione Opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuOpcion3:
                Toast.makeText(MainActivity.this, "Seleccione Opcion 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuSalir:
                Toast.makeText(MainActivity.this, "Adios !!", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
