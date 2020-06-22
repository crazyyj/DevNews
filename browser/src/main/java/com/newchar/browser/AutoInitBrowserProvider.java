package com.newchar.browser;

import android.content.Context;
import android.content.pm.ProviderInfo;

/**
 * @author wenliqiang@100tal.com
 * date            2020/5/7
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class AutoInitBrowserProvider extends ContentProviderAdapter {

    @Override
    public void attachInfo(Context context, ProviderInfo info) {
        super.attachInfo(context, info);
        WebViewFactory.getInstance().preLoadWebView(context);
    }

}
