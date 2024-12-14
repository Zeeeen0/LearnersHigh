package com.toss.learnershigh.domain.logging.kafka

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/logs")
class LogController(private val logService: LogService) {

    @PostMapping
    fun sendLog(@RequestBody logMessage: LogMessage) {
        logService.sendLog(logMessage)
    }
}