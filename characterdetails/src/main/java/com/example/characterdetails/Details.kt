package com.example.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.characterdetails.databinding.FragmentDetailsBinding
import com.example.fullimage.FullImage
import com.squareup.picasso.Picasso

class Details : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(name: String?, imageUrl: String?): Details {
            val fragment = Details()
            val args = Bundle()
            args.putString("name", name)
            args.putString("imageUrl", imageUrl)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name")
        val imageUrl = arguments?.getString("imageUrl")

        binding.tvNameDetail.text = name

        Picasso.get()
            .load(imageUrl)
            .into(binding.ivImageDetail)

        binding.ivImageDetail.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val fullImage = FullImage()

            val bundle = Bundle()
            bundle.putString("imageUrl", imageUrl)
            fullImage.arguments = bundle

            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.flDetails, fullImage)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}


