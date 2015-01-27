package android.HishaTech.com.dayquote.json;

import android.HishaTech.com.dayquote.R;
import android.HishaTech.com.dayquote.db.model.FillTable;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by smithkev on 1/27/2015.
 */
public class AsyncFillCategory extends AsyncTask<Context, Void, String> {
    Context mCtx;

    public AsyncFillCategory(Context context) {
        mCtx = context;
    }

    @Override
    protected String doInBackground(Context... params) {
        FillTable.Categories(mCtx);
        return "true";
    }

    @Override
    protected void onPostExecute(String truefalse) {
        Toast.makeText(mCtx, R.string.toast_update_category,
                Toast.LENGTH_SHORT).show();
    }
}