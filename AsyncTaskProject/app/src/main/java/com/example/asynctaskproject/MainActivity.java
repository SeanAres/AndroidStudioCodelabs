package com.example.asynctaskproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//My image: https://raw.githubusercontent.com/SeanAres/CS6392021/master/Westchester.jpg

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ImageDownloader img = new ImageDownloader(com.example.asynctaskproject.MainActivity.this);
              img.execute("https://raw.githubusercontent.com/SeanAres/CS6392021/master/Westchester.jpg");
            }
        });
    }
}