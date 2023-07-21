package com.favric.legal.Clases;

import android.content.Context;
import android.text.Html;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String convertToUTF8(String text) {
        try {
            byte[] utf8Bytes = text.getBytes("UTF-8");
            return new String(utf8Bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String convertInputStreamToString(String text) {
        InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static String fixEncoding(String response) {
        try {
            byte[] u = response.toString().getBytes(
                    "ISO-8859-1");
            response = new String(u, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }

    public static void loadPdf(String nombreArchivo , PDFView pdfView , Context context)
    {

        pdfView.fromAsset(nombreArchivo)
                .defaultPage(0)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        // Aquí puedes manejar el cambio de página si es necesario
                    }
                })
                .enableAnnotationRendering(true)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        // Aquí puedes realizar acciones después de que el PDF haya sido cargado
                    }
                })
                .scrollHandle(new DefaultScrollHandle(context))
                .spacing(10) // Espaciado entre páginas en dp
                .autoSpacing(true) // Auto-ajustar el espaciado para adaptar el ancho de pantalla
                .pageFitPolicy(FitPolicy.BOTH)
                .pageSnap(true) // Hace que las páginas se ajusten al centro en lugar de desplazarse en el medio
                .nightMode(false) // Modo nocturno
                .load();

    }

}
