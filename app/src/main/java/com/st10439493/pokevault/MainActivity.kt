package com.st10439493.pokevault

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationView
import com.st10439493.pokevault.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    var order = Order()
    private lateinit var binding:ActivityMainBinding
    //creating variable to store image view
    private  lateinit var img_pikachu: ImageView
    private  lateinit var img_croagunk: ImageView
    private  lateinit var img_chatot: ImageView
    private  lateinit var img_golisopod: ImageView
    private  lateinit var img_garchomp: ImageView
    private  lateinit var img_keldeo: ImageView
    private  lateinit var img_marshadow: ImageView
    private  lateinit var img_cubone: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        img_pikachu = findViewById(R.id.img_pikachu)
        img_pikachu.setOnClickListener ( this )
        img_croagunk = findViewById(R.id.img_croagunk)
        img_croagunk.setOnClickListener ( this )
        img_chatot = findViewById(R.id.img_chatot)
        img_chatot.setOnClickListener ( this )
        img_golisopod = findViewById(R.id.img_golisopod)
        img_golisopod.setOnClickListener ( this )
        img_garchomp = findViewById(R.id.img_garchomp)
        img_garchomp.setOnClickListener ( this )
        img_keldeo = findViewById(R.id.img_keldeo)
        img_keldeo.setOnClickListener ( this )
        img_marshadow = findViewById(R.id.img_marshadow)
        img_marshadow.setOnClickListener ( this )
        img_cubone = findViewById(R.id.img_cubone)
        img_cubone.setOnClickListener ( this )
        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val toggleOn = ActionBarDrawerToggle(this, binding.drawerLayout, binding.navToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_closed)
        binding.drawerLayout.addDrawerListener(toggleOn)
        toggleOn.syncState()
        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener (this)

        val backCallback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed(){
                if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }else{
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                    isEnabled = true
                }
            }
        }
        onBackPressedDispatcher.addCallback(this,backCallback)
    }

    override fun onClick(v: View?){
when(v?.id){
    R.id.img_pikachu -> order.productName = "Pikachu"
    R.id.img_chatot -> order.productName = "Chatot"
    R.id.img_cubone -> order.productName = "Cubone"
    R.id.img_garchomp -> order.productName = "Garchomp"
    R.id.img_golisopod -> order.productName = "Golisopod"
    R.id.img_keldeo -> order.productName = "Keldeo"
    R.id.img_marshadow -> order.productName = "Marshadow"
        }
        //Toast message displaying selected image
        Toast.makeText(this@MainActivity, "Order placed: "+order.productName, Toast.LENGTH_SHORT).show()
        openIntent(applicationContext,order.productName,OrderDetailsActivity::class.java)
    }

        override fun onNavigationItemSelected(item: MenuItem): Boolean{
            when(item.itemId){
                R.id.nav_photo -> openIntent(this,"",PokeSnapsActivity::class.java)
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return true
        }
    }
