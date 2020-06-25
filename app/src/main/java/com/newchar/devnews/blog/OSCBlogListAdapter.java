package com.newchar.devnews.blog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.R;
import com.newchar.devnews.http.entry.osc.OSCBlogList;
import com.newchar.devnews.http.entry.osc.OSCPostList;
import com.newchar.devnews.post.adapter.OSCPostListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2020/6/26
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class OSCBlogListAdapter extends RecyclerView.Adapter<OSCBlogListAdapter.ViewHolder> {

    private List<OSCBlogList.Item> adapterData;
    private ItemClickListener mItemClickListener;

    public OSCBlogListAdapter() {
        this.adapterData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.osc_item_blog_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OSCBlogList.Item itemData = adapterData.get(position);
        holder.ItemTitle.setText(itemData.getTitle());
        holder.publishName.setText(itemData.getAuthor());
        holder.publishTime.setText(itemData.getPubDate());
        holder.itemView.setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(holder, itemData, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adapterData.size();
    }

    public void notifyDataSetChanged(List<OSCBlogList.Item> data){
        adapterData.clear();
        adapterData.addAll(data);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final AppCompatTextView publishName;
        private final AppCompatTextView publishTime;
        private final AppCompatTextView ItemTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            publishName = itemView.findViewById(R.id.tvBlogItemPublishName);
            publishTime = itemView.findViewById(R.id.tvBlogItemPublishTime);
            ItemTitle = itemView.findViewById(R.id.tvBlogItemTitle);
        }

    }

    public void setItemCLickListener(ItemClickListener l) {
        mItemClickListener = l;
    }


    public interface ItemClickListener {

        void onItemClick(ViewHolder holder, OSCBlogList.Item itemData, int position);

    }

}
