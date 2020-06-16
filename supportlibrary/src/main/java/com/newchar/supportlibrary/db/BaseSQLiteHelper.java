package com.newchar.supportlibrary.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author wenliqiang
 * date 2020/6/16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class BaseSQLiteHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "login";
    private final DBManager manager;


    public BaseSQLiteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        manager = new DBManager();
        manager.add();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        manager.create(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
