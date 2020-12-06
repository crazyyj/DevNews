package com.newchar.devnews.main.index;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.newchar.devnews.base.adapter.BaseViewPagerAdapter;

/**
 * @author wenliqiang
 * date 2020/7/5
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class MainIndexAdapter extends BaseViewPagerAdapter {

    private static final String[] tabText = new String[]{"帖子", "博客"};

    public MainIndexAdapter(@NonNull FragmentManager fragment) {
        super(fragment);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabText[position];
    }

}
