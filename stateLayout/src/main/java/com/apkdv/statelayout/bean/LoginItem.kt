package com.apkdv.KotlinDemo.bean

/**
 * Created by LengYue on 2017/5/19.
 */
class LoginItem(loginImg: Int, loginText: String) : BaseItem() {
    init {
        resId = loginImg
        tip = loginText
    }
}