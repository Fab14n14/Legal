package com.favric.legal.vistas.Clases;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.favric.legal.Clases.Base;
import com.favric.legal.Clases.Utils;
import com.favric.legal.MainActivity;
import com.favric.legal.R;
import com.github.barteksc.pdfviewer.PDFView;


public class Garantia_legal extends Base {


    private ImageView button1;

    private PDFView pdfView;
    private ImageView button2;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garantia_legal);
        pdfView = findViewById(R.id.garantiapdf);

        // Reemplaza "nombre_del_archivo.pdf" con la ubicación de tu archivo PDF
        Utils.loadPdf("monitoreo.pdf" , pdfView , this );

        button1 = findViewById(R.id.ButtonRetrocesoGarantia);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(Garantia_legal.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button2 = findViewById(R.id.logoretro_garantia);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(Garantia_legal.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}


