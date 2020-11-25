package com.newchar.devnews.base.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author newChar
 * date 2020/10/30
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerAdapter.Holder> {

    private final AsyncListDiffer<T> diffWorker;

    public BaseRecyclerAdapter() {
        /*
         * 比对回调
         */
        DataDiffer<T> mDataDiffer = new DataDiffer<>();
        this.diffWorker = new AsyncListDiffer<T>(this, mDataDiffer);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    public void notifyDataSetChanged(List<T> newList) {
        diffWorker.submitList(newList);
    }

    public List<T> getListData() {
        return diffWorker.getCurrentList();
    }

    @Override
    public int getItemCount() {
        return diffWorker.getCurrentList().size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }

    }

    public static class DataDiffer<T> extends DiffUtil.ItemCallback<T> {


        @Override
        public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {

            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {

            return oldItem == newItem;
        }

    }


}
