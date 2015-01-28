package com.HishaTech.android.dayquote;

import com.HishaTech.android.dayquote.json.AsyncFillAuthor;
import com.HishaTech.android.dayquote.json.AsyncFillCategory;
import com.HishaTech.android.dayquote.json.AsyncFillQuote;
import com.HishaTech.android.dayquote.json.AsyncFillQuoteCategory;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.Toast;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (!Utils.DatabaseExists(this)) {

            if (!Utils.InternetUp(this)) {
                Toast.makeText(this, R.string.toast_initial_UpdateDb,
                        Toast.LENGTH_LONG).show();
                finish();
            } else {

                AsyncFillAuthor afa = new AsyncFillAuthor(this);
                afa.execute();
                AsyncFillCategory afc = new AsyncFillCategory(this);
                afc.execute();
                AsyncFillQuote afq = new AsyncFillQuote(this);
                afq.execute();
                AsyncFillQuoteCategory afqc = new AsyncFillQuoteCategory(this);
                afqc.execute();

                int myTimer = 1000;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SplashActivity.this,
                                MainActivity.class);
                        startActivity(i);
                        finish(); // close this activity
                    }
                }, myTimer);

            }

        } else {

            int myTimer = 3000;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish(); // close this activity
                }
            }, myTimer);

        }

    }

}
