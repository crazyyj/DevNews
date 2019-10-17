package com.newchar.devnews.util.constant;

/**
 * @author wenliqiang
 * date 2019-07-15
 * @since 开源中国常量字段类
 * @since 迭代版本，（以及描述）
 */
public interface OSCField {

    /**
     * 接口地址
     */
    interface Address{

        String CLEAR_USER_NOTIFY = "/action/openapi/clear_notice";

        String NEWS_OSC = "/action/openapi/news_list";

        /**
         *  OSC 动弹
         */
        String TWEET_LIST_OSC = "/action/openapi/tweet_list";



    }

    /**
     * 接口参数字段
     */
    interface Params{

        String ACCESS_TOKEN = "access_token";

        String PAGE_SIZE = "pageSize";

        String PAGE_INDEX = "pageIndex";

        String USER = "user";

        String FRIEND = "friend";

        String FRIEND_NAME = "friend_name";

        String DATA_TYPE = "dataType";

    }

    /**
     * 接口通用常量
     */
    interface DataType{

        String XML = "xml";

        String JSON = "json";

        String JSONP = "jsonp";

    }

}
