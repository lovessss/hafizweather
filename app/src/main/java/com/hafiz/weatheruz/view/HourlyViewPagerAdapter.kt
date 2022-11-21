package com.hafiz.weatheruz.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.hafiz.weatheruz.model.Dayly
import com.hafiz.weatheruz.screen.HourlyFragment
import com.hafiz.weatheruz.service.Functions

class HourlyViewPagerAdapter(fm: FragmentManager, var items: List<Dayly>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        val fragment = HourlyFragment(items[position])
        return fragment
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getPageTitle(position: Int): CharSequence {
        var weekNAmeHourly = Functions().getWeekName("${items[position].dt_txt.subSequence(0, 10)}")
        var timeHourly = Functions().timeStampToLocalDate(items[position].dt.toLong())
        return "$weekNAmeHourly\n$timeHourly"
    }

}