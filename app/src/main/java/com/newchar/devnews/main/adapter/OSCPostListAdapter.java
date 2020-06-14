package com.newchar.devnews.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.newchar.devnews.R;
import com.newchar.devnews.http.entry.osc.OSCPostList;
import com.newchar.devnews.http.entry.osc.OSCTweet;

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
    List<OSCPostList.Item> postList = new ArrayList<>();

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
        holder.tvPostItemName.setText(postList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void notifyDataSetChanged(List<OSCPostList.Item> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final AppCompatTextView tvPostItemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPostItemName = itemView.findViewById(R.id.tvPostItemName);
        }
    }


}
