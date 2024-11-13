package br.com.mateusfilpo.encurtadorurl.controller.exception;

import br.com.mateusfilpo.encurtadorurl.service.exception.UrlExpiredException;
import br.com.mateusfilpo.encurtadorurl.service.exception.UrlNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(UrlNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Url não encontrada", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UrlExpiredException.class)
    public ResponseEntity<StandardError> objectExpired(UrlExpiredException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.GONE;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Url expirada", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
