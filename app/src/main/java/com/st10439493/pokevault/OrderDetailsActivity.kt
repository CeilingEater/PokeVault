package com.st10439493.pokevault

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.st10439493.pokevault.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    var order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
    val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
    setContentView(binding.root)
        //get the name of the ordered product from the intent
        order.productName = intent.getStringExtra("order").toString()
        //set the product name on the text view
        binding.tvOrder.text = order.productName

        when(order.productName){
            "Pikachu" -> binding.imgOrderedPokemon.setImageResource(R.drawable.pikachu)
            "Chatot" -> binding.imgOrderedPokemon.setImageResource(R.drawable.chatot)
            "Croagunk" -> binding.imgOrderedPokemon.setImageResource(R.drawable.croagunk)
            "Cubone" -> binding.imgOrderedPokemon.setImageResource(R.drawable.cubone)
            "Garchomp" -> binding.imgOrderedPokemon.setImageResource(R.drawable.garchomp)
            "Golisopod" -> binding.imgOrderedPokemon.setImageResource(R.drawable.golisopod)
            "Keldeo" -> binding.imgOrderedPokemon.setImageResource(R.drawable.keldeo)
            "Marshadow" -> binding.imgOrderedPokemon.setImageResource(R.drawable.marshadow)

        }
        binding.fabOrder.setOnClickListener(){shareIntent(applicationContext, order.productName)}

    }
}