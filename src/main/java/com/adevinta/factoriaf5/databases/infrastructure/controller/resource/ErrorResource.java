package com.adevinta.factoriaf5.databases.infrastructure.controller.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.StringJoiner;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResource {

  private String timestamp = LocalDateTime.now().toString();
  private Integer status;
  private String error;
  private String message;
  private String origin;

  public ErrorResource(Exception exception, HttpStatus httpStatus) {
    this(httpStatus.value(), httpStatus.getReasonPhrase(), exception.getMessage(), exception.getClass().getName());
  }

  public ErrorResource(Integer status, String error, String message, String origin) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.origin = origin;
  }

  public ErrorResource() {
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ErrorResource.class.getSimpleName() + "[", "]")
          .add("timestamp='" + timestamp + "'")
          .add("status=" + status)
          .add("error='" + error + "'")
          .add("message='" + message + "'")
          .add("origin='" + origin + "'")
          .toString();
  }
}
