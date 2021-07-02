package com.example.makeitrain1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private TextView moneyValue;
    private int moneyCounter = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button makeItRain = findViewById(R.id.buttonMakeItRain);
        Button showInfo = findViewById(R.id.buttonShowInfo);
        moneyValue = findViewById(R.id.moneyValue);

        makeItRain.setOnClickListener(v -> {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            moneyCounter += 1000;
            moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
            switch (moneyCounter) {
                case 20000:
                    moneyValue.setTextColor(getResources().getColor(R.color.teal_200));
                    break;
                case 30000:
                    moneyValue.setTextColor(getResources().getColor(R.color.teal_700));
                    break;
                case 40000:
                    moneyValue.setTextColor(getResources().getColor(R.color.red));
                    break;
                default:
                    moneyValue.setTextColor(Color.WHITE);
            }
        });

        showInfo.setOnClickListener(v -> {
//            Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT).show();

            Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                    .setAction("More", v1 -> {
                    })
                    .show();
        });
    }
}