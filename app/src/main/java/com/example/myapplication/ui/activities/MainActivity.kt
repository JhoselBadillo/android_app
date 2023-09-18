package com.example.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.ui.fragments.Configuration
import com.example.myapplication.ui.fragments.Home
import com.example.myapplication.ui.fragments.Info
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.ApiService

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        apiService = ApiService(this)

        apiService.getCharacters{ apiResponse, error ->
            if(error != null){
                Toast.makeText(this,"Error: $error", Toast.LENGTH_SHORT).show()
            } else {
                val characters = apiResponse?.results
                if(characters != null){
                    for (character in characters){
                        println("${character.name}")
                    }
                }
            }
        }
        //new branch jbc

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.configuration -> replaceFragment(Configuration())
                R.id.home -> replaceFragment(Home())
                R.id.info -> replaceFragment(Info())

                else -> {

                }


            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}