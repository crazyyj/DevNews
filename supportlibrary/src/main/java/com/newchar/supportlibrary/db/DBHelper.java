package com.newchar.supportlibrary.db;

import android.content.Context;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 数据库出口类，
 * @since 迭代版本描述
 */
public class DBHelper {

    public static final String DB_NAME = "db";

    private Context mAppContext;
    //    private final DaoSession daoSession;
    private static DBHelper mInstance;
//    private final BaseSQLiteHelper dbHelper;

    public DBHelper(Context context) {
        mAppContext = context.getApplicationContext();
//        dbHelper = new BaseSQLiteHelper(mAppContext);
    }

    public static DBHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DBHelper(context);
        }
        return mInstance;
    }


}
