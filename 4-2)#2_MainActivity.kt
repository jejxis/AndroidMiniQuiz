package com.example.forminiquiz4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.example.forminiquiz4_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    val msg: String = "가 체크되었습니다."
    var org: String = ""
    var list = mutableListOf<String>()
    val listener by lazy{
        CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){
                when(compoundButton.id){
                    R.id.Apple -> list.add("사과")
                    R.id.Banana -> list.add("바나나")
                    R.id.Orange -> list.add("오렌지")
                }
            }else{
                when(compoundButton.id){
                    R.id.Apple -> list.remove("사과")
                    R.id.Banana -> list.remove("바나나")
                    R.id.Orange -> list.remove("오렌지")
                }
            }
            binding.textView.text = msg.let{
                for(index in 0 until list.size){
                    org = org.plus(list[index])
                    if(index < list.size-1) org = org.plus("와 ")
                }
                if(org.length >0 ) org.plus(it)
                else ""
            }
            org = ""
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = ""
        binding.Apple.setOnCheckedChangeListener(listener)
        binding.Banana.setOnCheckedChangeListener(listener)
        binding.Orange.setOnCheckedChangeListener(listener)
    }
}
