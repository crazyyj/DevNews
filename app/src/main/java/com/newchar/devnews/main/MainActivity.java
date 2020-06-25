package com.newchar.devnews.main;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseActivity;
import com.newchar.devnews.blog.OSCBlogListFragment;
import com.newchar.devnews.post.OSCPostListFragment;
import com.newchar.supportlibrary.router.ARouterPath;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = ARouterPath.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity {

    @BindView(R.id.vpMainPageContainer)
    ViewPager2 vpMainPageContainer;

    private MainPageAdapter mMainPageAdapter;

    @Override
    protected void initWidgets() {
        mMainPageAdapter = new MainPageAdapter(this);
        vpMainPageContainer.setAdapter(mMainPageAdapter);
    }

    @Override
    protected void initData() {
        mMainPageAdapter.notifyDataSetChanged(generateMainPage());
    }

    private List<Fragment> generateMainPage() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OSCPostListFragment());
        fragments.add(new OSCBlogListFragment());
        return fragments;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
