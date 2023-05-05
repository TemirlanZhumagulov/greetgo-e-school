package com.example.eschoolserver.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class ResponseBuilder {
    private LocalDateTime timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String reason;
    private String message;
    private String developerMessage;
    private Map<?, ?> data;

    public ResponseBuilder() {
    }

    public ResponseBuilder withTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public ResponseBuilder withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseBuilder withReason(String reason) {
        this.reason = reason;
        return this;
    }

    public ResponseBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseBuilder withDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public ResponseBuilder withData(Map<?, ?> data) {
        this.data = data;
        return this;
    }

    public Response build() {
        return new Response(timeStamp, statusCode, status, reason, message, developerMessage, data);
    }
}
