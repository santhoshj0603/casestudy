package com.optum.casestudy.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.optum.casestudy.exception.ErrorResponse;
import com.optum.casestudy.service.OptumUserService;

@ControllerAdvice(assignableTypes = { OptumCaseStudyController.class })
public class OptumCaseStudyControllerAdvice extends ResponseEntityExceptionHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(OptumUserService.class);
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return getMissingParamsErrorResponse(ex.getMessage(), headers, status, request);
	}
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return getMissingParamsErrorResponse(ex.getMessage(), headers, status, request);
	}
	
	private ResponseEntity<Object> getMissingParamsErrorResponse(String msg, HttpHeaders headers, HttpStatus status, WebRequest request){
		ErrorResponse errorResponse = new ErrorResponse("InvalidRequest", msg);
		return new ResponseEntity<>(errorResponse, status);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(HttpServletRequest request, Exception e) {
		LOG.error("Unexpected Exception Occoured :: " + request.getHeader("uuid"), e);
		ErrorResponse errorResponse = new ErrorResponse("GenericError", e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
