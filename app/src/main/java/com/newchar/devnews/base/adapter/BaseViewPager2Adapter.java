package com.newchar.devnews.base.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang
 * date 2020/7/5
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class BaseViewPager2Adapter extends FragmentStateAdapter {

    private List<Fragment> pageFragment;

    public BaseViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public BaseViewPager2Adapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public BaseViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        pageFragment = new ArrayList<>(1);
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

    public List<Fragment> getPageFragments() {
        return pageFragment;
    }

}
