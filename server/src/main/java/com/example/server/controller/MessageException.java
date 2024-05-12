package com.example.server.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duchieu212
 */
@Getter
@Setter
public class MessageException extends RuntimeException {

    private String message;

    private String pathFile;

    public MessageException(String message, String pathFile) {
        this.message = message;
        this.pathFile = pathFile;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
