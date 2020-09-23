package com.example.asuper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int tas;
    int kagit;
    int makas;
    int bilgisayar;
    Button button1;
    Button button2;
    Button button3;
    TextView textView;
    TextView textView2;
    TextView sayacTextView;
    int puan;
    int bspuan;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView4);
        textView2=findViewById(R.id.textView);
        sayacTextView=findViewById(R.id.sayacTextView);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        tas=1;
        kagit=2;
        makas=3;
        puan=0;
        bspuan=0;
        countDownTimer=new CountDownTimer(10000,1000){
            public void onTick(long millisUntilFinished){
                sayacTextView.setText("kalan süre:" +millisUntilFinished/1000 );
            }

            @Override
            public void onFinish() {
                sayacTextView.setText("süre bitti");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);

                if (puan>=bspuan){
                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("İKİNCİ LEVELE GEÇMEYE HAK KAZANDINIZ");
                    alert.setMessage("İKİNCİ LEVELE GEÇMEK İSTER MİSİNİZ?");
                    alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"2.levele geçildi",Toast.LENGTH_LONG).show();
                            Intent niyet=new Intent();
                            niyet.setClass(MainActivity.this,Main2Activity.class);
                            startActivity(niyet);
                        }
                    });
                    alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"GEÇİLMEDİ",Toast.LENGTH_LONG).show();
                        }
                    });
                    alert.show();
                }
                if(puan<bspuan){

                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("kaybettiniz");
                    alert.setMessage("TEKRAR OYNAMAK İSTER MİSİNİZ?");
                    alert.setPositiveButton("evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            button1.setEnabled(true);
                            button2.setEnabled(true);
                            button3.setEnabled(true);
                            Intent in=getIntent();
                            finish();
                            startActivity(in);
                        }
                    });
                    alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"BURAYA KADAR :(", Toast.LENGTH_LONG).show();
                        }
                    });
                    alert.show();}
            }
        }.start();
    }
    public void tasicin(View view){
        Random rnd=new Random();
        bilgisayar= rnd.nextInt(4)+0;
        if(bilgisayar==tas){
            textView.setText("berabere");
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
        if (bilgisayar==2){
            textView.setText("yenildiniz");
            bspuan=bspuan+1;
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
        if(bilgisayar==3){
            textView.setText("yendiniz");
            puan=puan+1;
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }

    }
    public void kagiticin(View view){
        Random rnd=new Random();
        bilgisayar= rnd.nextInt(4)+0;
        if(bilgisayar==1){
            textView.setText("yendiniz");
            puan=puan+1;
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
        if(bilgisayar==kagit){
            textView.setText("berabere");
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
        if(bilgisayar==3){
            textView.setText("yenildiniz");
            bspuan=bspuan+1;
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
    }
    public void makasicin(View view){
        Random rnd=new Random();
        bilgisayar= rnd.nextInt(4)+0;
        if(bilgisayar==1){
            textView.setText("yenildiniz");
            bspuan=bspuan+1;
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
        if(bilgisayar==2){
            textView.setText("yendiniz");
            puan=puan+1;
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
        if(bilgisayar==makas){
            textView.setText("berabere");
            textView2.setText("Siz"+puan+"- pc"+bspuan);
        }
    }


}
