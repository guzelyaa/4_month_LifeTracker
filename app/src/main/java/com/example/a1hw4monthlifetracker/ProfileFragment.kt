package com.example.a1hw4monthlifetracker

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.a1hw4monthlifetracker.databinding.FragmentProfileBinding
import java.io.ByteArrayOutputStream


class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).binding.titleTv.text = "Профиль"
        (requireActivity() as MainActivity).binding.profileImV.load(R.drawable.ic_task)
        (requireActivity() as MainActivity).binding.toolBar.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment2)
        }

//        val preferences = requireContext().getSharedPreferences("photo", Context.MODE_PRIVATE)
//        val isSave : String? = preferences.getString("isShow", imageUri.toString())
//        if (isSave != null){
//            binding.profilePhoto.setImageURI(imageUri)
//        }

        binding.profilePhoto.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            binding.profilePhoto.setImageURI(imageUri)

        }
    }







}