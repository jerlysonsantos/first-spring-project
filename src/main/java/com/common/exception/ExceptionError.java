package com.common.exception;

public class ExceptionError {
  private int status;
  private String message;

  public ExceptionError(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

}
