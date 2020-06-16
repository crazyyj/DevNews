package com.newchar.supportlibrary.db;

/**
 * @author wenliqiang
 * date 2020/6/16
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public interface DBExecute {

    /**
     * 获取需要执行的sql语句
     *
     * @return 需要执行的sql语句
     */
    String[] getSQL();

    /**
     * 这次的版本
     *
     * @return 版本号
     */
    int getVersion();

}
