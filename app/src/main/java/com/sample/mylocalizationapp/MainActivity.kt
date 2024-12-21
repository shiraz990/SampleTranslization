package com.sample.mylocalizationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import androidx.lifecycle.lifecycleScope
import com.sample.mylocalizationapp.databinding.ActivityMainBinding
import com.zoetrope.translization.HttpClient
import com.zoetrope.translization.HuggingFaceTranslator
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        binding.fab.setOnClickListener { view ->
            translateStrings(binding.inputTranslatedText.text.toString())
        }
    }


    fun translateStrings(inputString: String) {
        lifecycleScope.launch {

            HuggingFaceTranslator(HttpClient()).translateToArabic(inputString).let {
                response-> "Response : $response".also { binding.translatedText.text = it }
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


}