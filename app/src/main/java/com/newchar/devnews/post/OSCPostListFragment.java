package com.newchar.devnews.post;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;
import com.newchar.devnews.base.adapter.ItemViewClick;
import com.newchar.devnews.http.entry.osc.OSCNoticeNumber;
import com.newchar.devnews.http.entry.osc.OSCPostList;
import com.newchar.devnews.post.adapter.OSCPostListAdapter;
import com.newchar.supportlibrary.router.RouterExecute;

import java.util.List;

import butterknife.BindView;

/**
 * @author wenliqiang
 * date 2020/6/23
 * @since 帖子列表
 * @since 迭代版本，（以及描述）
 */
public class OSCPostListFragment extends BaseFragment implements IView {

    private Presenter presenter;

    @BindView(R.id.rvMainTweetList)
    RecyclerView rvMainTweetList;
    @BindView(R.id.btnClickRefresh)
    Button btnClickRefresh;

    private OSCPostListAdapter oscPostListAdapter;

    @Override
    protected void initWidgets(View frgView) {
        oscPostListAdapter = new OSCPostListAdapter(mContext);
        rvMainTweetList.setHasFixedSize(true);
        rvMainTweetList.setAdapter(oscPostListAdapter);
        rvMainTweetList.addOnItemTouchListener(new ItemViewClick(rvMainTweetList, (itemView, position) -> {
            Toast.makeText(mContext, "aaa " + position, Toast.LENGTH_SHORT).show();
        }));
        oscPostListAdapter.setItemCLickListener((holder, itemData, position) -> RouterExecute.goPostDetailActivity(String.valueOf(itemData.getId())));

        btnClickRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnRefreshListClick(v);
            }
        });
    }

    private void OnRefreshListClick(View view) {
        oscPostListAdapter.notifyDataSetChanged2();
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
        new Handler(Looper.getMainLooper()).post(() -> oscPostListAdapter.notifyDataSetChanged(postList));
    }

    @Override
    public Context obtainContext() {
        return mContext;
    }

    @Override
    public void showPagePrompt(String prompt) {

    }

}
