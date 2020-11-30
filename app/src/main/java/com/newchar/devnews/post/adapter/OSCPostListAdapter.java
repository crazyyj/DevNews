package com.newchar.devnews.post.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.newchar.devnews.R;
import com.newchar.devnews.http.entry.osc.OSCPostList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang
 * date 2020/6/14
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
public class OSCPostListAdapter extends RecyclerView.Adapter<OSCPostListAdapter.ViewHolder> {


    private final Context mContext;
    private final LayoutInflater inflater;
    private List<OSCPostList.Item> postList = new ArrayList<>();
    private ItemClickListener mItemClickListener;


    public OSCPostListAdapter(Context context) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OSCPostListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = inflater.inflate(R.layout.osc_item_post_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OSCPostList.Item itemData = postList.get(position);
        holder.tvPostItemName.setText(itemData.getAuthor());
        holder.tvPostItemTitle.setText(itemData.getTitle());
        holder.tvPostItemPubDate.setText(itemData.getPubDate());
        holder.tvPostItemViewCount.setText("查看数  " + itemData.getViewCount());
        Glide.with(mContext).load(itemData.getPortrait()).into(holder.ivPostItemHeaderIcon);

        holder.itemView.setOnClickListener(v -> {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(holder, itemData, position);
            }
        });
        final StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            System.out.println("-----------------------------------");
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName()+"\t");
                System.out.print(stackElements[i].getFileName()+"\t");
                System.out.print(stackElements[i].getLineNumber()+"\t");
                System.out.println(stackElements[i].getMethodName());
            }

        }

    }

    public void setItemCLickListener(ItemClickListener l) {
        mItemClickListener = l;
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void notifyDataSetChanged(List<OSCPostList.Item> postList) {
        this.postList.clear();
        this.postList.addAll(postList);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final AppCompatTextView tvPostItemName;
        private final AppCompatTextView tvPostItemTitle;
        private final AppCompatTextView tvPostItemPubDate;
        private final AppCompatTextView tvPostItemViewCount;
        private final AppCompatImageView ivPostItemHeaderIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPostItemName = itemView.findViewById(R.id.tvPostItemName);
            tvPostItemTitle = itemView.findViewById(R.id.tvPostItemTitle);
            tvPostItemPubDate = itemView.findViewById(R.id.tvPostItemPubDate);
            tvPostItemViewCount = itemView.findViewById(R.id.tvPostItemViewCount);
            ivPostItemHeaderIcon = itemView.findViewById(R.id.ivPostItemHeaderIcon);
        }

    }

    public interface ItemClickListener {

        void onItemClick(ViewHolder holder, OSCPostList.Item itemData, int position);

    }

    private static class RecyclerViewDataLoader extends DiffUtil.ItemCallback<OSCPostList.Item> {

        @Override
        public boolean areItemsTheSame(@NonNull OSCPostList.Item oldItem, @NonNull OSCPostList.Item newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull OSCPostList.Item oldItem, @NonNull OSCPostList.Item newItem) {
            return oldItem.getId() == newItem.getId();
        }

    }


}
