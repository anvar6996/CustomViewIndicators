package uz.usoftkomunal.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.drawable.toBitmap


class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle) {
    var strokeDistance = 0
    var stroke = 0
    var textSize = 40f
    var hasLines = true
    var procent = 0.5f

    var colorFigure = Color.GREEN

    private val paintBg = Paint().apply {
        style = Paint.Style.FILL
//        color = colorFigure
    }
    var lineWith = 6f
    var longLineText = ArrayList<String>()
    private var count = longLineText.size
    var repeatLongLine = 10

    val paint = Paint().apply {
        style = Paint.Style.FILL
        color = Color.WHITE
        strokeWidth = lineWith
        textSize = 40f

    }


    override fun onDraw(canvas: Canvas) {
        paintBg(canvas)
        if (hasLines) {
            paintLines(canvas)
        }
    }

    private fun paintLines(canvas: Canvas) {
        longLineText.add("янв")
        longLineText.add("фев")
        longLineText.add("мар")
        longLineText.add("апр")
        longLineText.add("май")
        longLineText.add("июн")
        longLineText.add("июл")
        longLineText.add("авг")
        longLineText.add("сен")
        longLineText.add("ноя")
        longLineText.add("дек")
        for (i in 0 until 100) {
            if (i % repeatLongLine == 0) {
                canvas.drawLine(i * 25f, 100f, i * 25f, 220f, paint)
                if (longLineText.size >= count) {
                    canvas.drawText(longLineText[count], i * 25f, 250f, paint)
                    count++
                }
            } else {
                canvas.drawLine(i * 25f, 100f, i * 25f, 150f, paint)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun paintBg(canvas: Canvas) {
        when {
            procent < 0.5f && procent >= 0.2f -> {
                paintBg.color = Color.YELLOW
            }
            procent < 0.2f -> {
                paintBg.color = Color.RED
            }
            else -> {
                paintBg.color = Color.GREEN
            }
        }

        canvas.drawRect(0f, 0f, getScreenWidth() * procent, 500f, paintBg)
        val draw = resources.getDrawable(R.drawable.ic__label)
        canvas.drawBitmap(draw!!.toBitmap(36, 50, Bitmap.Config.ALPHA_8), getScreenWidth() * procent, 40f, paint)
    }

    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

}