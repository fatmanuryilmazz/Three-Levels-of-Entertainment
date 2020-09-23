package com.example.asuper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    int puanınız;
    TextView puanTV;
    TextView sureTV;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent ıntent=getIntent();
        puanınız=0;
        sureTV=findViewById(R.id.textView6);
        puanTV=findViewById(R.id.textView7);
        imageView1=findViewById(R.id.imageView);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        imageArray=new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,
                imageView8,imageView9};
        resimGizle();
        new CountDownTimer(10000,1000){
            public void onTick(long millisUntilFinished){
                sureTV.setText("KALAN SÜRE:"+millisUntilFinished/1000);
            }
            public void onFinish(){
                sureTV.setText("SÜRE DKOLDU");
                handler.removeCallbacks(runnable);
                sirinlerigizle();
                if(puanınız>=5){
                    AlertDialog.Builder alert=new AlertDialog.Builder(Main2Activity.this);
                    alert.setTitle("ÜÇÜNCÜ LEVELE GEÇMEYE HAK KAZANDINIZ");
                    alert.setMessage("ÜÇÜNCÜ LEVELE GEÇMEK İSTER MİSİNİZ?");
                    alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"3.levele geçildi",Toast.LENGTH_LONG).show();
                            Intent ni=new Intent();
                            ni.setClass(Main2Activity.this,Main3Activity.class);
                            startActivity(ni);
                        }
                    });
                    alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Main2Activity.this,"GEÇİLMEDİ",Toast.LENGTH_LONG).show();

                        }
                    });
                    alert.show();
                }
                if(puanınız<5){

                    AlertDialog.Builder alert=new AlertDialog.Builder(Main2Activity.this);
                    alert.setTitle("kaybettiniz");
                    alert.setMessage("TEKRAR OYNAMAK İSTER MİSİNİZ?");
                    alert.setPositiveButton("evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i=getIntent();
                            finish();
                            startActivity(i);
                        }
                    });
                    alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Main2Activity.this,"BURAYA KADAR :(", Toast.LENGTH_LONG).show();
                        }
                    });
                    alert.show();}
            }
        }.start();
    }
    public void puanlama(View view){
        puanınız=puanınız+1;
        puanTV.setText("puan"+puanınız);
    }
    private void sirinlerigizle(){
        for(ImageView imageView:imageArray){
            imageView.setVisibility(View.INVISIBLE);
        }

    }
    public void resimGizle(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                sirinlerigizle();
                Random r=new Random();
                int i=r.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,300);
            }
        };
        handler.post(runnable);
    }
}
