package com.hafiz.weatheruz.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hafiz.weatheruz.R
import kotlinx.android.synthetic.main.activity_all_daily.*
import com.hafiz.weatheruz.Constants
import com.hafiz.weatheruz.model.Dayly
import com.hafiz.weatheruz.view.DailyViewPagerAdapter

class AllDailyActivity : AppCompatActivity() {
    lateinit var items: List<Dayly>
    lateinit var item: Dayly

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_daily)

        btnBackDaily.setOnClickListener {
            finish()
        }

        if (intent.hasExtra(Constants.EXTRA_DATA)) {
            items = intent.getSerializableExtra(Constants.EXTRA_DATA) as List<Dayly>
        } else {
            items = MainActivity.allDaylyList
        }

        if (intent.hasExtra(Constants.EXTRA_DATA_2)) {
            item = intent.getSerializableExtra(Constants.EXTRA_DATA_2) as Dayly
        } else {
            item = items[0]
        }

        viewPagerDaily.adapter = DailyViewPagerAdapter(supportFragmentManager, items)
        tablayoutDaily.setupWithViewPager(viewPagerDaily)
        tablayoutDaily.getTabAt(items.indexOf(item))?.select()
    }
}