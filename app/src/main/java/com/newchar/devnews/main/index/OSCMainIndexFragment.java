package com.newchar.devnews.main.index;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;
import com.newchar.devnews.base.adapter.BaseViewPagerAdapter;
import com.newchar.devnews.blog.OSCBlogListFragment;
import com.newchar.devnews.post.OSCPostListFragment;
import com.newchar.devnews.util.constant.GankIOField;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

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

    private BaseViewPagerAdapter mPageAdapter;

    @Override
    protected void initWidgets(View frgView) {

        tlIndexPageTopTab.setupWithViewPager(vpIndexPageContainer);
        mPageAdapter = new MainIndexAdapter(getChildFragmentManager());

        vpIndexPageContainer.setAdapter(mPageAdapter);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPageAdapter.notifyDataSetChanged(generateMainPage());
    }

    @Override
    protected void initListener() {

    }

    private List<Fragment> generateMainPage() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OSCPostListFragment());
        fragments.add(new OSCBlogListFragment());
        return fragments;
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
