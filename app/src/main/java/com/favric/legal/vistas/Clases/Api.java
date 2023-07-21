package com.favric.legal.vistas.Clases;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.favric.legal.Clases.Shared;
import com.favric.legal.Clases.Subsidary;
import com.favric.legal.Clases.Utils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Api {
    private String TAG = "API";
    public void getDevice(Context context) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String token ="QWRzY3JlZW46MzU3MzU3YWtzLi4u";
        String url = "https://pdv.rinnolab.cl/api/pdv/device_subsidiary/?device_code=C203920522";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        response= Utils.fixEncoding(response);
                        Gson gson = new Gson();
                        Subsidary subsidary = gson.fromJson(response , Subsidary.class);
                        Encargado_sucursal.subsidiaryLive.setValue(subsidary);
                        Shared.setValuesPreference(context, "data" , response );
                        Log.d(TAG, "hola");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(Shared.getValuesPreference(context, "data")!=null )
                        {
                            Gson gson = new Gson();
                            Subsidary subsidary = gson.fromJson(Shared.getValuesPreference(context,"data") , Subsidary.class);
                            Encargado_sucursal.subsidiaryLive.setValue(subsidary);
                        }
                        else
                        {
                            Encargado_sucursal.subsidiaryLive.setValue(null);
                            Log.e("Error", error.toString());
                        }

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Basic " + token);
                return headers;
            }
        };
        requestQueue.add(stringRequest);
    }
}
