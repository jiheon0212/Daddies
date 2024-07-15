package com.example.daddies.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.daddies.R
import com.example.daddies.databinding.FragmentLoginActiveBinding
import com.example.daddies.viewmodel.FirebaseAuthViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginActiveFragment : Fragment() {
    private lateinit var binding: FragmentLoginActiveBinding
    private val firebaseAuthViewModel: FirebaseAuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginActiveBinding.inflate(layoutInflater, container, false)
        firebaseAuthViewModel.user.observe(viewLifecycleOwner) { user ->
            if (user != null) onBottomNavigate() else return@observe
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginActiveBtn.setOnClickListener {
            firebaseAuthViewModel.anonymousLogin()
        }
    }

    private fun onBottomNavigate() {
        activity?.findViewById<FragmentContainerView>(R.id.login_container)?.visibility = View.GONE

        activity?.findViewById<FragmentContainerView>(R.id.bottom_container)?.visibility = View.VISIBLE
        activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)?.visibility = View.VISIBLE

        val navController = (activity?.supportFragmentManager?.findFragmentById(R.id.bottom_container) as NavHostFragment).navController
        navController.navigate(R.id.postFragment)
    }
}