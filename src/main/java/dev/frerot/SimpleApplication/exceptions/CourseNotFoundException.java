package dev.frerot.SimpleApplication.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String message){
        super(message);

    }
}
