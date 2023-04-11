package com.pdev.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class UserException {

    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public UserException(LocalDateTime timeStamp, String message, String details){
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

}
