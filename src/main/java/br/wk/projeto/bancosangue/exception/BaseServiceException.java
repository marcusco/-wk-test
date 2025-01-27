package br.wk.projeto.bancosangue.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseServiceException extends HandleException {
    private final HttpStatus httpStatus;
    private final String message;
    private final Throwable throwable;

    public BaseServiceException(final HttpStatus httpStatus, final String message, final Throwable throwable) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.throwable = throwable;
    }

    public BaseServiceException(final HttpStatus httpStatus, final String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.throwable = null;
    }

    public BaseServiceException(final String message, final Throwable throwable) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
        this.throwable = throwable;
    }

    public BaseServiceException(final String message) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
        this.throwable = null;
    }

    public boolean isErrorRecoverable() {
        return this.httpStatus.is4xxClientError();
    }

}
