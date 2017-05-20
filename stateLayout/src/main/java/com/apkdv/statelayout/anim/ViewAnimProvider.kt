package com.apkdv.KotlinDemo.anim

import android.view.animation.Animation

/**
 * <pre>
 * desc   : 基类ViewAnimProvider
</pre> *
 */

interface ViewAnimProvider {

    fun showAnimation(): Animation?

    fun hideAnimation(): Animation?

}
