package com.curiousbinary.springbootdemo.error;

import com.curiousbinary.springbootdemo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException departmentNotFoundException, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, departmentNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }

    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> departmentAlreadyExistException(DepartmentAlreadyExistException departmentAlreadyExistException, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE, departmentAlreadyExistException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(errorMessage);
    }
}
