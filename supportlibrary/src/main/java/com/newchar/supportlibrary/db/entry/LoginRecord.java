package com.newchar.supportlibrary.db.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 数据库中，每次登录成功记录一次登录
 * @since 迭代版本描述
 */
@Entity(indexes = {@Index(value = "loginTime, loginTime DESC", unique = true)})
public class LoginRecord {

    /**
     * 自增id，主键
     */
    @Id(autoincrement = true)
    private long id;

    /**
     * 登录时间
     */
    private long loginTime;

    /**
     * 登录渠道
     */
    private String loginChannel;

    @Generated(hash = 1466375303)
    public LoginRecord(long id, long loginTime, String loginChannel) {
        this.id = id;
        this.loginTime = loginTime;
        this.loginChannel = loginChannel;
    }

    @Generated(hash = 601420123)
    public LoginRecord() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLoginTime() {
        return this.loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginChannel() {
        return this.loginChannel;
    }

    public void setLoginChannel(String loginChannel) {
        this.loginChannel = loginChannel;
    }

}
