package com.pdev.rest.webservices.restfulwebservices.exception;

import com.pdev.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<UserException> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        UserException userException = new UserException(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<UserException>(userException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<UserException> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        UserException userException = new UserException(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<UserException>(userException, HttpStatus.NOT_FOUND);

    }
}
