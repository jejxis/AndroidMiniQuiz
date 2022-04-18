package com.example.forminiquiz4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.forminiquiz4_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.Apple -> binding.textView.text = binding.Apple.text
                R.id.Banana -> binding.textView.text = binding.Banana.text
                R.id.Orange -> binding.textView.text = binding.Orange.text
            }
        }
    }
}
