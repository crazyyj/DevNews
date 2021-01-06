package com.newchar.devnews.obs;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.newchar.oscrepository.entry.OSCNoticeNumber;

/**
 * @author wenliqiang
 * date 2020/6/22
 * @since LiveData 封装工具类
 * @since 迭代版本，（以及描述）
 */
class ObserverPublish {

    private static ObserverPublish mObserverPublish;

    private MutableLiveData<OSCNoticeNumber> oscNoticeLiveData = new MutableLiveData<>();

    private ObserverPublish() {
    }

    public static ObserverPublish getInstance() {
        if (mObserverPublish == null) {
            mObserverPublish = new ObserverPublish();
        }
        return mObserverPublish;
    }

    public void registerOSCNoticeData(LifecycleOwner lifecycle, Observer<OSCNoticeNumber> observer) {
        oscNoticeLiveData.observe(lifecycle, observer);
    }

    public void unRegisterOSCNoticeData(Observer<OSCNoticeNumber> observer) {
        oscNoticeLiveData.removeObserver(observer);
    }

}
