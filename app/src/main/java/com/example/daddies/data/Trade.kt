package com.example.daddies.data

data class Trade(
    val writer: String? = null,
    val title: String? = null,
    val content: String? = null,
    val price: Int? = null,
    val image: String? = null,
    val timestamp: String? = null,
    // 댓글, 위치 데이터 추가할 방식
)
