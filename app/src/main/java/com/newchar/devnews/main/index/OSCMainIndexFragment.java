package com.newchar.devnews.main.index;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;
import com.newchar.devnews.base.adapter.BaseViewPager2Adapter;
import com.newchar.devnews.base.adapter.BaseViewPagerAdapter;
import com.newchar.devnews.blog.OSCBlogListFragment;
import com.newchar.devnews.post.OSCPostListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author wenliqiang
 * date 2020/7/5
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCMainIndexFragment extends BaseFragment {

    @BindView(R.id.vpIndexPageContainer)
    ViewPager vpIndexPageContainer;
    @BindView(R.id.tlIndexPageTopTab)
    TabLayout tlIndexPageTopTab;

    private BaseViewPagerAdapter mPageAdapter;

    private static final String[] tabText = new String[]{"帖子", "博客"};
    private TabLayoutMediator tabLayoutMediator;

    @Override
    protected void initWidgets(View frgView) {
        mPageAdapter = new MainIndexAdapter(getChildFragmentManager());
        vpIndexPageContainer.setAdapter(mPageAdapter);
        initTabLayout();
    }

    private void initTabLayout() {
        tlIndexPageTopTab.setupWithViewPager(vpIndexPageContainer);
        initTabLayoutItem();
    }

    private void initTabLayoutItem() {
        TabLayout.Tab tab ;
        for (int i = 0; i < tabText.length; i++) {
            tab = createNewTab(i);
            tlIndexPageTopTab.addTab(tab);
        }
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

    private TabLayout.Tab createNewTab(int position) {
        final TabLayout.Tab tab = tlIndexPageTopTab.newTab();
        tab.setText(tabText[position]);
        return tab;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_osc_main_index;
    }

    @Override
    protected BaseFragment getInstance(Bundle bundle) {
        return null;
    }

    @Override
    protected void onReleaseRes() {
        super.onReleaseRes();
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
    }
}
