package com.newchar.devnews.main;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.main.contract.Contract;
import com.newchar.devnews.main.girl.GankIOGirlFragment;
import com.newchar.devnews.main.index.OSCMainIndexFragment;
import com.newchar.supportlibrary.router.ARouterPath;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements Contract.View {

    @BindView(R.id.vpMainPageContainer)
    ViewPager vpMainPageContainer;

    private static final int[] bottomTabIds = new int[]{R.id.llMainBottomTab1, R.id.llMainBottomTab2, R.id.llMainBottomTab3, R.id.llMainBottomTab4};


    private MainPageAdapter mMainPageAdapter;

    @Override
    protected void initWidgets() {
        mMainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        vpMainPageContainer.setAdapter(mMainPageAdapter);
    }

    @Override
    protected void initData() {
        mMainPageAdapter.notifyDataSetChanged(generateMainPage());
    }

    private List<Fragment> generateMainPage() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OSCMainIndexFragment());
        fragments.add(new GankIOGirlFragment());
        return fragments;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.llMainBottomTab1, R.id.llMainBottomTab2, R.id.llMainBottomTab3, R.id.llMainBottomTab4})
    public void onBottomTabClick(View view) {
        final int id = view.getId();
        switch (id) {
            case R.id.llMainBottomTab1:
                onPostTabClick();
                break;
            case R.id.llMainBottomTab2:
                onGirlTabClick();
                break;
            case R.id.llMainBottomTab3:

                break;
            case R.id.llMainBottomTab4:

                break;
            default:
                break;
        }
    }

    /**
     * 帖子tab选中
     */
    private void onPostTabClick() {
        vpMainPageContainer.setCurrentItem(0, false);
    }

    /**
     * 图片列表tab选中
     */
    private void onGirlTabClick() {
        vpMainPageContainer.setCurrentItem(1, false);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
