package com.newchar.devnews.obs;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.newchar.devnews.http.entry.osc.OSCNoticeNumber;

/**
 * @author wenliqiang
 * date 2020/6/22
 * @since 当前版本，（以及描述）
 * @since 迭代版本，（以及描述）
 */
class ObserverPublish {

    private static ObserverPublish mObserverPublish;

    private MutableLiveData<OSCNoticeNumber> oscNoticeLiveData = new MutableLiveData<>();

    public static ObserverPublish getInstance() {
        if (mObserverPublish == null) {
            mObserverPublish = new ObserverPublish();
        }
        return mObserverPublish;
    }

    public void registerOSCNoticeData(LifecycleOwner lifecycle, Observer<? super OSCNoticeNumber> observer) {
        oscNoticeLiveData.observe(lifecycle, observer);
    }

}
