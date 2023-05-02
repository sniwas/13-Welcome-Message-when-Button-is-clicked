package com.example.welcomemessagewhenbuttonisclicked;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    TextView tv;
    AlertDialog.Builder adb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb=new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("It is our great pleasure to have you on board! A hearty welcome to you!")
                        .setTitle("Welcome's You").setCancelable(false);
                adb.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                tv.setText("Thankyou for proceeding with our application");
                            }
                        });
                adb.setNegativeButton("Exit",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface di,int i){
                        finish();
                        Toast.makeText(MainActivity.this, "Thankyou! Have a great day", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog=adb.create();
                alertDialog.show();
            }
        });

    }
}