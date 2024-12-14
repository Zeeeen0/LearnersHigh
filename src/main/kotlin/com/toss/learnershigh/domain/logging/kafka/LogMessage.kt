package com.toss.learnershigh.domain.logging.kafka

import java.time.LocalDateTime

data class LogMessage(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val level: String,
    val service: String,
    val thread: String,
    val logger: String,
    val message: String,
    val exception: String? = null
)
