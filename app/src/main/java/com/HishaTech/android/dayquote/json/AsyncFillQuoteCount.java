package com.HishaTech.android.dayquote.json;

import com.HishaTech.android.dayquote.db.FillTable;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by smithkev on 1/28/2015.
 */
public class AsyncFillQuoteCount extends AsyncTask<Context, Void, Void> {
    Context mCtx;

    public AsyncFillQuoteCount(Context context) {
        mCtx = context;
    }

    @Override
    protected Void doInBackground(Context... params) {
        FillTable.QuoteCount(mCtx);
        return null;
    }

}
