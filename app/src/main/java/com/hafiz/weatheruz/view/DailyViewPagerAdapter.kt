package com.hafiz.weatheruz.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.hafiz.weatheruz.model.Dayly
import com.hafiz.weatheruz.screen.DailyFragment
import com.hafiz.weatheruz.service.Functions

class DailyViewPagerAdapter(fm: FragmentManager, var items: List<Dayly>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        val fragment = DailyFragment(items[position])
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var weekNAmeHourly = Functions().getWeekName("${items[position].dt_txt.subSequence(0, 10)}")
        var dateToday = items[position].dt_txt.subSequence(5, 10).toString().replace("-", "/")
        return "$dateToday\n$weekNAmeHourly"
    }
}