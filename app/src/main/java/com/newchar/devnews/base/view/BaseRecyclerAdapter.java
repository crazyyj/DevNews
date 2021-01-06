package com.newchar.devnews.base.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> adapterData;
    private LayoutInflater mLayoutInflater;
    protected Context mContext;

    public BaseRecyclerAdapter(Context context) {
        this.adapterData = new ArrayList<>(1);
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return adapterData.size();
    }

    public void notifyDataSetChanged(List<T> data) {
        adapterData.clear();
        adapterData.addAll(data);
        notifyDataSetChanged();
    }

    public void notifyMoreDataSetChanged(List<T> data) {
        adapterData.addAll(data);
        notifyDataSetChanged();
    }

    public LayoutInflater getLayoutInflater() {
        return mLayoutInflater;
    }

    public List<T> getAdapterData() {
        return adapterData;
    }
}
