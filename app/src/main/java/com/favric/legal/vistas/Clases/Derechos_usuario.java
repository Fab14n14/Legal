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


public class Derechos_usuario extends Base {


    private ImageView button1;
    private ImageView button2;
    private PDFView pdfView;
    private ImageView button3;

    private ImageView button4;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.derechos_usuario);
        pdfView = findViewById(R.id.pdfusuario);
        button1 = findViewById(R.id.btn_retroceso_usuario);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(Derechos_usuario.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button2 = findViewById(R.id.btn_back);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógic for the  botón 2
                Intent intent = new Intent(Derechos_usuario.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Utils.loadPdf("derechos_usuario.pdf", pdfView, this);


    }


}