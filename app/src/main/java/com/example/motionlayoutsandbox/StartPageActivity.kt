package com.example.motionlayoutsandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motionlayoutsandbox.base.StartPageAdapter
import kotlinx.android.synthetic.main.activity_start_page.*

class StartPageActivity : AppCompatActivity() {

    companion object {
        val EXAMPLES = listOf<Int>(R.layout.activity_main, R.layout.example_2)
    }

    private val adapter by lazy {
        StartPageAdapter(mData = EXAMPLES.mapIndexed { index, id ->
            "Example $index" to { startActivity(MainActivity.getIntent(baseContext, id)) }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)
        rv.adapter = adapter
    }
}
