package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends AppCompatActivity {
    public TextView n,ac,ID,Current_bal ;
    private int current_bal;
    // private EditText wth;
    public Button btn,bttn;
    MainActivity bal = new MainActivity();
    //int d= bal.CurBal();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_account);
//        current_bal= 1000;
        n = (TextView) findViewById(R.id.t3);
        ac = (TextView) findViewById(R.id.t2);
        ID = (TextView) findViewById(R.id.t1);
        Current_bal = (TextView) findViewById(R.id.tv1);
        Current_bal.setText(String.valueOf(bal.CurBal()));


        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME2);
        n.setText(name);
        String acc = intent.getStringExtra(MainActivity.EXTRA_NAME);
        ac.setText(acc);
        String Id = intent.getStringExtra(MainActivity.EXTRA_NAME1);
        ID.setText(Id);
//        String bal = intent.getStringExtra(String.valueOf(MainActivity.EXTRA_NAME5));
//        Current_bal.setText(bal);

//        current_bal= 1000;
//        Current_bal.setText(current_bal);

        btn=(Button) findViewById(R.id.ab1);
        EditText wth=(EditText) findViewById(R.id.te1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                double x= Double.parseDouble(String.valueOf(wth));
                int x= Integer.parseInt((wth.getText().toString()));


                int a =(bal.CurBal()-x);
                if (a <= 999) {
                    Toast.makeText(Account.this,"Withdrawal failed",Toast.LENGTH_LONG).show();


                }
                else{
                    Toast.makeText(Account. this,"withdrawal successful",Toast.LENGTH_LONG).show();

                    Current_bal.setText(String.valueOf(a));
                }
            }

        });
        bttn=(Button) findViewById(R.id.dp);
        EditText dep=(EditText) findViewById(R.id.d0);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Austine = Integer.parseInt((dep.getText().toString()));
                int q=bal.CurBal()+Austine;

                Current_bal.setText(String.valueOf((q)));
            }
        });


    }
}