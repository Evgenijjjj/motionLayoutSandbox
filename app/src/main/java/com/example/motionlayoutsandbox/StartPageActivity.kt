package com.example.motionlayoutsandbox

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutsandbox.base.StartPageAdapter
import kotlinx.android.synthetic.main.activity_start_page.*

class StartPageActivity : AppCompatActivity() {

    companion object {
        val EXAMPLES = listOf<Class<*>>(MainActivity::class.java)
    }

    private val adapter by lazy {
        StartPageAdapter(mData = EXAMPLES.mapIndexed { index, clazz ->
            "Example $index" to { startActivity(Intent(this, clazz)) }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)
        rv.adapter = adapter
    }
}
