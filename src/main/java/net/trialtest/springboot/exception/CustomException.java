package net.trialtest.springboot.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
