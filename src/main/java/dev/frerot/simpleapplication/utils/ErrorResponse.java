package dev.frerot.simpleapplication.utils;


public record ErrorResponse(int status,
                            String message,
                            Object error) {

}
