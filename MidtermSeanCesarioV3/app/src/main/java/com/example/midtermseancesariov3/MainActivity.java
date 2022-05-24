package com.example.midtermseancesariov3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mLitersInput;
    private TextView mCupsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLitersInput = findViewById(R.id.litersInput);
        mCupsText = findViewById(R.id.cupsText);
    }

    public void convertLiters(View view) {
        String queryString = mLitersInput.getText().toString();
        String litersString = mLitersInput.getText().toString();
        double litersInput;
        double cupsOutput;
        double conversionRate = 4.22;

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        if(!queryString.isEmpty()) {
            try {
                litersInput = Double.parseDouble(queryString);
                cupsOutput = litersInput * conversionRate;
                mCupsText.setText(litersString + " liters is " + String.valueOf(cupsOutput) + " cups");
            } catch (Exception e1) {
                e1.printStackTrace();
                mCupsText.setText("Please enter a numeric value");
            }
        }else {
            mCupsText.setText("Please enter a value");
        }
    }
}