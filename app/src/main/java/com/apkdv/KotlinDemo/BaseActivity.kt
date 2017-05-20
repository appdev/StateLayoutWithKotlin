package com.apkdv.KotlinDemo

import android.content.Context

import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager


/**
 * Created by LengYue on 2017/5/19.
 */
open class BaseActivity : AppCompatActivity() {

    fun HideSoftKeyboard() {
        val inputMethodManager: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val localView = currentFocus
        if (localView != null && localView.windowToken != null) {
            val windowToken = localView.windowToken
            inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)
        }
    }

    override fun onDestroy() {
        setContentView(R.layout.activity_null)
        super.onDestroy()
    }
}