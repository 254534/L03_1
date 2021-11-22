package com.example.l03_1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
//import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class MyPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return Fragment11.newInstance("f11", "Page # 1")
        return Fragment12.newInstance("f12", "Page # 2")
    }

    override fun getCount(): Int {
        return 2
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return
//    }
}
