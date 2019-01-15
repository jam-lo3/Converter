package com.example.jamie.converter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.DecimalFormat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ConverterObject {

    int[] numList = new int[3];
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    int number;
    boolean isNum;
    public ConverterObject(int num, boolean isNum)
    {
        number = num;
        this.isNum= isNum;


    }



    public String convert()
    {
        String section;
        if(isNum)
            section = "NumSystem";
        else
            section = "measSystem";

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference(section);

        DecimalFormat shorten = new DecimalFormat("0.00");
        String result = "Nothing here";

        if(isNum) {
            String binary = Integer.toBinaryString(number);
            String oct = Integer.toOctalString(number);
            String hex = Integer.toHexString(number);

            result = "Decimal: " + number + "\n\n" +
                    "Binary: " + binary + "\n\n" +
                    "Octal: " + oct + "\n\n" +
                    "Hexadecimal: " + hex;
        }

        if(!isNum)
        {
            double miles = ((double)number);
            double feet = 5280.0 * number;
            double meters = number *1609.344;
            double kilometers = miles / 0.62137;

            result = "Miles: " + number + "\n\n" +
                    "Feet: " + shorten.format(feet) + "\n\n" +
                    "Meters: " + shorten.format(meters)+ "\n\n" +
                    "Kilometers: " + shorten.format(kilometers)
            + "\n\n\n";
        }

        myRef.child(section).push().setValue(number);
        final Query q = myRef;

        q.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return result;
    }
}
