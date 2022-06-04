package com.example.pricetraker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.PrecomputedText
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.pricetraker.fragment.HomeFragment
import com.example.pricetraker.fragment.MessagesFragment
import com.example.pricetraker.fragment.SupermercadoFragment
import com.example.pricetraker.fragment.TechnologyFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var toogle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //window.setFlags(PrecomputedText.Params)

        //Solucionar error de drawerLayout(id de activity_main) con "id 'kotlin-android-extensions'" en plugins de build.gradle
        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {

                    val frag = supportFragmentManager.beginTransaction()

                    frag.replace(R.id.fragmentContainerView, HomeFragment())

                    frag.commit()

                }

                R.id.nav_technolgy -> {

                    val frag = supportFragmentManager.beginTransaction()
                    frag.replace(R.id.fragmentContainerView, TechnologyFragment())
                    frag.commit()

                }

                R.id.nav_supermercado -> {
                    val frag = supportFragmentManager.beginTransaction()
                    frag.replace(R.id.fragmentContainerView, SupermercadoFragment())
                    frag.commit()

                }

                R.id.nav_messages -> {
                    /*
                    val frag = supportFragmentManager.beginTransaction()
                    frag.replace(R.id.fragmentContainerView, MessagesFragment())
                    frag.commit()
                    */
                    val lanzar = Intent(this@MainActivity, MapsActivity::class.java)

                    startActivity(lanzar)
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