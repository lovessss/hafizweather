package com.hafiz.weatheruz.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_all_hourly.*
import com.hafiz.weatheruz.Constants
import com.hafiz.weatheruz.R
import com.hafiz.weatheruz.model.Dayly
import com.hafiz.weatheruz.view.HourlyViewPagerAdapter

class AllHourlyActivity : AppCompatActivity() {
    lateinit var items: List<Dayly>
    lateinit var item: Dayly

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_hourly)

        btnBack.setOnClickListener {
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

        viewPager.adapter = HourlyViewPagerAdapter(supportFragmentManager, items)
        tablayout.setupWithViewPager(viewPager)
        tablayout.getTabAt(items.indexOf(item))?.select()

    }
}