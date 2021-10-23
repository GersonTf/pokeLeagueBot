package com.blazinc.service

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton
import mu.KotlinLogging

@Singleton
class MessageService(@param:Client("https://api.telegram.org/bot496020190:AAHv_q7IUeqDMCVW0UuIIq3t4uh1tok8FK8") private val httpClient: HttpClient) {

    private val logger = KotlinLogging.logger {}

    /**
     * It sends a message to a specific telegram chatId
     * @param message to send and chatId
     */
    fun sendNotificationToTelegram(message: String, chatId: String) {
        httpClient.exchange(HttpRequest.GET<Any>( "/sendMessage?text=$message&chat_id=$chatId"))
    }
}