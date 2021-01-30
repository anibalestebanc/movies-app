package com.imagemaker.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imagemaker.login.ui.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)
        LoginActivity.launch(this).apply {
            finish()
        }
    }
}