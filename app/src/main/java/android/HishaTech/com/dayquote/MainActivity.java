package android.HishaTech.com.dayquote;

import android.HishaTech.com.dayquote.json.AsyncFillCategory;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.About:
                Intent Aboutintent = new Intent(this, AboutActivity.class);
                this.startActivity(Aboutintent);
                break;
            case R.id.UpdateDb:
                if (!Utils.InternetUp(this)) {
                    Toast.makeText(this, R.string.toast_updateDb,
                            Toast.LENGTH_LONG).show();
                } else {

                    AsyncFillCategory afc = new AsyncFillCategory(this);
                    afc.execute();

                }
                break;
        }
        return false; // should never happen
    }
}