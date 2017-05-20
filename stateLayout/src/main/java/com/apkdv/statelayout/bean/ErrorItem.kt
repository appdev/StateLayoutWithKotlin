package com.apkdv.KotlinDemo.bean

/**
 * Created by LengYue on 2017/5/19.
 */
class ErrorItem(errorImg: Int, errorText: String) : BaseItem() {
    init {
        tip = errorText
        resId = errorImg
    }
}