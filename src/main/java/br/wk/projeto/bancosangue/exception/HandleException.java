package br.wk.projeto.bancosangue.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException extends RuntimeException {

    @ExceptionHandler({BaseServiceException.class})
    public ResponseEntity<Object> handleGlobalException(BaseServiceException exception) {

        CustomError error = new CustomError();
        error.setErrorCode(exception.getHttpStatus().value());
        error.setMsg(exception.getLocalizedMessage());
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(error);
    }
}

@Getter
@Setter
class CustomError {
    private int errorCode;
    private String msg;
}