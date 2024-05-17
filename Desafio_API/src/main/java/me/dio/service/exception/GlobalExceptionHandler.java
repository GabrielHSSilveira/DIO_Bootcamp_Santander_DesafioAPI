package me.dio.service.exception;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Log do erro
        logger.error("Erro não tratado", ex);

        // Retornar uma resposta de erro com status 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado");
    }
}