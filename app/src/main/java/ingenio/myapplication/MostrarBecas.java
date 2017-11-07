package ingenio.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.ExpandableListView;
import android.widget.Toolbar;

import Funcionalidad.ListViewExtended;
import Funcionalidad.ListViewSubscripciones;
import Funcionalidad.ListViewVerBecas;

public class MostrarBecas extends AppCompatActivity {

    private ExpandableListView listView;
    private ListViewExtended mostrarInfo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_becas);
        setTitle(getString(R.string.activity_verbecas));
        /*********************************************
          CREAR ADAPTADOR PARA MOSTRAR LA INFORMACION
         *********************************************/
        Intent intent = getIntent();
        int accion = intent.getIntExtra("listview",0);
        switch (accion){
            case MenuPrincipal.ID_VERBECAS:
                mostrarInfo= new ListViewVerBecas(this);
                break;
            case MenuPrincipal.ID_VERSUBSCRIPCIONES:
                mostrarInfo = new ListViewSubscripciones(this);
                break;
        }

        this.listView = (ExpandableListView) findViewById(R.id.listView);
        this.listView.setAdapter(mostrarInfo);





    }
}