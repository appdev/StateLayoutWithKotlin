package com.apkdv.KotlinDemo.pagestate

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.view.LayoutInflater
import com.apkdv.KotlinDemo.bean.*
import com.apkdv.KotlinDemo.anim.ViewAnimProvider
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import com.apkdv.KotlinDemo.helper.AnimationHelper
import com.apkdv.statelayout.helper.LayoutHelper
import com.apkdv.KotlinDemo.holder.*


/**
 * Created by LengYue on 2017/5/19.
 */
class StateLayout : FrameLayout {
    val ERROR = 1
    val EMPTY = 2
    val TIMEOUT = 3
    val NOT_NETWORK = 4
    val LOADING = 5
    val LOGIN = 6

    private var contentView: View? = null
    private var emptyView: View? = null
    private var errorView: View? = null
    private var loadingView: View? = null
    private var timeOutView: View? = null
    private var notNetworkView: View? = null
    private var loginView: View? = null

    var errorItem: ErrorItem? = null
    var noNetworkItem: NoNetworkItem? = null
    var emptyItem: EmptyItem? = null
    var loadingItem: LoadingItem? = null
    var timeOutItem: TimeOutItem? = null
    var loginItem: LoginItem? = null
    private var viewAnimProvider: ViewAnimProvider? = null
    private var useAnimation = false
    private var currentShowingView: View? = null
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var mListener: OnViewRefreshListener? = null

    constructor(context: Context) : super(context)


    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)


    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        LayoutHelper.parseAttr(context, attrs, this)

    }

    fun checkIsContentView(view: View?) {
        view?.apply {
            if (contentView == null && view != errorView && view != notNetworkView
                    && view != loadingView && view != timeOutView && view != loginView
                    && view != emptyView) {
                contentView = view
                currentShowingView = contentView
            }
        }

    }
    //************ showView ************//

    /**
     * 展示错误的界面
     */
    fun showErrorView() {
        inflaterErrorView()
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView)
        currentShowingView = errorView
    }


    /**
     * 展示错误的界面

     * @param msg 提示语
     */
    fun showErrorView(msg: String) {
        inflaterErrorView()
        setTipText(ERROR, msg)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView)
        currentShowingView = errorView
    }


    /**
     * 展示错误的界面

     * @param msg   提示语
     * *
     * @param imgId 图片Id
     */
    fun showErrorView(msg: String, imgId: Int) {
        inflaterErrorView()
        setTipText(ERROR, msg)
        setTipImg(ERROR, imgId)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView)
        currentShowingView = errorView
    }

    /**
     * 展示空数据的界面
     */
    fun showEmptyView() {
        inflaterEmptyView()
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView)
        currentShowingView = emptyView
    }



    /**
     * 展示空数据的界面

     * @param msg 提示语
     */
    fun showEmptyView(msg: String) {
        inflaterEmptyView()
        setTipText(EMPTY, msg)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView)
        currentShowingView = emptyView
    }


    /**
     * 展示空数据的界面

     * @param msg   提示语
     * *
     * @param imgId 图片Id
     */
    fun showEmptyView(msg: String, imgId: Int) {
        inflaterEmptyView()
        setTipText(EMPTY, msg)
        setTipImg(EMPTY, imgId)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView)
        currentShowingView = emptyView
    }

    /**
     * 展示超时的界面
     */
    fun showTimeoutView() {
        inflaterTimeoutView()
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView)
        currentShowingView = timeOutView
    }


    /**
     * 展示超时的界面

     * @param msg 提示语
     */
    fun showTimeoutView(msg: String) {
        inflaterTimeoutView()
        setTipText(TIMEOUT, msg)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView)
        currentShowingView = timeOutView
    }



    /**
     * 展示超时的界面

     * @param msg   提示语
     * *
     * @param imgId 图片Id
     */
    fun showTimeoutView(msg: String, imgId: Int) {
        inflaterTimeoutView()
        setTipText(TIMEOUT, msg)
        setTipImg(TIMEOUT, imgId)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView)
        currentShowingView = timeOutView
    }

    /**
     * 展示没有网络的界面
     */
    fun showNoNetworkView() {
        inflaterNoNetworkView()
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView)
        currentShowingView = notNetworkView
    }


    /**
     * 展示没有网络的界面

     * @param msg 提示语
     */
    fun showNoNetworkView(msg: String) {
        inflaterNoNetworkView()
        setTipText(NOT_NETWORK, msg)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView)
        currentShowingView = notNetworkView
    }

    /**
     * 展示没有网络的界面

     * @param msgId 提示语
     * *
     * @param imgId 图片Id
     */
    fun showNoNetworkView(msg: String, imgId: Int) {
        inflaterNoNetworkView()
        setTipText(NOT_NETWORK, msg)
        setTipImg(NOT_NETWORK, imgId)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView)
        currentShowingView = notNetworkView
    }

    /**
     * 展示登录的界面
     */
    fun showLoginView() {
        inflaterLoginView()
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView)
        currentShowingView = loginView
    }


    /**
     * 展示登录的界面

     * @param msg 提示语
     */
    fun showLoginView(msg: String) {
        inflaterLoginView()
        setTipText(LOGIN, msg)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView)
        currentShowingView = loginView
    }

    /**
     * 展示登录的界面

     * @param msg   提示语
     * *
     * @param imgId 图片Id
     */
    fun showLoginView(msg: String, imgId: Int) {
        inflaterLoginView()
        setTipText(LOGIN, msg)
        setTipImg(LOGIN, imgId)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView)
        currentShowingView = loginView
    }


    /**
     * 展示加载中的界面
     */
    fun showLoadingView() {
        inflaterLoadingView()
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView)
        currentShowingView = loadingView
    }

    /**
     * 展示加载中的界面

     * @param view 进度条部分
     */
    fun showLoadingView(view: View) {
        inflaterLoadingView()
        setLoadingView(view)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView)
        currentShowingView = loadingView
    }

    /**
     * 展示加载中的界面

     * @param msg 提示语
     */
    fun showLoadingView(msg: String) {
        inflaterLoadingView()
        setTipText(LOADING, msg)
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView)
        currentShowingView = loadingView
    }

    /**
     * 展示内容的界面
     */
    fun showContentView() {
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, contentView)
        currentShowingView = contentView
    }


    //************ inflater ************//
    /**
     * inflater loadingView
     */
    fun inflaterLoadingView() {
        if (loginView == null) {
            loadingView = LayoutHelper.getLoadingView(inflater, loadingItem)
            addView(loadingView)
            loadingView?.visibility = View.GONE
        }

    }

    /**
     * inflater loginView
     */
    fun inflaterLoginView() {
        if (loginView == null) {
            loginView = LayoutHelper.getLoginView(inflater, loginItem, this@StateLayout)
            addView(loginView)
            loginView?.visibility = View.GONE
        }

    }

    /**
     * inflater NoNetworkView
     */
    fun inflaterNoNetworkView() {
        if (notNetworkView == null) {
            notNetworkView = LayoutHelper.getNoNetworkView(inflater, noNetworkItem, this)
            addView(notNetworkView)
            notNetworkView?.visibility = View.GONE
        }
    }

    /**
     * inflater TimeoutView
     */
    fun inflaterTimeoutView() {
        if (timeOutView == null) {
            timeOutView = LayoutHelper.getTimeOutView(inflater, timeOutItem, this)
            addView(timeOutView)
            timeOutView?.visibility = View.GONE
        }
    }
    /**
     * inflater EmptyView
     */
    fun inflaterEmptyView() {
        if (emptyView == null) {
            emptyView = LayoutHelper.getEmptyView(inflater, emptyItem)
            addView(emptyView)
            emptyView?.visibility = View.GONE
        }
    }/**
     * inflater ErrorView
     */
    fun inflaterErrorView() {
        if (errorView == null) {
            errorView = LayoutHelper.getErrorView(inflater, errorItem, this)
            addView(errorView)
            errorView?.visibility = View.GONE
        }
    }

    //************ inflater ************//


    /**
     * 添加用户自定义的View

     * @param view 自定义View
     */
    fun showCustomView(view: View) {
        view.layoutParams = this.layoutParams
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, view)
        currentShowingView = view
    }

    //************ update ************//

    /**
     * 修改提示文字

     * @param type 传入修改哪个
     * *
     * @param text 文字
     */
    fun setTipText(type: Int, text: String?) {
        if (text == null) { //text is null
            return
        }
        when (type) {
            ERROR -> (errorView?.tag as ErrorViewHolder).textTip?.text = text
            EMPTY -> (emptyView?.tag as EmptyViewHolder).textTip?.text = text
            TIMEOUT -> (timeOutView?.tag as TimeOutViewHolder).textTip?.text = text
            NOT_NETWORK -> (notNetworkView?.tag as NoNetworkViewHolder).textTip?.text = text
            LOADING -> (loadingView?.tag as LoadingViewHolder).textTip?.text = text
            LOGIN -> (loginView?.tag as LoginViewHolder).textTip?.text = text
        }
    }

    /**
     * 修改提示文字

     * @param type   传入修改哪个
     * *
     * @param textId 文字资源id
     */
    fun setTipText(type: Int, textId: Int) {
        this.setTipText(type, context.getString(textId))
    }

    /**
     * 设置提示图片资源

     * @param type     传入修改哪个，除了Loading
     * *
     * @param drawable 图片资源drawable
     */
    fun setTipImg(type: Int, drawable: Drawable) {
        when (type) {
            ERROR -> (errorView?.tag as ErrorViewHolder).ivImg?.setImageDrawable(drawable)
            EMPTY -> (emptyView?.tag as EmptyViewHolder).ivImg?.setImageDrawable(drawable)
            TIMEOUT -> (timeOutView?.tag as TimeOutViewHolder).ivImg?.setImageDrawable(drawable)
            NOT_NETWORK -> (notNetworkView?.tag as NoNetworkViewHolder).ivImg?.setImageDrawable(drawable)
            LOGIN -> (loadingView?.tag as LoginViewHolder).ivImg?.setImageDrawable(drawable)
        }
    }

    /**
     * 设置提示图片资源

     * @param type  传入修改哪个，除了Loading
     * *
     * @param imgId 图片资源id
     */
    fun setTipImg(type: Int, imgId: Int) {
        this.setTipImg(type, context.resources.getDrawable(imgId))
    }


    /**
     * 设置加载界面的View

     * @param view 显示的View
     */
    fun setLoadingView(view: View) {
        (loadingView?.tag as LoadingViewHolder).frameLayout?.removeAllViews()
        (loadingView?.tag as LoadingViewHolder).frameLayout?.addView(view)
    }

    //************ animation ************//

    fun setViewSwitchAnimProvider(animProvider: ViewAnimProvider) {
        this.viewAnimProvider = animProvider

    }

    fun getViewAnimProvider(): ViewAnimProvider? {
        return viewAnimProvider
    }

    fun isUseAnimation(): Boolean {
        return useAnimation
    }

    fun setUseAnimation(useAnimation: Boolean) {
        this.useAnimation = useAnimation
    }

    //************ callBack ************//
    interface OnViewRefreshListener {
        //刷新界面
        fun refreshClick()

        //登录点击
        fun loginClick()
    }

    //************ addView ************//
    override fun addView(child: View?) {
        checkIsContentView(child)
        super.addView(child)
    }

    override fun addView(child: View, index: Int) {
        checkIsContentView(child)
        super.addView(child, index)
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        checkIsContentView(child)
        super.addView(child, index, params)
    }

    override fun addView(child: View, params: ViewGroup.LayoutParams) {
        checkIsContentView(child)
        super.addView(child, params)
    }

    override fun addView(child: View, width: Int, height: Int) {
        checkIsContentView(child)
        super.addView(child, width, height)
    }

    override fun addViewInLayout(child: View, index: Int, params: ViewGroup.LayoutParams): Boolean {
        checkIsContentView(child)
        return super.addViewInLayout(child, index, params)
    }

    override fun addViewInLayout(child: View, index: Int, params: ViewGroup.LayoutParams, preventRequestLayout: Boolean): Boolean {
        checkIsContentView(child)
        return super.addViewInLayout(child, index, params, preventRequestLayout)
    }
}