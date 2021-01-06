package com.newchar.supportlibrary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @author wenliqiang
 * date 2020/6/16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class BaseSQLiteHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "login.db";
//    private final DBManager manager;


    public BaseSQLiteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
//        manager = new DBManager();
//        manager.add();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        manager.create(db);
//        try {
//            db.beginTransaction();
        db.execSQL(
                "CREATE TABLE loginRecord(" +
//                    "_id integer primary key, " +
                        "uid long, " +
                        "loginTime long, " +
                        "expires_in long, " +
                        "token_type varchar(16), " +
                        "access_token varchar(16), " +
                        "refresh_token varchar(16), " +
                        "loginChannel varchar(16))"
        );
//        } finally {
//            db.endTransaction();
//            db.close();
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
