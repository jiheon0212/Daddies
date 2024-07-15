package com.example.daddies.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daddies.data.Post
import com.example.daddies.databinding.PostAdapterBinding

class PostAdapter(private var postList: MutableList<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class PostViewHolder(val binding: PostAdapterBinding): RecyclerView.ViewHolder(binding.root)
    @SuppressLint("NotifyDataSetChanged")
    fun fetchPost(newPost: MutableList<Post>) {
        postList = newPost
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val post = PostAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(post)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val postData = postList[position]
        val (_, writer, title, image, content, _, _, timestamp) = postData
        val starsCount = postData.starsCount
        val replyCount = postData.replyCount

        (holder as PostViewHolder).binding.apply {
            postTvWriter.text = writer
            postTvTimestamp.text = timestamp
            postTvTitle.text = title
            // post_img config with glide
            postTvContent.text = content
            postTvStars.text = starsCount.toString()
            postTvReply.text = replyCount.toString()
        }
    }
    override fun getItemCount(): Int = postList.size
}