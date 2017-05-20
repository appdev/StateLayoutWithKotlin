package com.apkdv.KotlinDemo.holder

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.apkdv.statelayout.R

/**
 * Created by LengYue on 2017/5/19.
 */
class LoadingViewHolder(view: View) : BaseHolder() {
    var frameLayout: FrameLayout? = null

    init {
        frameLayout = view.findViewById(R.id.loading_layout) as FrameLayout
        textTip = view.findViewById(R.id.tv_message) as TextView
    }
}