package com.example.casbac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var content: FrameLayout? = null
    private var navigation: BottomNavigationView? = null

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val fragment = HomeFragment.newInstance()
                    addFragment(fragment)

                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    val fragment = ProfileFragment()
                    addFragment(fragment)

                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out
        ).replace(R.id.content, fragment, fragment.javaClass.simpleName).commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)
    }
}