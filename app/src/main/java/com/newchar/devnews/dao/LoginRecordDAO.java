package com.newchar.devnews.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.newchar.devnews.util.ContextHolder;
import com.newchar.supportlibrary.db.BaseSQLiteHelper;
import com.newchar.supportlibrary.db.entry.LoginRecord;

/**
 * @author newChar
 * date 2020/11/25
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class LoginRecordDAO {

    private static volatile BaseSQLiteHelper sqLiteHelper;

    static {
        sqLiteHelper = new BaseSQLiteHelper(ContextHolder.get());
    }

    /**
     * 获取最后一个登陆的osc账户信息
     *
     * @return 登陆记录
     */
    @Nullable
    public static LoginRecord getLastOSCLoginRecord() {
        LoginRecord record = null;
        final SQLiteDatabase database = sqLiteHelper.getReadableDatabase();
        database.beginTransaction();
        try (Cursor cursor = database.query("loginRecord", new String[]{"loginTime", "expires_in", "access_token", "refresh_token"}, null, null, null, null, null)) {
            if (cursor.getCount() > 0) {
                cursor.moveToLast();
                final long loginTime = cursor.getLong(cursor.getColumnIndex("loginTime"));
                final long expires_in = cursor.getLong(cursor.getColumnIndex("expires_in"));
                final String accessToken = cursor.getString(cursor.getColumnIndex("access_token"));
                final String refreshToken = cursor.getString(cursor.getColumnIndex("refresh_token"));
                record = new LoginRecord();
                record.setLoginTime(loginTime);
                record.setExpires_in(expires_in);
                record.setAccess_token(accessToken);
                record.setRefresh_token(refreshToken);
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
        return record;
    }

    /**
     * 保存登录记录
     *
     * @param record 登陆记录
     */
    public static boolean saveLoginRecord(LoginRecord record) {
        SQLiteDatabase writableDatabase = sqLiteHelper.getWritableDatabase();
        long index = -1;
        try {
            writableDatabase.beginTransaction();
            ContentValues sqlValue = new ContentValues();
            sqlValue.put("uid", record.getId());
            sqlValue.put("loginTime", record.getLoginTime());
            sqlValue.put("expires_in", record.getExpires_in());
            sqlValue.put("token_type", record.getToken_type());
            sqlValue.put("access_token", record.getAccess_token());
            sqlValue.put("refresh_token", record.getRefresh_token());
            sqlValue.put("loginChannel", record.getLoginChannel());
            index = writableDatabase.insert("loginRecord", null, sqlValue);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            writableDatabase.close();
        }
        return index != -1;
    }


}
