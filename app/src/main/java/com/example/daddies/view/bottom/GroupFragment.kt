package com.example.daddies.view.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daddies.R
import com.example.daddies.databinding.FragmentGroupBinding
import com.example.daddies.databinding.FragmentUserBasicInfoBinding

class GroupFragment : Fragment() {
    private lateinit var binding: FragmentGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}