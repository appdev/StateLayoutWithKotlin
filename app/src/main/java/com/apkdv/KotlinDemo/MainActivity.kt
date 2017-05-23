package com.apkdv.KotlinDemo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.apkdv.KotlinDemo.pagestate.StateLayout
import com.apkdv.KotlinDemo.pagestate.StateLayout.OnViewRefreshListener

class MainActivity : BaseActivity(), View.OnClickListener {
    var stateLayout: StateLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stateLayout = findViewById(R.id.status_layout) as StateLayout
        findViewById(R.id.btn_content)?.setOnClickListener(this)
        findViewById(R.id.btn_empty)?.setOnClickListener(this)
        findViewById(R.id.btn_error)?.setOnClickListener(this)
        findViewById(R.id.btn_loading)?.setOnClickListener(this)
        findViewById(R.id.btn_time_out)?.setOnClickListener(this)
        findViewById(R.id.btn_not_network)?.setOnClickListener(this)
        findViewById(R.id.btn_login)?.setOnClickListener(this)
        findViewById(R.id.btn_custom)?.setOnClickListener(this)
        stateLayout?.setUseAnimation(true);
        stateLayout?.mListener = object : OnViewRefreshListener {
            override fun refreshClick() {
                applicationContext.showToast("Click")

            }

            override fun loginClick() {
                applicationContext.showToast("Login")
            }

        }
    }


    fun Context.showToast(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_content -> stateLayout?.showContentView()
            R.id.btn_empty -> stateLayout?.showEmptyView()
            R.id.btn_error -> stateLayout?.showErrorView()
            R.id.btn_loading -> stateLayout?.showLoadingView()
            R.id.btn_time_out -> stateLayout?.showTimeoutView()
            R.id.btn_not_network -> stateLayout?.showNoNetworkView()
            R.id.btn_login -> stateLayout?.showLoginView()
        }
    }
}
