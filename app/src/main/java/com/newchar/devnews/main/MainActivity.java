package com.newchar.devnews.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.base.IBaseContract;
import com.newchar.supportlibrary.router.ARouterPath;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity implements IBaseContract.IBaseView {

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

    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @SuppressLint("NonConstantResourceId")
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
                onGirlTabClick();
                break;
            case R.id.llMainBottomTab4:
                onMineTabClick();
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

    /**
     * 图片列表tab选中
     */
    private void onThreeTabClick() {
        vpMainPageContainer.setCurrentItem(2, false);
    }

    /**
     * 我的页面被选中
     */
    private void onMineTabClick() {
        vpMainPageContainer.setCurrentItem(3, false);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    public Context obtainContext() {
        return null;
    }

    @Override
    public void showPagePrompt(String prompt) {

    }
}
