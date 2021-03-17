package com.example.casbac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.casbac.adapter.ProductAdapter
import com.example.casbac.model.Product
import com.example.casbac.model.ProductData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out
        ).replace(R.id.content, fragment, fragment.javaClass.simpleName).commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = HomeFragment()
        addFragment(fragment)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val home = HomeFragment()
                    addFragment(home)
                }
                R.id.profile -> {
                    val profile = ProfileFragment()
                    addFragment(profile)
                }
            }
            true
        }
    }
}