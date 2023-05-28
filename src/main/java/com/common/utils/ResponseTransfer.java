package com.common.utils;

public class ResponseTransfer {
  private String message;

  public ResponseTransfer() {

  }

  public ResponseTransfer(String message) {
    this.message = message;
  }

  /**
   * @return String return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
