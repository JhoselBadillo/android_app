package com.example.newlibrary.network

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.newlibrary.network.model.ApiResponse
import com.example.newlibrary.network.model.Character
class ApiService(private val context: Context){
    private val baseUrl = "https://rickandmortyapi.com/api/character"

    fun getCharacters(onResponse: (ApiResponse?, String?) -> Unit){
        val requestQueue = Volley.newRequestQueue(context)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, baseUrl, null,
            Response.Listener { response ->
                val characters = mutableListOf<Character>()

                val resultsArray = response.getJSONArray("results")
                for (i in 0 until resultsArray.length()){
                    val characterJson = resultsArray.getJSONObject(i)
                    val character = Character(
                        characterJson.getInt("id"),
                        characterJson.getString("name"),
                        characterJson.getString("image")
                    )
                    characters.add(character)
                }

                val apiResponse = ApiResponse(characters)
                onResponse(apiResponse, null)
            },
            Response.ErrorListener { error ->
                onResponse(null, error.message)
            }
        )

        requestQueue.add(jsonObjectRequest)
    }


}