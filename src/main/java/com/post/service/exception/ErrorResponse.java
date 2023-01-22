package com.post.service.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class ErrorResponse{
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-ddThh:mm:ss")
        private String timestamp;

        @JsonProperty(value = "code")
        private int code;

        @JsonProperty(value = "status")
        private String status;
        @JsonProperty(value = "message")
        private String message;
        @JsonProperty(value = "details")
        private String details;

        @JsonProperty(value = "error")
        private String error;

        @JsonProperty(value = "path")
        private String path;

        @JsonProperty(value = "exception")
        private Exception exception;

        public ErrorResponse() {
        }

        public ErrorResponse(HttpStatus httpStatus, String message, String details, Exception exception) {
            timestamp = getTimestamp();
            this.code = httpStatus.value();
            this.status = httpStatus.name();
            this.message = message;
            this.details = details;
            this.exception = exception;
        }

    public ErrorResponse(HttpStatus httpStatus, String message, String details) {
        timestamp = getTimestamp();
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        this.details = details;
    }

        public String getTimestamp() {
            return timestamp;
        }

        public int getCode() {
            return code;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
}
