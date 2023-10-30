package com.favric.legal.vistas.Clases;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.favric.legal.Clases.Base;
import com.favric.legal.Clases.Utils;
import com.favric.legal.MainActivity;
import com.favric.legal.R;
import com.github.barteksc.pdfviewer.PDFView;


public class Reglamento_servicio extends Base {

    final int[] pageNumber = {0}; //start page number for pdf buttons
    private ImageView button1;
    private ImageView button2;
    private PDFView pdfView ;

    private ImageView button3;

    private ImageView button4;

    private ScrollView nestedScrollView;

    private GestureDetector gestureDetector;
    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reglamento_servicio);

        pdfView = findViewById(R.id.reglamento_pdf);
        button1 = findViewById(R.id.btn_retroceso_usuario);


        Utils.loadPdf("reglamento_servicios.pdf" , pdfView , this );
        final int[] pageNumber = {0}; //start page number for pdf buttons


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(Reglamento_servicio.this, MainActivity.class);
                startActivity(intent);
            }

        });
        button2 = findViewById(R.id.btn_back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(Reglamento_servicio.this, MainActivity.class);
                startActivity(intent);
            }
        });





    }




}
