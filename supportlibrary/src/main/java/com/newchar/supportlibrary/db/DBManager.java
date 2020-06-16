package com.newchar.supportlibrary.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang
 * date 2020/6/16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class DBManager {

    private final List<DBExecute> executes = new ArrayList<>();

    public void add() {
        executes.add(new LoginRecord());
    }

    public void create(SQLiteDatabase db) {
        for (DBExecute execute : executes) {
            if (db.getVersion() < execute.getVersion()) {
                final String[] sqls = execute.getSQL();
                for (String sql : sqls) {
                    db.execSQL(sql);
                }
            }
        }
    }

}
