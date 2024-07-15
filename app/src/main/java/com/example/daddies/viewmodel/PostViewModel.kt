package com.example.daddies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daddies.data.Post
import com.example.daddies.repository.FirebaseRepository
import com.google.firebase.Firebase
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.database

class PostViewModel: ViewModel() {
    private val firebaseRepository = FirebaseRepository()
    private val database = Firebase.database.reference

    private val _post = MutableLiveData<MutableList<Post>>()
    val post: LiveData<MutableList<Post>> get() = _post

    fun uploadPost(post: Post) {
        firebaseRepository.uploadPost(post)
    }
    fun updatePost() {
        database.child("post").addChildEventListener(object: ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val postList = mutableListOf<Post>()

                snapshot.children.forEach { dataSnapshot ->
                    val post = dataSnapshot.getValue(Post::class.java)
                    post?.let { postList.add(it) }
                }
                _post.postValue(postList)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}