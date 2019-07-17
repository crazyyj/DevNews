package com.newchar.devnews;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.supportlibrary.router.ARouterPath;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity{

    @Override
    protected void initWidgets() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


}
