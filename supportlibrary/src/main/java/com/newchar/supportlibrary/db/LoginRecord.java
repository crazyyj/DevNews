package com.newchar.supportlibrary.db;

/**
 * @author wenliqiang
 * date 2020/6/16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class LoginRecord implements DBExecute {

    public static final String TABLE_NAME = "LoginRecord";

    private static final String CREATE_SQL_LOGIN_RECORD = "CREATE TABLE " + TABLE_NAME + "(" +
            "   _id INTEGER  PRIMARY KEY(one or more columns)," +
            "   which VARCHAR(255)," +              //哪种登陆，暂时默认都是osc
            "   time VARCHAR(255)," +               //登陆时间，精确到秒
            "   login_id VARCHAR(255)," +           //对应登陆表中到id，关联id
            ");";

    @Override
    public String[] getSQL() {
        return new String[]{CREATE_SQL_LOGIN_RECORD};
    }

    @Override
    public int getVersion() {
        return 1;
    }

}
