package com.firstspringproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.common.exception.ExceptionError;
import com.common.exception.ValidationError;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public @ResponseBody ValidationError handleValidationException(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    List<FieldError> fieldErrors = result.getFieldErrors();

    ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation Error");

    for (FieldError fieldError : fieldErrors) {
      validationError.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
    }

    return validationError;
  }

  @ExceptionHandler(value = Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ExceptionError> handleException(Exception ex) {
    ExceptionError errorResponse = new ExceptionError(HttpStatus.BAD_REQUEST.value(), "An error occurred");

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

}
