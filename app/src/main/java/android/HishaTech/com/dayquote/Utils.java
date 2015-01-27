package android.HishaTech.com.dayquote;

import android.HishaTech.com.dayquote.db.DbConstants;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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

}
