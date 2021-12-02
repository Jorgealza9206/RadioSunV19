package com.example.radiosun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.radiosun.adapters.AdapterSitios;
import com.example.radiosun.clases.dao.SitioDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Sitios extends AppCompatActivity {

    //Variables globales para el Recycler View
    //ArrayList<String> listaDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);

        actualizarRecycler();

        //Inicializando el Toolbar del activity map
        Toolbar sitios_toolbar = (Toolbar) findViewById(R.id.sitios_toolbar);
        setSupportActionBar(sitios_toolbar);

        //Agregar boton para añadir nuevos sitios
        FloatingActionButton BtnMapa = (FloatingActionButton) findViewById(R.id.sitios_btnagregarmapa);
        //Acción del boto Tus Sitios dentro del Activity Home
        BtnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMap = new Intent(Sitios.this,Map.class);
                startActivity(goMap);
            }
        });

        Button BtnBuscar = (Button) findViewById(R.id.sitios_btnbuscar);
        BtnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarRecycler();
            }
        });

    }


    // Comportamiento del action Bar del menu map
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sitios,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId(); // Creando la variable entera que corresponde a las acciones del Menu

        //Configurando las opciones del menu y las acciones que harán al hacerse click
        switch (id){

            case R.id.opcion1:
                Intent goHomefromSitios = new Intent(Sitios.this,Home.class);
                startActivity(goHomefromSitios);
                break;
            case R.id.opcion2:
                Intent goTusSitiosfromSitios = new Intent(Sitios.this,Map.class);
                startActivity(goTusSitiosfromSitios);
                break;
            case R.id.opcion4:
                Intent goAcercadefromSitios = new Intent(Sitios.this,Acerca_de.class);
                startActivity(goAcercadefromSitios);
                break;
            case R.id.opcion5:
                Intent goConfiguracionfromSitios= new Intent(Sitios.this,Configuracion.class);
                startActivity(goConfiguracionfromSitios);
                break;
            case R.id.opcion6:
                AlertDialog.Builder Alert_CerrarSesion = new AlertDialog.Builder(Sitios.this);
                Alert_CerrarSesion.setTitle("Cerrar Sesión");
                Alert_CerrarSesion.setMessage("¿Esta seguro que desea cerrar sesión?");
                Alert_CerrarSesion.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent goLogin = new Intent(Sitios.this, Login.class);
                        startActivity(goLogin);
                    }
                });
                Alert_CerrarSesion.show();
                break;
            default:
        }
        return true;

    }

    @Override
    protected void onResume(){
        super.onResume();
        actualizarRecycler();
    }

    //Recycler View
    private void actualizarRecycler(){
        //vincular proyecto
        EditText txtBusqueda = (EditText) findViewById(R.id.sitios_txtbusqueda);

        RecyclerView sitios_recycler = (RecyclerView) findViewById(R.id.sitios_recycler);
        //asignando recycler view
        sitios_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        SitioDAO sidao = new SitioDAO(this);
        AdapterSitios adaptador = new AdapterSitios(sidao.listar(txtBusqueda.getText().toString()));

        sitios_recycler.setNestedScrollingEnabled(true);
        sitios_recycler.setAdapter(adaptador);



    }




}