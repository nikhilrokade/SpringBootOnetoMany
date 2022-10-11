package net.trialtest.springboot.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CompEmpException extends Exception{


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> handleInvalidArgument(@NotNull NoSuchElementException exception){
        Map<String,String> errorHandle = new HashMap<>();
        exception.getCause();
        return errorHandle;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(@NotNull MethodArgumentNotValidException exception) {
        Map<String, String> errorHandle = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            errorHandle.put(error.getObjectName(), error.getDefaultMessage());
        });
        return errorHandle;
    }


}



