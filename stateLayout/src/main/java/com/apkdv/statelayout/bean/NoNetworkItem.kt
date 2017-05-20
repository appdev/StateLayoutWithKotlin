package com.apkdv.KotlinDemo.bean

/**
 * Created by LengYue on 2017/5/19.
 */
class NoNetworkItem(noNetworkImg: Int, noNetworkText: String) : BaseItem() {
    init {
        resId = noNetworkImg
        tip = noNetworkText
    }
}