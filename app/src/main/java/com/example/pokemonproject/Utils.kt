package com.example.pokemonproject

import android.content.Context
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP


fun Context.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(
        COMPLEX_UNIT_DIP,
        dp.toFloat(),
        resources.displayMetrics).toInt()
}