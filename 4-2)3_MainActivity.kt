package com.example.forminiquiz4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import com.example.forminiquiz4_2.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    var num: Long = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        thread(start=true){//서브 스레드
            while(true){
                Thread.sleep(1000)
                runOnUiThread { //메인 스레드
                    num += 1
                    binding.textView.text = num.toString()
                }
            }
        }
    }
}
