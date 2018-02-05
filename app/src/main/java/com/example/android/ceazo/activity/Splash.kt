package com.example.android.ceazo.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.example.android.ceazo.R

class Splash : AppCompatActivity() {

    val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val timer: Thread = object : Thread(){
            override fun run() {
                try{
                    sleep(3000)
                }
                catch (e: Exception){
                    e.printStackTrace()
                    Log.e(TAG, e.message)
                }
                finally {
                    startActivity(Intent(this@Splash, MenuActivity::class.java))
                    finish()
                }
            }
        }

        timer.start()

    }
}
