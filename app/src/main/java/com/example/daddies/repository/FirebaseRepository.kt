package com.example.daddies.repository

import com.example.daddies.data.Post
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseRepository {
    private val auth = Firebase.auth
    private val database = Firebase.database.reference
    private val storage = Firebase.storage
    private val store = Firebase.firestore

    // login related methods
    suspend fun anonymousLogin(): FirebaseUser? {
        val authResult = auth.signInAnonymously().await()
        return authResult.user
    }

    // post related methods
    fun uploadPost(post: Post) {
        database.child("post").child(getCurrentDay()).push().setValue(post)
    }
    private fun getCurrentDay(): String {
        val currentDate = Date()
        val currentZone = TimeZone.getTimeZone("Asia/Seoul")
        val dayFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA)

        dayFormat.timeZone = currentZone
        val dayValue = dayFormat.format(currentDate)

        return dayValue
    }
}