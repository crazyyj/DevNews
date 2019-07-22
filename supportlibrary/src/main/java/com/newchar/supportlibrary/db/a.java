package com.newchar.supportlibrary.db;

import com.newchar.supportlibrary.db.dao.DaoMaster;
import com.newchar.supportlibrary.db.dao.DaoSession;
import com.newchar.supportlibrary.db.dao.LoginRecordDao;
import com.newchar.supportlibrary.db.entry.LoginRecord;
import com.newchar.supportlibrary.db.util.GreenDaoHelper;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class a {

    public a() {
        super();
        final DaoSession daoSession = GreenDaoHelper.getInstance(null).getDaoSession();
        final Query<LoginRecord> build = daoSession.getLoginRecordDao().queryBuilder().orderAsc(LoginRecordDao.Properties.LoginChannel).build();
        daoSession.getLoginRecordDao().save(new LoginRecord());

    }
}
