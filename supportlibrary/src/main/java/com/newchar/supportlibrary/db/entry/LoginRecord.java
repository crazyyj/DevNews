package com.newchar.supportlibrary.db.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;

/**
 * @author wenliqiang@100tal.com
 * date            2019-07-17
 * @since 数据库中，每次登录成功记录一次登录
 * @since 迭代版本描述
 */
@Entity
public class LoginRecord {

    /**
     * 自增id，主键
     */
    @Id(autoincrement = true)
    private Long _id;

    /**
     * 登录时间
     */
    private long loginTime;

    /**
     * 登录渠道
     */
    private String loginChannel;

    /**
     * osc 的 token
     */
    private String desc;

    @Generated(hash = 601420123)
    public LoginRecord() {
    }

    @Generated(hash = 1240320489)
    public LoginRecord(Long _id, long loginTime, String loginChannel, String desc) {
        this._id = _id;
        this.loginTime = loginTime;
        this.loginChannel = loginChannel;
        this.desc = desc;
    }

    public long getId() {
        return this._id;
    }

    public void setId(long id) {
        this._id = id;
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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

}
