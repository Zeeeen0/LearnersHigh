package com.toss.learnershigh.domain.logging.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class LogService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    fun sendLog(logMessage: LogMessage) {
        val message = objectMapper.writeValueAsString(logMessage)
        kafkaTemplate.send("logging-topic", message)
    }

    @KafkaListener(topics = ["logging-topic"])
    fun processLog(message: String) {
        val logMessage = objectMapper.readValue(message, LogMessage::class.java)
        println("Received message: $logMessage")
        // TODO: 로그 처리, 저장 로직 구현
    }
}
