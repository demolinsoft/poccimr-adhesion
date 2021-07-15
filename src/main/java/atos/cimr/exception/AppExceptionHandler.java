package atos.cimr.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import atos.cimr.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

 public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
	 
	 String errorMessageDescription = ex.getLocalizedMessage();
	 if(errorMessageDescription==null) errorMessageDescription=ex.getLocalizedMessage();
	 ErrorMessage errorMessage = new ErrorMessage(new Date(),  errorMessageDescription);
	 return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
 }
}
