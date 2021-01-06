package com.newchar.devnews.main.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.R;
import com.newchar.devnews.base.BaseFragment;

/**
 * @author newChar
 * date 2020/12/28
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class MineFragment extends BaseFragment implements Contract.IView {

    private RecyclerView rvMineContent;
    private Contract.Presenter presenter;

    @Override
    protected void initWidgets(View frgView) {
        rvMineContent = frgView.findViewById(R.id.rvMineContent);
        rvMineContent.setHasFixedSize(true);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        presenter = new MinePresenter(this);
        presenter.updateHeaderData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main_mine;
    }

    @Override
    protected BaseFragment getInstance(Bundle bundle) {
        return null;
    }

    @Override
    public Context obtainContext() {
        return mContext;
    }
}
