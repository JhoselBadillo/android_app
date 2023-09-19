package com.example.newlibrary.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newlibrary.R

import com.example.newlibrary.ui.helpers.Helpers
import com.example.newlibrary.ui.adapters.CharacterAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {

    private lateinit var characterRecyclerView: RecyclerView
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        characterRecyclerView = view.findViewById(R.id.rvChatacters)
        characterRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        characterAdapter = com.example.newlibrary.ui.adapters.CharacterAdapter(emptyList())

        characterRecyclerView.adapter = characterAdapter

        getData()

        return view
    }

    private fun getData(){
        val apiService = com.example.newlibrary.network.ApiService(requireContext())
        val helpers = Helpers()

        apiService.getCharacters{apiResponse, error ->
            if(error != null){

            }else if(apiResponse != null){
                apiResponse.results?.let {
                    val uiCharacterList = helpers.mapApiResponseToUi(apiResponse)
                    characterAdapter.updateCharacterList(uiCharacterList)
                }
            }
        }
    }
}