package com.example.pricetraker.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.pricetraker.R
import com.example.pricetraker.databinding.ActivityMainBinding
import com.example.pricetraker.fragment.HomeFragment
import com.example.pricetraker.fragment.SupermercadoFragment
import com.example.pricetraker.fragment.TechnologyFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    private lateinit var toogle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    var titulo = "mi_actividad"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //window.setFlags(PrecomputedText.Params)

        //Solucionar error de drawerLayout(id de activity_main) con "id 'kotlin-android-extensions'" en plugins de build.gradle
        toogle = ActionBarDrawerToggle(this, drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.setTitle("Home")



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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_right, menu)
        return true
    }



}