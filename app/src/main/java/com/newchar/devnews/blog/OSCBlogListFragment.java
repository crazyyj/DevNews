package com.newchar.devnews.blog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;
import com.newchar.devnews.blog.contract.IOSCBlogListContract;
import com.newchar.devnews.blog.contract.OSCBlogListPresenter;
import com.newchar.devnews.http.entry.osc.OSCBlogList;
import com.newchar.supportlibrary.router.RouterExecute;

import java.util.List;

import butterknife.BindView;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since osc 博客列表
 * @since 迭代版本描述
 */
public class OSCBlogListFragment extends BaseFragment implements IOSCBlogListContract.View{

    @BindView(R.id.rvMainBlogList)
    RecyclerView rvMainBlogList;

    private IOSCBlogListContract.Presenter presenter;
    private OSCBlogListAdapter listAdapter;


    @Override
    protected void initWidgets(View frgView) {
        rvMainBlogList.setHasFixedSize(true);
        listAdapter = new OSCBlogListAdapter();
        listAdapter.setItemCLickListener((holder, itemData, position) -> {
            RouterExecute.goBlogDetailActivity(itemData.getId());
        });
        rvMainBlogList.setAdapter(listAdapter);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presenter = new OSCBlogListPresenter();
        presenter.attachView(this);
        presenter.requestOSCBlogList();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_osc_blog_list;
    }

    @Override
    protected BaseFragment getInstance(Bundle bundle) {
        return null;
    }

    @Override
    public Context obtainContext() {
        return mContext;
    }


    @Override
    public void onBlogListResponse(List<OSCBlogList.Item> blogList) {
        new Handler(Looper.getMainLooper()).post(() -> listAdapter.notifyDataSetChanged(blogList));
    }

}
