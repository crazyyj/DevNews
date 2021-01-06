package com.newchar.devnews.base.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * @author wenliqiang
 * date 2020/7/5
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public abstract class BaseViewPagerAdapter extends FragmentStatePagerAdapter {


    public BaseViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    protected abstract Fragment generateMainPage(int position);

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return generateMainPage(position);
    }

}
