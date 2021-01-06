package com.newchar.oscrepository.entry;

/**
 * @author wenliqiang
 * date 2019-07-31
 * @since OSC的网络请求错误Entry
 * @since 迭代版本，（以及描述）
 */
public class OSCHttpError {

    /**
     * 错误码
     * 200--》成功
     * 500——》失败
     */
    private String error;

    /**
     * 描述
     */
    private String error_description;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

}
