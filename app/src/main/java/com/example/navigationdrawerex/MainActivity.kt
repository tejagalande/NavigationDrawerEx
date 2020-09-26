package com.example.navigationdrawerex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var homefragment : HomeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tool_bar)
         supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val drawerToggle : ActionBarDrawerToggle = object :ActionBarDrawerToggle(this,drawer_layout,tool_bar,R.string.drawer_open,R.string.drawer_close){

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                setTitle(R.string.app_name)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.option)
            }

        }


        homefragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,homefragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        //navigation view
        nav_view.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.home -> {
                    loadHome(HomeFragment())
                    true
                }

                R.id.trend -> {
                    loadTrend(TrendingFragment())
                    true
                }

                R.id.library -> {
                    loadLibrary(LibraryFragment())
                    true
                }

                R.id.inbox -> {
                    loadInbox(InboxFragment())
                    true
                }

                R.id.subscript -> {
                    loadSubscription(SubscriptionFragment())
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }



    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    fun loadHome(frag1 : HomeFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.framelayout,frag1).commit()
    }

    fun loadTrend(frag2 : TrendingFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.framelayout,frag2).commit()
    }

    fun loadInbox(frag3 : InboxFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.framelayout,frag3).commit()
    }

    fun loadLibrary(frag4 : LibraryFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.framelayout,frag4).commit()
    }

    fun loadSubscription(frag5 : SubscriptionFragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.framelayout,frag5).commit()
    }
}