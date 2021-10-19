package com.blazinc.service

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import jakarta.inject.Singleton

@Singleton
class MessageService(@param:Client("https://api.telegram.org/bot848542380:AAEjlY6qaxA0eEFUXoOFDHwAVMI4-91kW28") private val httpClient: HttpClient) {

    /**
     * It sends a message to a specific telegram chatId
     * @param message to send and chatId
     */
    fun sendNotificationToTelegram(message: String, chatId: String) {
        httpClient.exchange("/sendMessage?text=$message&chat_id=$chatId")
    }
}