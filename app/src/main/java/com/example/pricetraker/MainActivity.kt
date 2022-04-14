package com.example.pricetraker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Solucionar error de drawerLayout(id de activity_main) con "id 'kotlin-android-extensions'" en plugins de build.gradle
       toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }

                R.id.nav_camera -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, CameraFragment())
                        commit()
                    }
                }

                R.id.nav_gallery -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, GalleryFragment())
                        commit()
                    }
                }

                R.id.nav_messages -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, MessagesFragment())
                        commit()
                    }
                }

            }
            //Al precionar una opcion el panel de navegacion se esconde
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}