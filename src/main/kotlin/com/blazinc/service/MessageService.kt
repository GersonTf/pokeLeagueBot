package com.blazinc.service

import com.blazinc.config.TelegramConfiguration
import io.micronaut.context.annotation.Value
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton

@Singleton
class MessageService(@param:Client(TelegramConfiguration.TELEGRAM_API_URL) private val httpClient: HttpClient) {

    @Value("\${telegram.token}")
    lateinit var botToken: String

    /**
     * It sends a message to a specific telegram chatId
     * @param message to send and chatId
     */
    fun sendNotificationToTelegram(message: String, chatId: String) {
        val uri = "/$botToken/sendMessage?text=$message&chat_id=$chatId"
        httpClient.toBlocking().retrieve(uri)
    }
}