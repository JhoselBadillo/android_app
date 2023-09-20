package com.example.fullimage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fullimage.databinding.FragmentFullImageBinding
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 * Use the [FullImage.newInstance] factory method to
 * create an instance of this fragment.
 */
class FullImage : Fragment() {

    private var binding: FragmentFullImageBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFullImageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = arguments?.getString("imageUrl")

        Picasso.get().load(imageUrl).into(binding?.ivFullImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}