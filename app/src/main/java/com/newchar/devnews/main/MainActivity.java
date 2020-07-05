package com.newchar.devnews.main;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.main.contract.Contract;
import com.newchar.devnews.main.index.OSCMainIndexFragment;
import com.newchar.supportlibrary.router.ARouterPath;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements Contract.View {

    @BindView(R.id.vpMainPageContainer)
    ViewPager vpMainPageContainer;

    private MainPageAdapter mMainPageAdapter;

    @Override
    protected void initWidgets() {
        mMainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        vpMainPageContainer.setAdapter(mMainPageAdapter);
        //嵌套 ViewPage2 解决嵌套滚动问题
//        vpMainPageContainer.setUserInputEnabled(false);
    }

    @Override
    protected void initData() {
        mMainPageAdapter.notifyDataSetChanged(generateMainPage());
    }

    private List<Fragment> generateMainPage() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OSCMainIndexFragment());
        fragments.add(new OSCMainIndexFragment());
        return fragments;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
