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
    //String fileUrl, src;
    Bitmap bitmap;
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

        //loadImageFromURL();
        //getBitmapFromURL(src);

//        cari.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new LoadImage().execute(fileUrl);
//                Glide.with(CariGambarActivity.this).load(pencarian.getText().toString()).into(foto);
    }
    public void search(View view) {loadImagetInit();
    }

    private void loadImagetInit() {
        String ImgUrl = pencarian.getText().toString();
        //AsyncTask mencari gambar di internet
        new loadImage().execute(ImgUrl);
    }

    private class loadImage extends AsyncTask<String, Void, Bitmap> {
        //method ketika proses asynctask belum dimulai
        @Override
        protected void onPreExecute() { //awal dari pengerjaan dalam menampilkan loading
            super.onPreExecute();

            // Membuat Progress Dialog
            pDialog = new ProgressDialog(CariGambarActivity.this);

            // Judul Progress Dialog
            pDialog.setTitle("Downloading image");

            // Seting message Progress Dialog
            pDialog.setMessage("Loading...");

            // menampilkan Progress Dialog
            pDialog.show();
        }
        //method saat proses asynctask dijalankan
        @Override
        protected Bitmap doInBackground(String... params) { //apa yang sedang terjadi ketika dijalankan memasukkan data ke list view
            Bitmap a = null;
            try {
                //download gambar dr url
                URL x = new URL(params[0]);
                //konversi gambar ke bitmap (decode to bitmap)

                a = BitmapFactory.decodeStream((InputStream) x.getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return a;
        }

        //method sesudah asynctask sudah dijalankan
        @Override
        protected void onPostExecute(Bitmap a) { // akhir dari pengerjaan ketika di klik lg button maka akan menampilkan gambar yang telah dicari
            super.onPostExecute(a);
            //menampung gambar ke imageview dan menampilkan
            foto.setImageBitmap(a);
            //menghilangkan progress dialog
            pDialog.dismiss();
        }
    }
}


    /*public Bitmap getBitmapFromURL(String src) {
        try
        {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CariGambarActivity.this);
            pDialog.setMessage("Loading Image...");
            pDialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null){
                ImageView img = new ImageView(CariGambarActivity.this);
                img.setImageBitmap(bitmap);
                pDialog.dismiss();
            }else{

                pDialog.dismiss();
                Toast.makeText(CariGambarActivity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }
    public boolean loadImageFromURL(){
        try {


            URL myFileUrl = new URL (fileUrl);
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setDoInput(true);
            conn.connect();

            InputStream is = conn.getInputStream();

            foto.setImageBitmap(BitmapFactory.decodeStream(is));

            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }*/

