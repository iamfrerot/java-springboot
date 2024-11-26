package dev.frerot.SimpleApplication.Exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String message){
        super(message);

    }
}
