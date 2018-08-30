package com.example.estudiantes.restaurantealarcn;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void CargarMapa(View view){
        Intent intencion = new Intent(this, MapsActivity.class);
        startActivity(intencion);
    }

    void ConsultarMenu(View view){
        Intent intencion = new Intent(this, MenuActivity.class);
        startActivity(intencion);
    }

    void ReservarMesa(View view){
        String whatsApp = "com.whatsapp";
        PackageManager packageManager = getPackageManager();
        Intent intencion = packageManager.getLaunchIntentForPackage(whatsApp);
        startActivity(intencion);
    }

    void CalificarServicio(View view){
        Intent intencion = new Intent(this, ServicioActivity.class);
        startActivity(intencion);
    }
}
