package com.apkdv.KotlinDemo.bean

/**
 * Created by LengYue on 2017/5/19.
 */
class TimeOutItem(timeOutImg: Int, timeOutText: String) : BaseItem() {
    init {
        resId = timeOutImg
        tip = timeOutText
    }
}