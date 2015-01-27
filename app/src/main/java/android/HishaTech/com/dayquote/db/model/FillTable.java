package android.HishaTech.com.dayquote.db.model;

import android.HishaTech.com.dayquote.db.DbConstants;
import android.HishaTech.com.dayquote.db.table.table_Category;
import android.HishaTech.com.dayquote.json.JsonConstants;
import android.HishaTech.com.dayquote.json.JsonParser;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by smithkev on 1/27/2015.
 */
public class FillTable {

    public static boolean Categories(Context context) {
        try {
            JsonParser jParser = new JsonParser();
            JSONObject jObject = jParser.getJSONFromUrl(JsonConstants
                    .json_BaseURL + JsonConstants.json_CategoryURL);
            JSONArray jArray = jObject.getJSONArray(DbConstants.TABLE_CATEGORY);
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    if (!table_Category.checkCategoryExistsById
                            (context, oneObject
                                    .getInt
                                            (DbConstants.CATEGORY_ROWID))) {
                        Category category = new Category();
                        category.setID(oneObject.getInt(DbConstants
                                .CATEGORY_ROWID));
                        category.setName(oneObject.getString(DbConstants
                                .CATEGORY_NAME));
                        category.setDescription(oneObject.getString
                                (DbConstants.CATEGORY_DESCRIPTION));
                        table_Category.insertCategory(context, category);
                    }
                } catch (JSONException e) {
                    // Oops
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
