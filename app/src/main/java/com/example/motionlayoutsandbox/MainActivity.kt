package com.example.motionlayoutsandbox

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.updateLayoutParams
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsandbox.base.DefAdapter
import com.example.motionlayoutsandbox.base.getStatusBarHeight


class MainActivity : AppCompatActivity() {

    companion object {
        private const val LAYOUT_EXTRA = "layout.extra"

        @JvmStatic
        fun getIntent(context: Context, layoutRes: Int) = Intent(context, MainActivity::class.java)
                .putExtra(LAYOUT_EXTRA, layoutRes)

    }

    @get:LayoutRes
    private val layoutRes: Int by lazy { intent.getIntExtra(LAYOUT_EXTRA, -1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)

        findViewById<RecyclerView>(R.id.rv)?.apply {
            adapter = DefAdapter()
        }

        findViewById<View>(R.id.status_bar_bg)?.apply {
            updateLayoutParams<ViewGroup.LayoutParams> {
                height = context.resources.getStatusBarHeight()
            }
        }

        val cardsContainer = findViewById<View>(R.id.cardsContainer)
        findViewById<NestedScrollView>(R.id.scrollView)?.apply {
            this.setOnClickListener {
                Log.d("example4", "click: $scrollY")
            }
            setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                Log.d("example4", "scrollViewOffsetY: $scrollY")
                val h = cardsContainer.height
                Log.d("example4", "cardsContainerH: $h; scrollViewOffsetY: $scrollY")
                cardsContainer.alpha = if (h <= scrollY) 0f else ((h / h - scrollY)).toFloat()
            })
        }
    }
}
