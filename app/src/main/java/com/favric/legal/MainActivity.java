package com.favric.legal;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;




import com.favric.legal.Clases.Base;

import com.favric.legal.vistas.Clases.Derechos_usuario;
import com.favric.legal.vistas.Clases.Encargado_sucursal;
import com.favric.legal.vistas.Clases.Garantia_legal;
import com.favric.legal.vistas.Clases.Reglamento_servicio;





public class MainActivity extends Base {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detectButton();

    }

    private void detectButton() {
        Button btn_redireccionar1 = findViewById(R.id.btn_redireccionar10);
        Button btn_redireccionar2 = findViewById(R.id.btn_redireccionar20);
        Button btn_redireccionar3 = findViewById(R.id.btn_redireccionar30);
        Button btn_redireccionar4 = findViewById(R.id.btn_redireccionar40);

        btn_redireccionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(MainActivity.this, Encargado_sucursal.class);
                startActivity(intent);
            }
        });

        btn_redireccionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 2
                Intent intent = new Intent(MainActivity.this, Garantia_legal.class);
                startActivity(intent);
            }
        });

        btn_redireccionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 3
                Intent intent = new Intent(MainActivity.this, Derechos_usuario.class);
                startActivity(intent);
            }
        });

        btn_redireccionar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 4
                Intent intent = new Intent(MainActivity.this, Reglamento_servicio.class);
                startActivity(intent);
            }
        });


    }

}