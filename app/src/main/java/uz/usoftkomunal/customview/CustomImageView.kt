package uz.usoftkomunal.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class CustomImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle) {
    var with = 400f
    var colorFigure = Color.GREEN
    private val paint = Paint().apply {
        style = Paint.Style.FILL
//        color = colorFigure
    }


    override fun onDraw(canvas: Canvas) {
        when {
            with < 500f && with >= 200 -> {
                paint.color = Color.YELLOW
            }
            with < 200f -> {
                paint.color = Color.RED
            }
            else -> {
                paint.color = Color.GREEN
            }
        }
        canvas.drawRect(0f, 0f, with, 500f, paint)
    }
}