package com.ryan.luckywheel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rubikstudio.library.model.LuckyItem
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val data: MutableList<LuckyItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        luckyWheel.isTouchEnabled
        val luckyItem1 = LuckyItem("100", R.drawable.test1, -0xc20)
        data.add(luckyItem1)

        val luckyItem2 = LuckyItem("200", R.drawable.test2, -0x1f4e)
        data.add(luckyItem2)

        data.add(LuckyItem("300", R.drawable.test3, -0x3380))
        data.add(LuckyItem("400", R.drawable.test4, -0xc20))
        data.add(LuckyItem("500", R.drawable.test5, -0x1f4e))
        data.add(LuckyItem("600", R.drawable.test6, -0x3380))
        data.add(LuckyItem("700", R.drawable.test7, -0xc20))
        data.add(LuckyItem("800", R.drawable.test8, -0x1f4e))
        data.add(LuckyItem("900", R.drawable.test9, -0x3380))
        data.add(LuckyItem("1000", R.drawable.test10, -0x1f4e))

        luckyWheel.setData(data)
        luckyWheel.setRound(5)

        play.setOnClickListener {
            val index = randomNumber()
            luckyWheel.startLuckyWheelWithTargetIndex(index)
        }

        luckyWheel.setLuckyRoundItemSelectedListener {
            Toast.makeText(this, data[it].topText, Toast.LENGTH_SHORT).show()
        }
    }
    private fun randomNumber(): Int {
        val random = Random.nextInt(data.size - 1) + 0
        return random
//        rand.nextInt(data.size() - 1) + 0;
    }
}
