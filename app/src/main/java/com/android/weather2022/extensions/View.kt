package com.android.weather2022.extensions

import android.view.View

fun View.switchVisibility(visible: Boolean) {
    if(visible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}