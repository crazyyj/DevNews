package com.newchar.supportlibrary.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;

import androidx.annotation.Nullable;

import com.newchar.supportlibrary.db.entry.LoginRecord;

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

    /**
     * 保存登录记录
     *
     * @param record    登陆记录
     */
    public boolean saveLoginRecord(LoginRecord record) {

        long index = -1;
        final BaseSQLiteHelper dbHelper = new BaseSQLiteHelper(mAppContext);
        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
//            writableDatabase.beginTransaction();
            ContentValues sqlValue = new ContentValues();
            sqlValue.put("uid", record.getId());
            sqlValue.put("loginTime", SystemClock.uptimeMillis());
            sqlValue.put("expires_in", record.getExpires_in());
            sqlValue.put("token_type", record.getToken_type());
            sqlValue.put("access_token", record.getAccess_token());
            sqlValue.put("refresh_token", record.getRefresh_token());
            sqlValue.put("loginChannel", record.getLoginChannel());
            index = writableDatabase.insert("loginRecord", null, sqlValue);
//            writableDatabase.endTransaction();
//            dbHelper.close();
//        }
        return index != -1;
    }

    /**
     * 保存登录记录
     */
    @Nullable
    public LoginRecord getLastLoginRecord() {

//        List<LoginRecord> loginRecords = getDaoSession().getLoginRecordDao().loadAll();
//        List<LoginRecord> loginRecords = getDaoSession().getLoginRecordDao().queryRaw("SELECT * FROM "+ LoginRecordDao.TABLENAME +" ORDER BY "+ LoginRecordDao.Properties._id +" DESC LIMIT 1");
//        if (loginRecords != null && !loginRecords.isEmpty()) {
//            return loginRecords.get(0);
//        }
        return null;
    }

}
