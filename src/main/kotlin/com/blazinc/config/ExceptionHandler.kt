package com.blazinc.config

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Produces
@Singleton
@Requires(classes = [Exception::class, ExceptionHandler::class])
class ExceptionHandler :

    ExceptionHandler<Exception?, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: Exception?): HttpResponse<*> {
        println(exception?.message)
        return HttpResponse.ok(0)
    }
}