package com.example.daddies.view.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.daddies.R
import com.example.daddies.data.Post
import com.example.daddies.databinding.FragmentWritePostBinding
import com.example.daddies.viewmodel.PostViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class WritePostFragment : Fragment() {
    private lateinit var binding: FragmentWritePostBinding
    private val postViewModel: PostViewModel by viewModels()
    private val auth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWritePostBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.writePostBtn.setOnClickListener {
            val dummyPost = Post(
                "null", auth.uid, "null", "null", "null", emptyList(), emptyList(), getCurrentTime()
            )
            CoroutineScope(Dispatchers.Main).launch {
                postViewModel.uploadPost(dummyPost)
                findNavController().popBackStack()
            }
        }
    }

    private fun getCurrentTime(): String {
        val currentDate = Date()
        val currentZone = TimeZone.getTimeZone("Asia/Seoul")
        val timeFormat = SimpleDateFormat("a hh:mm", Locale.KOREA)
        timeFormat.timeZone = currentZone
        val timeValue = timeFormat.format(currentDate)

        return timeValue
    }
}