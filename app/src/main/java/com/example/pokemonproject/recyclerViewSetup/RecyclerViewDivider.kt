package com.example.pokemonproject.recyclerViewSetup

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonproject.dpToPx

class RecyclerViewDivider(
    context: Context,
    resId: Int
) : RecyclerView.ItemDecoration() {

    private var context = context
    private var divider = ContextCompat.getDrawable(context, resId)!!

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val dividerLeft = context.dpToPx(10)

        val dividerRight = parent.width - dividerLeft

        for (i in 0 until parent.childCount) {

            if (i != parent.childCount - 1) {
                val child = parent.getChildAt(i)

                val params = child.layoutParams as RecyclerView.LayoutParams

                val dividerTop = child.bottom + params.bottomMargin
                val dividerBottom = dividerTop + divider.intrinsicHeight

                divider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom)
                divider.draw(c)
            }
        }
    }
}