package com.example.bank;
import com.google.firebase.database.IgnoreExtraProperties;
import java.util.ArrayList;
import java.util.List;
public class Customer {
    private   String Name;
    private int IDNo;
    private String Gender;
    private String dob;
    private int Age;
    private int AccNo;


    public Customer( String name, int IDno, String gender, String DOB, int age, int accNo) {
        this.Name = name;
        this.IDNo = IDno;
        this.Gender = gender;
        this.dob = DOB;
        this.Age = age;
        this.AccNo = accNo;
    }

    public String getName ()
    {return Name;}

    public int getIDNo() {

        return IDNo;
    }

    public String getGender() {

        return Gender;
    }

    public String getD0B() {
        return dob;
    }

    public int getAge() {
        return Age;
    }

    public int getAccNo() {
        return AccNo;
    }

}


