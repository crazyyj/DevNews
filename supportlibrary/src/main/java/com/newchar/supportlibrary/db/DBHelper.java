package com.newchar.supportlibrary.db;

import android.annotation.SuppressLint;
import android.content.Context;

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
    private final BaseSQLiteHelper dbHelper;

    public DBHelper(Context context) {
        mAppContext = context.getApplicationContext();
        dbHelper = new BaseSQLiteHelper(mAppContext);
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
     * @param record
     */
    public void saveLoginRecord(LoginRecord record) {

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
