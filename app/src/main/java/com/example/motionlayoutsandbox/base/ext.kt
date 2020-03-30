package com.example.motionlayoutsandbox.base

import android.content.res.Resources

fun Resources.getStatusBarHeight(): Int {
    var result = 0
    val resourceId = getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = getDimensionPixelSize(resourceId)
    }
    return result
}