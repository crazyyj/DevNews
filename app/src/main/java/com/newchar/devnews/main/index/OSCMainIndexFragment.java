package com.newchar.devnews.main.index;

import android.os.Bundle;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;

import butterknife.BindView;

/**
 * @author wenliqiang
 * date 2020/7/5
 * @since 首页Fragment
 * @since 迭代版本，（以及描述）
 */
public class OSCMainIndexFragment extends BaseFragment {

    @BindView(R.id.vpIndexPageContainer)
    ViewPager vpIndexPageContainer;
    @BindView(R.id.tlIndexPageTopTab)
    TabLayout tlIndexPageTopTab;

    private MainIndexAdapter mPageAdapter;

    @Override
    protected void initWidgets(View frgView) {

        tlIndexPageTopTab.setupWithViewPager(vpIndexPageContainer);
        mPageAdapter = new MainIndexAdapter(getChildFragmentManager());

        vpIndexPageContainer.setAdapter(mPageAdapter);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_osc_main_index;
    }

    @Override
    protected BaseFragment getInstance(Bundle bundle) {
        return null;
    }

}
