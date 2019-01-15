package com.example.jamie.converter;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class numBitContent extends Activity {

    EditText editText2;
    Button CONVERTER2;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbitcontent);

        editText2 = (EditText) findViewById(R.id.editText1);
        CONVERTER2 = (Button) findViewById(R.id.CONVERTER1);
        result2 = (TextView) findViewById(R.id.result);

        CONVERTER2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int decimal = Integer.parseInt(editText2.getText().toString());
                ConverterObject decConv = new ConverterObject(decimal, true);

                result2.setText(decConv.convert());
            }
        });
    }



}
