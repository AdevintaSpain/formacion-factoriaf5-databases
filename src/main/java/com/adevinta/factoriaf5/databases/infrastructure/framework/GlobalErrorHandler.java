package com.adevinta.factoriaf5.databases.infrastructure.framework;


import com.adevinta.factoriaf5.databases.domain.core.NotFoundException;
import com.adevinta.factoriaf5.databases.infrastructure.controller.resource.ErrorResource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalErrorHandler {

  private static final Logger LOG = Logger.getLogger(GlobalErrorHandler.class.getName());

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResource> handleException(Exception exception, HttpServletRequest httpServletRequest) {
    ErrorResource resource;
    if (ResponseStatusException.class.isAssignableFrom(exception.getClass())) {
      resource = new ErrorResource(exception, ((ResponseStatusException) exception).getStatus());
    } else if (NotFoundException.class.isAssignableFrom(exception.getClass())) {
      resource = new ErrorResource(exception, HttpStatus.NOT_FOUND);
    } else {
      resource = new ErrorResource(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    LOG.log(Level.SEVERE, "Captured error: " + resource, exception);
    return ResponseEntity.status(resource.getStatus()).contentType(MediaType.APPLICATION_JSON).body(resource);
  }
}
