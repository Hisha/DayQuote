package android.HishaTech.com.dayquote;

import android.HishaTech.com.dayquote.json.AsyncFillCategory;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class SplashActivity extends ActionBarActivity {

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

                AsyncFillCategory afc = new AsyncFillCategory(this);
                afc.execute();

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

            int myTimer = 5000;
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
