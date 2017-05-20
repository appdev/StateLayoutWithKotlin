package com.apkdv.KotlinDemo.holder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.apkdv.statelayout.R

/**
 * Created by LengYue on 2017/5/19.
 */
class LoginViewHolder(view: View) : BaseHolder() {
    var ivImg: ImageView? = null
    var btnLogin : Button? = null
    init {
        ivImg = view.findViewById(R.id.iv_img) as ImageView
        textTip = view.findViewById(R.id.tv_message) as TextView
        btnLogin = view.findViewById(R.id.button) as Button
    }
}