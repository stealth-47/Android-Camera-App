package com.example.bank;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
//import android.database.Cursor;//// /
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
//import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
//    Account bal= new Account();
    private Customer Customer;
    private Account bank;
    private Deposit deposit;
    private EditText Name;
    private EditText ID;
    private EditText Gender;
    private EditText DOB;
    private EditText Age;
    private EditText AccNo;
    private EditText txtAmount;
    private EditText txtBalance;
    private Button button;
    private int dp;
    private int cb= 1000;
//    private double current_bal;
//    private double Current_bal= 1000.00;
//    private RadioButton radChecking;
//    private RadioButton radSavings;

    DatabaseReference DB;
    public static final String EXTRA_NAME = "Acc", EXTRA_NAME1 = "IDNo", EXTRA_NAME2 = "name";

    //    public static final double EXTRA_NAME5= Double.parseDouble("Cur");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        current_bal= 1000.00;
        Name = (EditText) findViewById(R.id.et1);
        ID = (EditText) findViewById(R.id.et2);
        Gender = (EditText) findViewById(R.id.et3);
        DOB = (EditText) findViewById(R.id.et4);
        Age = (EditText) findViewById(R.id.et5);
        AccNo = (EditText) findViewById(R.id.et6);
        button = (Button) findViewById(R.id.b1);
        this.bank = new Account();

        AccNo = findViewById(R.id.et6);

        // txtAmount = findViewById(R.id.t1);
        // txtBalance = findViewById(R.id.txtBalance);
        // radChecking = findViewById(R.id.radChecking);
        // radSavings = findViewById(R.id.radSavings);

        // FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference DB = database.getReference("Customer");
        DB = FirebaseDatabase.getInstance("https://bank-732b9-default-rtdb.firebaseio.com/").getReference().child("customer");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ButtonText = button.getText().toString();
                if (ButtonText.equals("Submit")) {
                    List<String> firebase = new ArrayList<String>();
                    firebase.add((Name.getText().toString()));
                    firebase.add((ID.getText().toString()));
                    firebase.add((Gender.getText().toString()));
                    firebase.add((DOB.getText().toString()));
                    firebase.add((Age.getText().toString()));
                    firebase.add((AccNo.getText().toString()));
                    DB.setValue(firebase);


                    Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_LONG).show();
                    button.setText("Next");

                } else {
                    Name = (EditText) findViewById(R.id.et1);
                    AccNo = (EditText) findViewById(R.id.et6);
                    ID = (EditText) findViewById(R.id.et5);
                    String name = Name.getText().toString();
                    String Acc = AccNo.getText().toString();
                    String IDNo = ID.getText().toString();

                    Intent intent = new Intent(MainActivity.this, Account.class);
                    intent.putExtra(EXTRA_NAME, Acc);
                    intent.putExtra(EXTRA_NAME1, IDNo);
                    intent.putExtra(EXTRA_NAME2, name);
//                    intent.putExtra(String.valueOf(EXTRA_NAME5), current_bal);

                    startActivity(intent);


                }
            }
        });

    }
    public int CurBal() {

        return cb;
    }

    public int deposit(){

        return dp;
    }

   public int newbal(int q){
        cb=  cb+ dp;
       return cb;
   }
}


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        this.bank = new Account();
//
//        AccNo = findViewById(R.id.et6);
//        txtAmount = findViewById(R.id.txtAmount);
//        txtBalance = findViewById(R.id.txtBalance);
//        radChecking = findViewById(R.id.radChecking);
//        radSavings = findViewById(R.id.radSavings);
//    }


//    public void doWithdraw(View view) {
//
//        try
//        {
//            int accountNumber = Integer.parseInt(AccNo.getText().toString());
//            double amount = Double.parseDouble(txtAmount.getText().toString());
//
//            if(bank.withdraw(accountNumber, amount)) {
//                Toast.makeText(this, "Transaction Successful!", Toast.LENGTH_LONG).show();
//                this.txtBalance.setText(String.format("$%.2f", bank.getAccount(accountNumber).getBalance()));
//                txtAmount.setText("");
//            } else {
//                Toast.makeText(this, "Transaction failed", Toast.LENGTH_LONG).show();
//            }
//
//        } catch(Exception e) {
//            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//    public void doDeposit(View view) {
//
//        try
//        {
//            int accountNumber = Integer.parseInt(AccNo.getText().toString());
//            double amount = Double.parseDouble(txtAmount.getText().toString());
//
//            if(bank.deposit(accountNumber, amount)) {
//                Toast.makeText(this, "Transaction Successful!", Toast.LENGTH_LONG).show();
//                this.txtBalance.setText(String.format("$%.2f", bank.getAccount(accountNumber).getBalance()));
//                txtAmount.setText("");
//            } else {
//                Toast.makeText(this, "Transaction failed", Toast.LENGTH_LONG).show();
//            }
//
//        } catch(Exception e) {
//            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//
//    public void checkBalance(View view) {
//
//        try
//        {
//            int accountNumber = Integer.parseInt(AccNo.getText().toString());
//            this.txtBalance.setText(String.format("$%.2f", bank.getAccount(accountNumber).getBalance()));
//            txtAmount.setText("");
//        } catch(Exception e) {
//            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
//        }
//
//    }
//

//    public void createAccount(View view) {
//
//        Account account = null;
//
//        // check radiobutton selection
//        if(this.radChecking.isChecked()) {
//            account = new CheckingAccount(bank.getNextAccountNumber(), 1.75);
//        } else {
//            account = new SavingsAccount(bank.getNextAccountNumber(), 0.05);
//        }
//
//        bank.addAccount(account);
//
//        // notify user
//        Toast.makeText(this, "Account has been created - Account Number: " + account.getAccountNumber(),
//                Toast.LENGTH_LONG).show();
//
//        txtAmount.setText("");
//        txtBalance.setText("");
//        AccNo.setText("");
//    }


//    public void insertCustomerData() {
//        DB.setValue(Name.getText().toString());
//        Name.setText("");
//        DB.setValue(ID.getText().toString());
//        ID.setText("");
//        DB.setValue(Gender.getText().toString());
//        Gender.setText("");
//        DB.setValue(DOB.getText().toString());
//        DOB.setText("");
//        DB.setValue(Age.getText().toString());
//        Age.setText("");
//        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_LONG).show();
//        DB.setValue(AccNo.getText().toString());
//        AccNo.setText("");
//
////        Customer customer = new Customer(name, IDNo, gender, Dob, age, AccNO);
////        DB.push().setValue(customer);
//        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_LONG).show();
//    }





