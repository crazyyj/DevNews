package com.newchar.devnews.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.newchar.devnews.base.adapter.BaseViewPagerAdapter;
import com.newchar.devnews.main.girl.GankIOGirlFragment;
import com.newchar.devnews.main.index.OSCMainIndexFragment;
import com.newchar.devnews.main.mine.MineFragment;

/**
 * @author wenliqiang
 * date 2020/6/25
 * @since App首页 Fragment 适配器
 * @since 迭代版本，（以及描述）
 */
public class MainPageAdapter extends BaseViewPagerAdapter {

    public MainPageAdapter(@NonNull FragmentManager fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    protected Fragment generateMainPage(int position) {
        switch (position) {
            case 0:
                return new OSCMainIndexFragment();
            case 1:
            case 2:
                return new GankIOGirlFragment();
            case 3:
                return new MineFragment();
            default:
                return new OSCMainIndexFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}
