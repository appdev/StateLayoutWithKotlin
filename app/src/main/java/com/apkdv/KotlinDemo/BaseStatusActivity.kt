package com.apkdv.KotlinDemo

import android.os.Bundle

/**
 * Created by LengYue on 2017/5/19.
 */
class BaseStatusActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}