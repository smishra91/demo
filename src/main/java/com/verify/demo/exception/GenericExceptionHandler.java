package com.verify.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.verify.demo.response.PasswordApiResponse;
import com.verify.demo.response.ProcessSummary;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PasswordException.class)
    protected ResponseEntity<Object> handleApiException(PasswordException pException, WebRequest request){
        
        Exception exception = pException.getException();
        String errorMessage = exception.getMessage();
        
        PasswordApiResponse pApiResponse = pException.getFaultResponse();

        ProcessSummary processSummary = pApiResponse.getProcessSummary();

        processSummary.setStatus("failed");
        processSummary.setSummaryMessage(errorMessage);
        
        pApiResponse.setProcessSummary(processSummary);
        
        return new ResponseEntity<Object>(pApiResponse,HttpStatus.ACCEPTED);

    }
}