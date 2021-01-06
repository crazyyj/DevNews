package com.newchar.devnews.http;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.newchar.oscrepository.entry.OSCPostList;

import java.io.IOException;

/**
 * @author wenliqiang
 * date 2020/6/15
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class OSCPostTypeAdapter extends TypeAdapter<OSCPostList.Answer> {

    @Override
    public void write(JsonWriter out, OSCPostList.Answer value) throws IOException {
//        value.getPostList()
        Log.e("OSCPostTypeAdapter", value.toString());
    }

    @Override
    public OSCPostList.Answer read(JsonReader in) throws IOException {
        OSCPostList.Answer answer = new OSCPostList.Answer();
        in.beginObject();
        while (in.hasNext()) {
            try {
                if (in.peek() == JsonToken.STRING) {
                    return answer;
                }
                switch (in.nextName()) {
                    case "time":
                        answer.time = in.nextString();
                        break;
                    case "name":
                        answer.name = in.nextString();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        in.endObject();
        return answer;
    }

}
