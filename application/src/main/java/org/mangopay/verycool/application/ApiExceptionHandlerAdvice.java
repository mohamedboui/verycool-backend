package org.mangopay.verycool.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mangopay.verycool.core.exception.BusinessException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;

@RestControllerAdvice
public class ApiExceptionHandlerAdvice {

    private static final Logger LOG = LogManager.getLogger(ApiExceptionHandlerAdvice.class.getName());

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<String> business(BusinessException exception, WebRequest request) {
        LOG.error(exception.getMessage(), exception);
        return ResponseEntity.unprocessableEntity().body(exception.getMessage());
    }
}
