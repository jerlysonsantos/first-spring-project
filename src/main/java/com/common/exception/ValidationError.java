package com.common.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
  private int status;
  private String message;
  private List<FieldError> fieldErrors;

  public ValidationError(int status, String message) {
    this.status = status;
    this.message = message;
    this.fieldErrors = new ArrayList<>();
  }

  public void addFieldError(String fieldName, String errorMessage) {
    FieldError fieldError = new FieldError(fieldName, errorMessage);
    fieldErrors.add(fieldError);
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public List<FieldError> getFieldErrors() {
    return fieldErrors;
  }

  public static class FieldError {
    private String fieldName;
    private String errorMessage;

    public FieldError(String fieldName, String errorMessage) {
      this.fieldName = fieldName;
      this.errorMessage = errorMessage;
    }

    public String getFieldName() {
      return fieldName;
    }

    public String getErrorMessage() {
      return errorMessage;
    }
  }
}
