package com.demo.webservice.demowebservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.webservice.demowebservice.User.UserNotFoundExpection;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionController extends ResponseEntityExceptionHandler {
	
	// handling system defined exception // Generic Exception
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// handling own defined exception like usernotfoundexception
	@ExceptionHandler(UserNotFoundExpection.class)
	public final ResponseEntity<Object> handleAllException2(UserNotFoundExpection ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
