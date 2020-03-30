package com.example.motionlayoutsandbox

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
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
    }

}
