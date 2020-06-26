package com.newchar.devnews.post.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.newchar.devnews.R;
import com.newchar.devnews.http.entry.osc.OSCTweet;
import com.newchar.devnews.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenliqiang@100tal.com
 * date            2019-10-17
 * @since 当前版本描述，
 * @since 迭代版本描述
 */
public class OSCTweetListAdapter extends RecyclerView.Adapter<OSCTweetListAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater inflater;
    private List<OSCTweet.OSCTweetItem> tweetItems ;

    public OSCTweetListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        tweetItems = new ArrayList<>();
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_main_tweet_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OSCTweetListAdapter.ViewHolder holder, int position) {
        OSCTweet.OSCTweetItem oscTweetItem = tweetItems.get(position);
        holder.tvItemTweetDate.setText(oscTweetItem.pubDate);
        holder.tvItemTweetAuthorName.setText(oscTweetItem.author);
        holder.tvItemTweetContent.setText(CommonUtils.getHTMLText(oscTweetItem.body));
        holder.tvItemTweetCommentNum.setText(mContext.getString(R.string.tweet_comment_num, oscTweetItem.commentCount));

        if (!TextUtils.isEmpty(oscTweetItem.imgSmall)) {
            String[] split = oscTweetItem.imgSmall.split(",");
            if (split.length > 0) {
                Glide.with(mContext).load(split[split.length - 1]).into(holder.ivItemTweetImage);
            }
        }
        Glide.with(mContext).load(oscTweetItem.portrait).into(holder.ivItemTweetAvatar);
    }

    @Override
    public int getItemCount() {
        return tweetItems.size();
    }

    public void notifyDataSetChanged(List<OSCTweet.OSCTweetItem> tweets) {
        tweetItems.clear();
        tweetItems.addAll(tweets);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private AppCompatTextView tvItemTweetTitle;
        private AppCompatImageView ivItemTweetImage;
        private AppCompatImageView ivItemTweetAvatar;
        private AppCompatTextView tvItemTweetDate;
        private AppCompatTextView tvItemTweetContent;
        private AppCompatTextView tvItemTweetCommentNum;
        private AppCompatTextView tvItemTweetAuthorName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            findView(itemView);
        }

        private void findView(View itemView) {
            tvItemTweetDate = itemView.findViewById(R.id.tvItemTweetDate);
            ivItemTweetImage = itemView.findViewById(R.id.ivItemTweetImage);
            tvItemTweetTitle = itemView.findViewById(R.id.tvItemTweetTitle);
            ivItemTweetAvatar = itemView.findViewById(R.id.ivItemTweetAvatar);
            tvItemTweetContent = itemView.findViewById(R.id.tvItemTweetContent);
            tvItemTweetAuthorName = itemView.findViewById(R.id.tvItemTweetAuthorName);
            tvItemTweetCommentNum = itemView.findViewById(R.id.tvItemTweetCommentNum);
        }


    }

}
