package me.dio.exception;

import me.dio.service.exception.BusinessException;
import me.dio.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    /**
     * Manipula exceções do tipo BusinessException.
     * Retorna uma resposta com status 400 (BAD_REQUEST) e a mensagem da exceção.
     *
     * @param ex A exceção BusinessException
     * @return ResponseEntity com status 400 e a mensagem de erro
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    /**
     * Manipula exceções do tipo NotFoundException.
     * Retorna uma resposta com status 404 (NOT_FOUND) e a mensagem da exceção.
     *
     * @param ex A exceção NotFoundException
     * @return ResponseEntity com status 404 e a mensagem de erro
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
