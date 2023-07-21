package com.favric.legal.vistas.Clases;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.favric.legal.Clases.Base;
import com.favric.legal.Clases.Subsidary;
import com.favric.legal.MainActivity;
import com.favric.legal.R;


public class Encargado_sucursal extends Base {

    private ImageView button1;
    private String TAG = "Subsidiary";
    private TextView contact ;
    private TextView address ;
    private TextView mail;
    public static MutableLiveData<Subsidary> subsidiaryLive = new MutableLiveData<>();
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encargado_sucursal);
        button1 = findViewById(R.id.imageView3);
        contact = findViewById(R.id.contactName);
        address = findViewById(R.id.address);
        mail = findViewById(R.id.mail);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón 1
                Intent intent = new Intent(Encargado_sucursal.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //Observer subsidiary api
        subsidiaryLive.observe(this, new Observer<Subsidary>() {
            @Override
            public void onChanged(Subsidary changedValue) {
                if(changedValue==null)
                {
                    contact.setText("--------");
                    address.setText("------");
                    mail.setText("");
                }
                else {
                    contact.setText((changedValue.getContact()));
                    address.setText((changedValue.getAddress()));
                    if(changedValue.getContact_email()!=null)
                    {
                        mail.setText("(" + changedValue.getContact_email() + ")");
                    }
                }
            }
        });
        //Get subsidiary api
        Api api = new Api();
        api.getDevice(this);
    }
}
