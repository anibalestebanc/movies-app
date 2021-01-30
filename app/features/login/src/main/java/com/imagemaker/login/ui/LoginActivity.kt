package com.imagemaker.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.imagemaker.login.databinding.LoginActivityBinding

/**
 * Created by Anibal Cortez on 29-01-21.
 */
class LoginActivity :AppCompatActivity() {

    private var binding: LoginActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    companion object{
        fun launch(context: Context){
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}