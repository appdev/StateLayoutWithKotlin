package com.apkdv.KotlinDemo.anim

import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator

/**
 * <pre>
 * desc   : 渐隐动画
</pre> *
 */

class FadeViewAnimProvider : ViewAnimProvider {

    override fun showAnimation(): Animation {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 200
        animation.interpolator = DecelerateInterpolator()
        return animation
    }

    override fun hideAnimation(): Animation {
        val animation = AlphaAnimation(1.0f, 0.0f)
        animation.duration = 200
        animation.interpolator = AccelerateDecelerateInterpolator()
        return animation
    }

}
