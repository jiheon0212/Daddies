package com.example.daddies.view.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daddies.databinding.FragmentNoticeBoardBinding

class NoticeBoardFragment : Fragment() {
    private lateinit var binding: FragmentNoticeBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoticeBoardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}