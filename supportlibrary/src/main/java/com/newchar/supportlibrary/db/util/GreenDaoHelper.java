package com.newchar.supportlibrary.db.util;

import android.content.Context;

import com.newchar.supportlibrary.db.dao.DaoMaster;
import com.newchar.supportlibrary.db.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * @author wenliqiang
 * date 2019-07-20
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class GreenDaoHelper {

    public static final String DB_NAME = "NEWS";
    private DaoSession daoSession;

    public static GreenDaoHelper mGreenDaoHelper;

    public static GreenDaoHelper getInstance(Context context){
        if (mGreenDaoHelper == null) {
            mGreenDaoHelper = new GreenDaoHelper();
            mGreenDaoHelper.initGreenDaoDB(context);
        }
        return mGreenDaoHelper;
    }

    public void initGreenDaoDB(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        final Database writableDb = helper.getWritableDb();
        daoSession = new DaoMaster(writableDb).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
