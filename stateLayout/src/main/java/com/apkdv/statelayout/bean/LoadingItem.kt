package com.apkdv.KotlinDemo.bean

/**
 * Created by LengYue on 2017/5/19.
 */
class LoadingItem(loadingText: String) : BaseItem() {
    init {
        tip = loadingText
    }
}