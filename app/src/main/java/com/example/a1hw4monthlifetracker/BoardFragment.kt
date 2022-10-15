package com.example.a1hw4monthlifetracker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a1hw4monthlifetracker.databinding.FragmentBoardBinding

class BoardFragment : Fragment(), ItemOnClickListener {

    private lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).hideToolBar()

        val preferences = requireContext().getSharedPreferences("setting", Context.MODE_PRIVATE)
        val isShow : Boolean = preferences.getBoolean("isShow", false)
        if (isShow){
            findNavController().navigate(R.id.startRegistrationFragment)
        }

        val list= ArrayList<BoardModel>()
        list.add(BoardModel("time_anim.json", "Экономь время", "Дальше"))
        list.add(BoardModel("first_anim.json", "Достигай целей", "Дальше"))
        list.add(BoardModel("start.json", "Развивайся", "Начинаем"))
        val boardAdapter = BoardAdapter(list, this)
        binding.viewPager.adapter = boardAdapter
        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    override fun itemClick() {
        val preferences = requireContext().getSharedPreferences("setting", Context.MODE_PRIVATE)
        preferences.edit().putBoolean("isShow", true).apply()
        findNavController().navigate(R.id.startRegistrationFragment)
    }

    override fun btnClick1page() {
        binding.viewPager.setCurrentItem(1)
    }

    override fun btnClick2page() {
        binding.viewPager.setCurrentItem(2)
    }
}