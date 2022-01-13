package uz.usoftkomunal.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemIndicator = findViewById<CustomView>(R.id.date)
        val itemIndicatorMonth = findViewById<CustomView>(R.id.dateOnMonth)
        val indicatorElektr = findViewById<CustomView>(R.id.indicatorElektr)
        indicatorElektr.hasLines = false
        itemIndicator.withBg = 800f
        itemIndicatorMonth.withBg = 150f
        itemIndicator.textSize = 40f
        itemIndicatorMonth.repeatLongLine = 12
        val textsLongLine = ArrayList<String>()
        textsLongLine.add("окт")
        textsLongLine.add("ноя")
        textsLongLine.add("дек")
        textsLongLine.add("янв")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        textsLongLine.add("фев")
        itemIndicatorMonth.longLineText.addAll(textsLongLine)
    }
}