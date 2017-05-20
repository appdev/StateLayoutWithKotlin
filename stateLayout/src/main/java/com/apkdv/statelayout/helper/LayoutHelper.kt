package com.apkdv.statelayout.helper

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.util.AttributeSet
import android.view.View
import com.apkdv.KotlinDemo.holder.*
import com.apkdv.KotlinDemo.bean.LoadingItem
import com.apkdv.KotlinDemo.bean.LoginItem
import com.apkdv.KotlinDemo.bean.NoNetworkItem
import com.apkdv.KotlinDemo.bean.EmptyItem
import com.apkdv.KotlinDemo.bean.TimeOutItem
import com.apkdv.KotlinDemo.bean.ErrorItem
import android.support.annotation.DrawableRes
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.apkdv.KotlinDemo.pagestate.StateLayout
import com.apkdv.statelayout.R


/**
 * Created by LengYue on 2017/5/19.
 */
class LayoutHelper {

    companion object {
        /**
         * 解析布局中的可选参数

         * @param context
         * *
         * @param attrs
         * *
         * @param stateLayout
         */
        fun parseAttr(context: Context, attrs: AttributeSet, stateLayout: StateLayout) {
            val a = context.theme.obtainStyledAttributes(attrs, R.styleable.StateLayout, 0, 0)
            try {
                val errorImg = a.getResourceId(R.styleable.StateLayout_errorImg, -1)
                val errorText = a.getString(R.styleable.StateLayout_errorText)
                stateLayout.errorItem = ErrorItem(errorImg, errorText)
                val timeOutImg = a.getResourceId(R.styleable.StateLayout_timeOutImg, -1)
                val timeOutText = a.getString(R.styleable.StateLayout_timeOutText)
                stateLayout.timeOutItem = TimeOutItem(timeOutImg, timeOutText)
                val emptyImg = a.getResourceId(R.styleable.StateLayout_emptyImg, -1)
                val emptyText = a.getString(R.styleable.StateLayout_emptyText)
                stateLayout.emptyItem = EmptyItem(emptyImg, emptyText)

                val noNetworkImg = a.getResourceId(R.styleable.StateLayout_noNetworkImg, -1)
                val noNetworkText = a.getString(R.styleable.StateLayout_noNetworkText)
                stateLayout.noNetworkItem = NoNetworkItem(noNetworkImg, noNetworkText)

                val loginImg = a.getResourceId(R.styleable.StateLayout_loginImg, -1)
                val loginText = a.getString(R.styleable.StateLayout_loginText)
                stateLayout.loginItem = LoginItem(loginImg, loginText)

                val loadingText = a.getString(R.styleable.StateLayout_loadingText)
                stateLayout.loadingItem = LoadingItem(loadingText)
            } finally {
                a.recycle()
            }

        }


        /**
         * 获取初始的错误View

         * @param layoutInflater 布局填充器
         * *
         * @param item           错误bean
         * *
         * @param layout         容器
         * *
         * @return 错误View
         */
        fun getErrorView(layoutInflater: LayoutInflater, item: ErrorItem?,
                         layout: StateLayout): View {
            val view = layoutInflater.inflate(R.layout.layout_error, null)
            if (item != null) {
                val holder = ErrorViewHolder(view)
                view.tag = holder
                setImageAndText(item.tip, item.resId, holder.textTip, holder.ivImg)
                view.setOnClickListener {
                    layout.mListener?.refreshClick()
                }
            }
            return view
        }


        /**
         * 获取初始的没有网络View

         * @param layoutInflater 布局填充器
         * *
         * @param item           没有网络bean
         * *
         * @param layout         容器
         * *
         * @return 没有网络View
         */
        fun getNoNetworkView(layoutInflater: LayoutInflater, item: NoNetworkItem?,
                             layout: StateLayout): View {
            val view = layoutInflater.inflate(R.layout.layout_no_network, null)
            if (item != null) {
                val holder = NoNetworkViewHolder(view)
                view.tag = holder
                setImageAndText(item.tip, item.resId, holder.textTip, holder.ivImg)
                view.setOnClickListener { layout.mListener?.refreshClick() }
            }
            return view
        }


        /**
         * 获取初始的加载View

         * @param layoutInflater 布局填充器
         * *
         * @param item           加载bean
         * *
         * @return 加载View
         */
        fun getLoadingView(layoutInflater: LayoutInflater, item: LoadingItem?): View {
            val view = layoutInflater.inflate(R.layout.layout_loading, null)
            if (item != null) {
                val holder = LoadingViewHolder(view)
                view.tag = holder

                val progressBar = ProgressBar(view.context)
                progressBar.indeterminateDrawable = view.resources.getDrawable(R.drawable.bg_loading)
                holder.frameLayout?.addView(progressBar)

                if (!TextUtils.isEmpty(item.tip)) {
                    holder.textTip?.text = item.tip
                }
            }
            return view
        }

        /**
         * 获取初始的超时View

         * @param layoutInflater 布局填充器
         * *
         * @param item           超时bean
         * *
         * @param layout         容器
         * *
         * @return 超时View
         */
        fun getTimeOutView(layoutInflater: LayoutInflater, item: TimeOutItem?,
                           layout: StateLayout): View {
            val view = layoutInflater.inflate(R.layout.layout_time_out, null)
            if (item != null) {
                val holder = TimeOutViewHolder(view)
                view.tag = holder

                setImageAndText(item.tip, item.resId, holder.textTip, holder.ivImg)
                view.setOnClickListener { layout.mListener?.refreshClick() }
            }
            return view
        }

        /**
         * 获取初始的空数据View

         * @param layoutInflater 布局填充器
         * *
         * @param item           空数据bean
         * *
         * @return 空数据View
         */
        fun getEmptyView(layoutInflater: LayoutInflater, item: EmptyItem?): View {
            val view = layoutInflater.inflate(R.layout.layout_empty, null)
            if (item != null) {
                val holder = EmptyViewHolder(view)
                view.tag = holder

                setImageAndText(item.tip, item.resId, holder.textTip, holder.ivImg)
            }
            return view
        }


        /**
         * 获取初始的空数据View

         * @param layoutInflater 布局填充器
         * *
         * @param item           空数据bean
         * *
         * @return 空数据View
         */
        fun getLoginView(layoutInflater: LayoutInflater, item: LoginItem?,
                         layout: StateLayout): View {
            val view = layoutInflater.inflate(R.layout.layout_login, null)
            if (item != null) {
                val holder = LoginViewHolder(view)
                view.tag = holder

                setImageAndText(item.tip, item.resId, holder.textTip, holder.ivImg)
                holder.btnLogin?.setOnClickListener { layout.mListener?.loginClick() }
            }
            return view
        }

        /**
         * 设置文字图片
         */
        private fun setImageAndText(tips: String, @DrawableRes resId: Int, textTips: TextView?, imageview: ImageView?) {
            if (!TextUtils.isEmpty(tips)) {
                textTips?.text = tips
            }
            if (resId > 0) {
                imageview?.setImageResource(resId)
            }
        }

    }
}