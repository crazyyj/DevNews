package com.newchar.devnews.post;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;
import com.newchar.devnews.post.adapter.OSCPostListAdapter;
import com.newchar.devnews.widget.CommonItemDecoration;
import com.newchar.oscrepository.entry.OSCNoticeNumber;
import com.newchar.oscrepository.entry.OSCPostList;
import com.newchar.supportlibrary.router.RouterExecute;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;

/**
 * @author wenliqiang
 * date 2020/6/23
 * @since 帖子列表
 * @since 迭代版本，（以及描述）
 */
public class OSCPostListFragment extends BaseFragment implements IView {


    @BindView(R.id.rvMainTweetList)
    RecyclerView rvMainTweetList;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout refreshLayout;

    private Presenter presenter;
    private OSCPostListAdapter oscPostListAdapter;

    @Override
    protected void initWidgets(View frgView) {
        oscPostListAdapter = new OSCPostListAdapter(mContext);
        rvMainTweetList.setHasFixedSize(true);
        rvMainTweetList.setAdapter(oscPostListAdapter);
        rvMainTweetList.addItemDecoration(new CommonItemDecoration());
        oscPostListAdapter.setItemCLickListener((holder, itemData, position) -> RouterExecute.goPostDetailActivity(String.valueOf(itemData.getId())));

        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                presenter.requestMoreOSCPostList();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                presenter.requestOSCPostList();
            }
        });
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presenter = new Presenter(this);
        presenter.requestOSCPostList();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_osc_post_list;
    }

    @Override
    protected BaseFragment getInstance(Bundle bundle) {
        return this;
    }

    @Override
    public void onUpdateNoticeNumber(OSCNoticeNumber news) {

    }

    @Override
    public void onCreateOSCPost(List<OSCPostList.Item> postList) {
        new Handler(Looper.getMainLooper()).post(() -> {
            oscPostListAdapter.notifyDataSetChanged(postList);
            if (refreshLayout != null) {
                refreshLayout.finishRefresh(20);
            }
        });

    }

    @Override
    public void onLoadMoreOSCPost(List<OSCPostList.Item> postList) {
        new Handler(Looper.getMainLooper()).post(() -> {
            oscPostListAdapter.notifyDataMoreChanged(postList);
            if (refreshLayout != null) {
                refreshLayout.finishLoadMore();
            }
        });

    }

    @Override
    public Context obtainContext() {
        return mContext;
    }


}
