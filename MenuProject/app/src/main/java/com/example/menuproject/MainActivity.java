package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.help_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.help_menu){
            Intent helpIntent = new Intent(MainActivity.this,
                    HelpActivity.class);
            startActivity(helpIntent);

            return false;
        }
         return super.onOptionsItemSelected(item);
    }

    public void openWebsite(View view) {
        Uri webpage = Uri.parse("https://www.youtube.com/watch?v=D4uvwes-Qx8&ab_channel=TheFishingLlama666TheFishingLlama666");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        try {
            startActivity(webIntent);
        } catch (ActivityNotFoundException e) {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openMap(View view) {
        Uri location = Uri.parse("geo:0,0?q=1980+Crompond+Rd,+Cortlandt,+New York");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        try {
            startActivity(mapIntent);
        } catch (ActivityNotFoundException e){
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openPhone(View view) {
        Uri number = Uri.parse("tel:6663334444");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        try {
            startActivity(callIntent);
        } catch (ActivityNotFoundException e) {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openSMS(View view) {
        Uri number = Uri.parse("sms:6663334444");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW, number);
        smsIntent.putExtra("sms_body", "Please help me");
        try {
            startActivity(smsIntent);
        } catch (ActivityNotFoundException e) {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

//    public void openChooser(View view){
//        Intent chooserIntent = new Intent(Intent.ACTION_SEND);
//        String title = getResources().getString(R.string.chooser_title);
//        Intent chooser = Intent.createChooser(chooserIntent, title);
//        try {
//            startActivity(chooser);
//        } catch (ActivityNotFoundException e) {
//            Log.d("ImplicitIntents", "Can't handle this intent!");
//        }
//    }

    public void shareText(View view) {
        String txt = "Share the love";
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooser_title)
                .setText(txt)
                .startChooser();
    }


    public void openActivity(View view) {
        Intent newIntent = new Intent(MainActivity.this,
                NewActivity.class);
        try {
            startActivity(newIntent);
        } catch (ActivityNotFoundException e) {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}