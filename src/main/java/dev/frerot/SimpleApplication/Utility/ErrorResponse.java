package dev.frerot.SimpleApplication.Utility;


public record ErrorResponse(int status,
                            String message,
                            Object error) {

}
