package com.example.daddies.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daddies.R
import com.example.daddies.databinding.FragmentUserBasicInfoBinding

class UserBasicInfoFragment : Fragment() {
    private lateinit var binding: FragmentUserBasicInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBasicInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}