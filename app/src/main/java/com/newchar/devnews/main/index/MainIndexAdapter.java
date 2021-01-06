package com.newchar.devnews.main.index;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.newchar.devnews.base.adapter.BaseViewPagerAdapter;
import com.newchar.devnews.blog.OSCBlogListFragment;
import com.newchar.devnews.post.OSCPostListFragment;

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

    @Override
    protected Fragment generateMainPage(int position) {
        switch (position) {
            case 0:
                return new OSCPostListFragment();
            case 1:
            default:
                return new OSCBlogListFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabText[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
