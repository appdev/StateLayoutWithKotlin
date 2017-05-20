package com.apkdv.KotlinDemo.helper

import android.view.View
import android.view.animation.Animation
import com.apkdv.KotlinDemo.anim.FadeScaleViewAnimProvider
import com.apkdv.KotlinDemo.anim.ViewAnimProvider

/**
 * Created by LengYue on 2017/5/20.
 */
class AnimationHelper {
    companion object {
        /**
         * 切换布局
         * @param useAnimation 是否使用动画
         * *
         * @param viewAnimProvider 动画持有类
         * *
         * @param fromView 开始View
         * *
         * @param toView 结束View
         */
        fun switchViewByAnim(useAnimation: Boolean, viewAnimProvider: ViewAnimProvider?,
                             fromView: View?, toView: View?) {
            var animProvider = viewAnimProvider
            if (fromView === toView)
                return
            if (useAnimation) {
                if (animProvider == null) {
                    //使用默认动画
                    animProvider = FadeScaleViewAnimProvider()
                }
                val hideAnimation = animProvider.hideAnimation()
                val showAnimation = animProvider.showAnimation()
                if (fromView != null) {
                    if (hideAnimation != null) {
                        hideAnimation.setAnimationListener(object : Animation.AnimationListener {
                            override fun onAnimationStart(animation: Animation) {

                            }

                            override fun onAnimationEnd(animation: Animation) {
                                fromView.visibility = View.GONE
                            }

                            override fun onAnimationRepeat(animation: Animation) {

                            }
                        })
                        hideAnimation.fillAfter = false
                        fromView.startAnimation(hideAnimation)
                    } else {
                        fromView.visibility = View.GONE
                    }
                }
                if (toView != null) {
                    if (toView.visibility != View.VISIBLE) {
                        toView.visibility = View.VISIBLE
                    }
                    if (showAnimation != null) {
                        showAnimation.fillAfter = false
                        toView.startAnimation(showAnimation)
                    }
                }
            } else {
                if (fromView != null) {
                    fromView.visibility = View.GONE
                }
                if (toView != null) {
                    toView.visibility = View.VISIBLE
                }
            }
        }

    }
}