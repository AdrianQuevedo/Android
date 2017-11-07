package ingenio.myapplication;


import android.content.Intent;
import android.os.Bundle;

import android.widget.ExpandableListView;

import Adapters.ListViewExtended;
import Adapters.ListViewSubscripciones;
import Adapters.ListViewVerBecas;

public class MostrarBecas extends AppCompatActivity {

    private ExpandableListView listView;
    private ListViewExtended mostrarInfo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_becas);
        setTitle(getString(R.string.activity_verbecas));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}