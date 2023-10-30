package com.favric.legal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.favric.legal.Clases.Base;
import com.favric.legal.Clases.QrClass;
import com.favric.legal.vistas.Clases.Derechos_usuario;
import com.favric.legal.vistas.Clases.Encargado_sucursal;
import com.favric.legal.vistas.Clases.Garantia_legal;
import com.favric.legal.vistas.Clases.Reglamento_servicio;





public class MainActivity extends Base {

    Bitmap bitmapImage = null;
    private AudioManager audioManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        increaseVolumeToMax();
        detectButton(this);

    }

    private void detectButton(Context context) {
        Button btn_redireccionar1 = findViewById(R.id.btn_redireccionar10);
        Button btn_redireccionar2 = findViewById(R.id.btn_redireccionar20);
        Button btn_redireccionar3 = findViewById(R.id.btn_redireccionar30);
        Button btn_redireccionar4 = findViewById(R.id.btn_redireccionar40);

        QrClass qrClass = new QrClass("+56965928948","Hola , como estas ") ;
        bitmapImage = qrClass.getQr(context);
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
    private void increaseVolumeToMax() {
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
    }
}