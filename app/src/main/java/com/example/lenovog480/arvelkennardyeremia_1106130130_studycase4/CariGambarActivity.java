package com.example.lenovog480.arvelkennardyeremia_1106130130_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;

public class CariGambarActivity extends AppCompatActivity {

    EditText pencarian;
    Button cari;
    ImageView foto;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);//akan tergabung ke layout mana

        //Mendefinisikan gambar dan edittext pada layout activity cari gambar
        getSupportActionBar().hide();
        pencarian = (EditText) findViewById(R.id.edtCariGamber);
        cari = (Button) findViewById(R.id.btnCari);
        foto = (ImageView) findViewById(R.id.gambar);


    }
    public void search(View view) {
        foto = (ImageView)findViewById(R.id.gambar);
        pencarian = (EditText)findViewById(R.id.edtCariGamber);

        String urlGambar = pencarian.getText().toString();
//        String iki = "https://www.google.co.id/imgres?imgurl=https%3A%2F%2Fstatic1.squarespace.com%2Fstatic%2F5a60c63090badeabae267f0c%2Ft%2F5a6a42ed9140b7f06fc4a336%2F1516913392661%2Fwaitlogo-01.png&imgrefurl=https%3A%2F%2Fwww.annaweddle.com%2Fwait%2F&docid=NALzdduGvBKh4M&tbnid=xjuZo5ZxCXnBkM%3A&vet=12ahUKEwi6sb3b6PXZAhWJqI8KHVBEAXo4ZBAzKC8wL3oECAAQMQ..i&w=792&h=525&bih=675&biw=1366&q=wait%20logo&ved=2ahUKEwi6sb3b6PXZAhWJqI8KHVBEAXo4ZBAzKC8wL3oECAAQMQ&iact=mrc&uact=8";
//        String salah = "https://www.google.co.id/imgres?imgurl=https%3A%2F%2F61978.apps.zdusercontent.com%2F61978%2Fassets%2F1506471217-f11f72e1d66993b37ef07602ecff83f2%2Flogo.png&imgrefurl=https%3A%2F%2Fwww.zendesk.com%2Fapps%2Fsupport%2Foops%2F&docid=8oH5MlpL36WPXM&tbnid=4ccrvp2ZZD8y3M%3A&vet=10ahUKEwjX5NP-6PXZAhXBq48KHQrmDGIQMwhOKBUwFQ..i&w=320&h=320&bih=675&biw=1366&q=oops%20logo&ved=0ahUKEwjX5NP-6PXZAhXBq48KHQrmDGIQMwhOKBUwFQ&iact=mrc&uact=8"
        Glide.with(CariGambarActivity.this)
                // LOAD URL DARI INTERNET
                .load(urlGambar)
                // LOAD GAMBAR AWAL SEBELUM GAMBAR UTAMA MUNCUL, BISA DARI LOKAL DAN INTERNET
                .placeholder(R.drawable.iki)
                //. LOAD GAMBAR SAAT TERJADI KESALAHAN MEMUAT GMBR UTAMA
                .error(R.drawable.salah)
                .into(foto);
    }

