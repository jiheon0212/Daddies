package com.example.daddies.view.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daddies.adapter.PostAdapter
import com.example.daddies.data.Post
import com.example.daddies.databinding.FragmentPostBinding
import com.example.daddies.viewmodel.PostViewModel

class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostBinding
    private val postAdapter = PostAdapter(mutableListOf())
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostBinding.inflate(layoutInflater, container, false)
        binding.postRecycler.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(context)
        }

        postViewModel.updatePost()
        postViewModel.post.observe(viewLifecycleOwner) { list ->
            postAdapter.fetchPost(list)
            binding.postRecycler.scrollToPosition(list.size - 1)
        }

        binding.postSearchView.setOnQueryTextListener(object:
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                filterPost(newText)
                return true
            }
        })

        return binding.root
    }
    // 현재 post가 가지고있는 value에서 search query에 해당하는 값들을 필터링해주는 method
    private fun filterPost(query: String?) {
        val filteredPosts = postViewModel.post.value?.filter { post ->
            post.timestamp!!.contains(query ?: "", ignoreCase = true)
        }?.toMutableList()
        postAdapter.fetchPost(filteredPosts!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postBtn.setOnClickListener {
            val action = PostFragmentDirections.actionPostFragmentToWritePostFragment()
            findNavController().navigate(action)
        }
    }
}