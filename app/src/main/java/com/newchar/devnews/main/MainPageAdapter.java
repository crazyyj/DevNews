package com.newchar.devnews.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang
 * date 2020/6/25
 * @since App首页 Fragment 适配器
 * @since 迭代版本，（以及描述）
 */
public class MainPageAdapter extends FragmentStateAdapter {

    private final List<Fragment> pageFragment;

    public MainPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        pageFragment = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return pageFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return pageFragment.size();
    }

    public void notifyDataSetChanged(List<Fragment> fragments) {
        pageFragment.clear();
        pageFragment.addAll(fragments);
        notifyDataSetChanged();
    }

}
