package com.example.asuper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    EditText editText9;
    Button button;
    TextView textView2;
    boolean puan1;
    boolean puan2;
    boolean puan3;
    boolean puan4;
    boolean puan5;
    boolean puan6;
    boolean puan7;
    boolean puan8;
    int puan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent niyet=getIntent();
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        editText6=findViewById(R.id.editText6);
        editText7=findViewById(R.id.editText7);
        editText8=findViewById(R.id.editText8);
        editText9=findViewById(R.id.editText9);
        button=findViewById(R.id.button);
        textView2=findViewById(R.id.textView2);
        puan=0;
        textView.setText("Aşağıdaki istediğiniz bölgelere s veya o harflerini yerleştiriniz");

    }
    public void kontrol(View view){

        if("s".equals(editText.getText().toString())&&"o".equals(editText2.getText().toString())&&"s".equals(editText3.getText().toString()))
        {

            if(!puan1)
            {
                puan=puan+1;
                puan1=true;
            }



        }
        if("s".equals(editText4.getText().toString())&&"o".equals(editText5.getText().toString())&&"s".equals(editText6.getText().toString()))
        {
            if(puan2==true){
                puan=puan+0;

            }
            else {
                puan=puan+1;
                puan2=true;

            }

        }
        if("s".equals(editText7.getText().toString())&&"o".equals(editText8.getText().toString())&&"s".equals(editText9.getText().toString()))
        {
            if(puan3==true){
                puan=puan+0;

            }
            else {
                puan=puan+1;
                puan3=true;

            }

        }
        if("s".equals(editText.getText().toString())&&"o".equals(editText4.getText().toString())&&"s".equals(editText7.getText().toString()))
        {
            if(puan4==true){
                puan=puan+0;

            }
            else {
                puan=puan+1;
                puan4=true;

            }

        }
        if("s".equals(editText2.getText().toString())&&"o".equals(editText5.getText().toString())&&"s".equals(editText8.getText().toString()))
        {
            if(puan5==true){
                puan=puan+0;

            }
            else {
                puan=puan+1;
                puan5=true;

            }

        }
        if("s".equals(editText3.getText().toString())&&"o".equals(editText6.getText().toString())&&"s".equals(editText9.getText().toString()))
        {
            if(puan6==true){
                puan=puan+0;

            }
            else {
                puan=puan+1;
                puan6=true;

            }

        }
        if("s".equals(editText.getText().toString())&&"o".equals(editText5.getText().toString())&&"s".equals(editText9.getText().toString()))
        {
            if(puan7==true){
                puan=puan+0;

            }
            else {
                puan=puan+1;
                puan7=true;

            }

        }
        if("s".equals(editText3.getText().toString())&&"o".equals(editText5.getText().toString())&&"s".equals(editText7.getText().toString()))
        {
            if(puan8==true){
                puan=puan+0;

            }
            else {
                puan = puan + 1;
                puan8 = true;

            }

        }
        else {
            puan=puan+0;
        }

        textView.setText("PUANINIZ: "+String.valueOf(puan));
        if(puan>=4)
        {
            textView2.setText("Bu Leveli Başarı İle Geçtiniz");
            Intent intentson=new Intent(Main3Activity.this,Main4Activity.class);
            startActivity(intentson);

        }
        else
        {
            textView2.setText("Bu Leveli Geçemediniz ");
            AlertDialog.Builder alert=new AlertDialog.Builder(Main3Activity.this);
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
                    Toast.makeText(Main3Activity.this,"BURAYA KADAR :(", Toast.LENGTH_LONG).show();
                }
            });
            alert.show();
        }

    }

}
