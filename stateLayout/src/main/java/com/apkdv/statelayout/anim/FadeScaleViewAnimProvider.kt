package com.apkdv.KotlinDemo.anim

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation

/**
 * desc   : 渐隐缩放动画
 */

class FadeScaleViewAnimProvider : ViewAnimProvider {


    override fun showAnimation(): Animation? {
        val set = AnimationSet(true)
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        val scaleAnimation = ScaleAnimation(0.1f, 1f, 0.1f, 1f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f)

        set.duration = 200
        set.interpolator = DecelerateInterpolator()
        set.addAnimation(alphaAnimation)
        set.addAnimation(scaleAnimation)
        return set
    }



    override fun hideAnimation(): Animation? {
        val set = AnimationSet(true)
        val alphaAnimation = AlphaAnimation(1.0f, 0.0f)
        val scaleAnimation = ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)

        set.duration = 200
        set.interpolator = DecelerateInterpolator()
        set.addAnimation(alphaAnimation)
        set.addAnimation(scaleAnimation)
        return set
    }
}
