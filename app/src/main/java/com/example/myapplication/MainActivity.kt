package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

import com.example.newlibrary.network.ApiService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(com.example.newlibrary.ui.fragments.Home())
        apiService = com.example.newlibrary.network.ApiService(this)

        apiService.getCharacters { apiResponse, error ->
            if (error != null) {
                Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
            } else {
                val characters = apiResponse?.results
                if (characters != null) {
                    for (character in characters) {
                        println("${character.name}")
                    }
                }
            }
        }
        //new branch jbc

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                com.example.newlibrary.R.id.itemConfiguration -> replaceFragment(com.example.newlibrary.ui.fragments.Configuration())
                com.example.newlibrary.R.id.itemHome -> replaceFragment(com.example.newlibrary.ui.fragments.Home())
                com.example.newlibrary.R.id.itemInfo -> replaceFragment(com.example.newlibrary.ui.fragments.Info())

                else -> {

                }


            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}