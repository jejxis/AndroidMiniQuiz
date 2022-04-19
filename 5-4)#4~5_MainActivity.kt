package com.example.miniquizchap5

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.miniquizchap5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customRect = MyRectangle(this)
        binding.root.addView(customRect)

        val customDonut = MyDonut(this)
        binding.root.addView(customDonut)
    }
}
class MyRectangle(context: Context): View(context){
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val myRecFill = Paint()
        myRecFill.style = Paint.Style.FILL
        myRecFill.color = Color.BLUE
        val rectFill = RectF(200f, 200f, 1000f, 600f)
        canvas?.drawRoundRect(rectFill, 50f, 50f, myRecFill)

        val myRecStroke = Paint()
        myRecStroke.style = Paint.Style.STROKE
        myRecStroke.color = Color.RED
        myRecStroke.strokeWidth=30f
        val rectStroke = RectF(200f, 200f, 1000f, 600f)
        canvas?.drawRoundRect(rectStroke, 50f, 50f, myRecStroke)
    }
}
class MyDonut(context: Context): View(context){
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val red = Paint()
        red.style = Paint.Style.FILL
        red.color = Color.RED
        canvas?.drawCircle(200f, 900f, 150f, red)

        val white = Paint()
        white.style = Paint.Style.FILL
        white.color = Color.WHITE
        canvas?.drawCircle(200f, 900f, 90f, white)
    }
}
