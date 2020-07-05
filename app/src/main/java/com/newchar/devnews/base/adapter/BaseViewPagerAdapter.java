package com.newchar.devnews.base.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang
 * date 2020/7/5
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> pageFragment;

    public BaseViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pageFragment = new ArrayList<>(1);
    }


    @NonNull
    public void notifyDataSetChanged(List<Fragment> fragments) {
        pageFragment.clear();
        pageFragment.addAll(fragments);
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public List<Fragment> getPageFragments() {
        return pageFragment;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return getPageFragments().get(position);
    }

    @Override
    public int getCount() {
        return getPageFragments().size();
    }
}
