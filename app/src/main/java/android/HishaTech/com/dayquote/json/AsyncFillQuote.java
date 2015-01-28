package android.HishaTech.com.dayquote.json;

import android.HishaTech.com.dayquote.R;
import android.HishaTech.com.dayquote.db.model.FillTable;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by smithkt on 1/27/15.
 */
public class AsyncFillQuote extends AsyncTask<Context, Void, String> {
    Context mCtx;

    public AsyncFillQuote(Context context) {
        mCtx = context;
    }

    @Override
    protected String doInBackground(Context... params) {
        FillTable.Quote(mCtx);
        return "true";
    }

    @Override
    protected void onPostExecute(String truefalse) {
        Toast.makeText(mCtx, R.string.toast_update_quote,
                Toast.LENGTH_SHORT).show();
    }
}