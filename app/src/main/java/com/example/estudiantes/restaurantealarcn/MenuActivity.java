package com.example.estudiantes.restaurantealarcn;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity {

    private String[] testValues = new String[]{
            "Entrada",
            "Plato principal",
            "Bebidas",
            "Postres"
    };

    private ListView lvl = null;
    private ListAdapter lal = null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lvl = (ListView) findViewById(android.R.id.list);
        lal = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,testValues);

        lvl.setAdapter(lal);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        Toast.makeText(this,testValues[position], Toast.LENGTH_SHORT).show();

        switch (position){
            case 0:
                Intent intencion = new Intent(this, ListaComplejaEntrada.class);
                startActivity(intencion);
                break;
            default:
                    break;
        }
    }
}
