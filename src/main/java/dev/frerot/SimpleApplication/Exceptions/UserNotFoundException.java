package dev.frerot.SimpleApplication.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);

    }
}
