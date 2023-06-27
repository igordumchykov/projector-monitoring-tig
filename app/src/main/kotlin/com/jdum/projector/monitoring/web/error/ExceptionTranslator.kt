package com.jdum.projector.monitoring.web.error

import com.jdum.projector.monitoring.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
@ResponseBody
class ExceptionTranslator {

    @ExceptionHandler(MenuNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleMenuNotFound(e: MenuNotFoundException) = ErrorResponse(e.message!!, HttpStatus.NOT_FOUND.value())

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValid(e: MethodArgumentNotValidException): ErrorResponse {
        val detail = e.bindingResult.fieldErrors.map {
            it.defaultMessage
        }.joinToString(separator = ",")
        return ErrorResponse("Invalid request body", HttpStatus.BAD_REQUEST.value(), detail)
    }
}
