package com.blazinc.service

import com.blazinc.model.domain.Update
import jakarta.inject.Singleton
import lombok.extern.java.Log
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.validation.ValidationException

@Log
@Singleton
class TelegramHandler(val messageService: MessageService) {

    fun getLogger(): Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)

    fun messageReceiver(params: Update) {
        val message: String = params.message.text.drop(1)
        getLogger().info("message received $message")
        routeMessage(message, params)
    }

    private fun routeMessage(message: String, params: Update) {
        when (message) {
            "start" -> start(params)
            "help" -> help(params)
            else -> {
                throw ValidationException("the message is not a valid command")
            }
        }
    }


    fun start(params: Update) {
        val chatID = params.message.chat.id
        messageService.sendNotificationToTelegram("HelloWorld", chatID)
    }

    fun help(params: Update) {
        val chatID = params.message.chat.id
        messageService.sendNotificationToTelegram("use /start to say hello world!", chatID)
    }


}