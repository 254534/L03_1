package com.example.l03_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), Fragment1.OnSelectListener {
    var f11: Fragment11? = null
    var f12: Fragment12? = null
    var myTrans: FragmentTransaction? = null
    private val TAG_F11 = "Fragment11"
    private val TAG_F12 = "Fragment12"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            f11 = Fragment11()
            f12 = Fragment12()
            myTrans = supportFragmentManager.beginTransaction()
            myTrans!!.add(R.id.fg_container2, f11!!, this.TAG_F11)
            myTrans!!.detach(f11!!)
            myTrans!!.add(R.id.fg_container2, f12!!, this.TAG_F12)
            myTrans!!.detach(f12!!)
            myTrans!!.commit()
        }
        else {
            f11 = supportFragmentManager.findFragmentByTag(this.TAG_F11) as Fragment11?
            f12 = supportFragmentManager.findFragmentByTag(this.TAG_F12) as Fragment12?
        }
    }

    override fun onSelect(option: Int) {
        myTrans = supportFragmentManager.beginTransaction()

        when(option) {
            1 -> {
                myTrans?.detach(f12!!)
                myTrans?.attach(f11!!)
            }
            2 -> {
                myTrans?.detach(f11!!)
                myTrans?.attach(f12!!)
            }
        }
        myTrans?.commit()
    }
}