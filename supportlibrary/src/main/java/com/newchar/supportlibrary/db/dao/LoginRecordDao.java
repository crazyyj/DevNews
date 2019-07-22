package com.newchar.supportlibrary.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.newchar.supportlibrary.db.entry.LoginRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LOGIN_RECORD".
*/
public class LoginRecordDao extends AbstractDao<LoginRecord, Long> {

    public static final String TABLENAME = "LOGIN_RECORD";

    /**
     * Properties of entity LoginRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property _id = new Property(0, Long.class, "_id", true, "_id");
        public final static Property LoginTime = new Property(1, long.class, "loginTime", false, "LOGIN_TIME");
        public final static Property LoginChannel = new Property(2, String.class, "loginChannel", false, "LOGIN_CHANNEL");
        public final static Property Desc = new Property(3, String.class, "desc", false, "DESC");
    }


    public LoginRecordDao(DaoConfig config) {
        super(config);
    }
    
    public LoginRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOGIN_RECORD\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: _id
                "\"LOGIN_TIME\" INTEGER NOT NULL ," + // 1: loginTime
                "\"LOGIN_CHANNEL\" TEXT," + // 2: loginChannel
                "\"DESC\" TEXT);"); // 3: desc
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOGIN_RECORD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LoginRecord entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getLoginTime());
 
        String loginChannel = entity.getLoginChannel();
        if (loginChannel != null) {
            stmt.bindString(3, loginChannel);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LoginRecord entity) {
        stmt.clearBindings();
 
        Long _id = entity.get_id();
        if (_id != null) {
            stmt.bindLong(1, _id);
        }
        stmt.bindLong(2, entity.getLoginTime());
 
        String loginChannel = entity.getLoginChannel();
        if (loginChannel != null) {
            stmt.bindString(3, loginChannel);
        }
 
        String desc = entity.getDesc();
        if (desc != null) {
            stmt.bindString(4, desc);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LoginRecord readEntity(Cursor cursor, int offset) {
        LoginRecord entity = new LoginRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // _id
            cursor.getLong(offset + 1), // loginTime
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // loginChannel
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // desc
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LoginRecord entity, int offset) {
        entity.set_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLoginTime(cursor.getLong(offset + 1));
        entity.setLoginChannel(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDesc(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LoginRecord entity, long rowId) {
        entity.set_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LoginRecord entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LoginRecord entity) {
        return entity.get_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
