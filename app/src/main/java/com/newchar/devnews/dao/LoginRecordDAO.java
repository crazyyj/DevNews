package com.newchar.devnews.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
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
     *
     * @return 登陆记录
     */
    @Nullable
    public static LoginRecord getLoginRecord() {
        LoginRecord record = null;
        final SQLiteDatabase database = sqLiteHelper.getReadableDatabase();
        try (Cursor cursor = database.query("loginRecord", null, null, null, null, null, null)) {
//        try (Cursor cursor = database.rawQuery("SELECT * FROM loginRecord", null)) {
            database.beginTransaction();
            if (cursor.getCount() > 0) {
                cursor.moveToLast();
                final long loginTime = cursor.getLong(cursor.getColumnIndex("loginTime"));
                final long expires_in = cursor.getLong(cursor.getColumnIndex("expires_in"));
                record = new LoginRecord();
                record.setLoginTime(loginTime);
                record.setExpires_in(expires_in);
            }
        } finally {
            database.endTransaction();
            database.close();
        }
        return record;
    }

}
