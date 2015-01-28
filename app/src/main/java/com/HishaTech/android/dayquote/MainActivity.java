package com.HishaTech.android.dayquote;

import com.HishaTech.android.dayquote.db.model.Author;
import com.HishaTech.android.dayquote.db.model.Quote;
import com.HishaTech.android.dayquote.db.table.table_Author;
import com.HishaTech.android.dayquote.db.table.table_Quote;
import com.HishaTech.android.dayquote.json.AsyncFillAuthor;
import com.HishaTech.android.dayquote.json.AsyncFillCategory;
import com.HishaTech.android.dayquote.json.AsyncFillQuote;
import com.HishaTech.android.dayquote.json.AsyncFillQuoteCategory;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    TextView txtQuote, txtAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuote = (TextView) findViewById(R.id.txtQuote);
        txtAuthor = (TextView) findViewById(R.id.txtAuthor);

        //TODO: Need code to check if local quote count is zero and not try
        // to display quote.
        Utils.checkQuoteCountUpToDate(this);

        Quote quote = new Quote();
        Author author = new Author();

        //TODO: Need code to set category by user input.
        quote = table_Quote.getRandomQuote(this, 0);
        author = table_Author.getAuthorById(this, quote.getAuthorId());

        txtQuote.setText(quote.getQuote());

        txtAuthor.setClickable(true);
        txtAuthor.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='" + author.getWikiLink() + "'> " + author
                .getFirstName() + " " + author.getLastName() +
                " </a>";
        txtAuthor.setText(Html.fromHtml(text));

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

                    AsyncFillAuthor afa = new AsyncFillAuthor(this);
                    afa.execute();
                    AsyncFillCategory afc = new AsyncFillCategory(this);
                    afc.execute();
                    AsyncFillQuote afq = new AsyncFillQuote(this);
                    afq.execute();
                    AsyncFillQuoteCategory afqc = new AsyncFillQuoteCategory(this);
                    afqc.execute();

                }
                break;
        }
        return false; // should never happen
    }
}