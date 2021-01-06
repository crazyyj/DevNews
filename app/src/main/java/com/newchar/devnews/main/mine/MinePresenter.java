package com.newchar.devnews.main.mine;

import com.newchar.devnews.base.BasePresenter;
import com.newchar.devnews.base.IBaseContract;

import org.jetbrains.annotations.NotNull;

/**
 * @author newChar
 * date 2020/12/28
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class MinePresenter extends BasePresenter implements Contract.Presenter {

    public MinePresenter(@NotNull IBaseContract.IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void updateHeaderData() {

    }

}
