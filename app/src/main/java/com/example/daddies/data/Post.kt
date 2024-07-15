package com.example.daddies.data

data class Post(
    val postId: String? = null,
    val writer: String? = null,
    val title: String? = null,
    val image: String? = null,
    val content: String? = null,
    val stars: List<Stars> = emptyList(),
    val reply: List<Reply> = emptyList(),
    val timestamp: String? = null,
){
    val starsCount: Int get() = stars.size
    val replyCount: Int get() = reply.size
}

data class Stars(
    val name: String? = null,
    val triggered: Boolean? = null,
)
data class Reply(
    val replyId: String? = null,
    val name: String? = null,
    val value: String? = null,
)
