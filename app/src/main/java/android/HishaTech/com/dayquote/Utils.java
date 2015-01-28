package android.HishaTech.com.dayquote;

import android.HishaTech.com.dayquote.db.DbConstants;
import android.HishaTech.com.dayquote.db.table.table_Quote;
import android.HishaTech.com.dayquote.json.AsyncFillQuoteCount;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.io.File;

/**
 * Created by smithkev on 1/27/2015.
 */
public class Utils {

    public static boolean InternetUp(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = connectivityManager.getNetworkInfo
                (ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileInfo = connectivityManager.getNetworkInfo
                (ConnectivityManager.TYPE_MOBILE);
        if ((wifiInfo != null && wifiInfo.isConnected()) || (mobileInfo !=
                null && mobileInfo.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean DatabaseExists(Context context) {
        File database = context.getDatabasePath
                (DbConstants
                        .DATABASE_NAME);
        if (!database.exists()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkQuoteCountUpToDate(Context context) {
        try {
            AsyncFillQuoteCount afqc = new AsyncFillQuoteCount(context);
            afqc.execute();
            SharedPreferences prefs = context.getSharedPreferences
                    (AppConstants.pref_name, 0);
            Integer onlineQuoteCount = prefs.getInt(AppConstants.db_quotecount,
                    0);
            Integer currentQuoteCount = table_Quote.getQuoteCount(context);
            if (currentQuoteCount < onlineQuoteCount) {
                Toast.makeText(context, R.string.toast_quotecount_NotUpToDate,
                        Toast.LENGTH_LONG).show();
                return false;
            } else {
                Toast.makeText(context, R.string.toast_quotecount_UpToDate,
                        Toast.LENGTH_LONG).show();
                return true;
            }
        } catch (Exception e) {
            Toast.makeText(context, R.string.toast_quotecount_failed,
                    Toast.LENGTH_LONG).show();
            return true;
        }
    }


}
