package com.apkdv.KotlinDemo.bean

/**
 * Created by LengYue on 2017/5/19.
 */
class EmptyItem(emptyImg: Int, emptyText: String) : BaseItem() {
    init {
        resId = emptyImg
        tip = emptyText
    }
}