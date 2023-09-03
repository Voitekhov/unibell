package voy.task.unibell.model.dto;

import java.time.LocalDateTime;

public class ErrorDto {
    private final String cause;
    private final String exceptionType;

    private final String stack;

    private final LocalDateTime dateTime;

    public ErrorDto(String cause, String exceptionType, String stack, LocalDateTime dateTime) {
        this.cause = cause;
        this.exceptionType = exceptionType;
        this.stack = stack;
        this.dateTime = dateTime;
    }

    public String getCause() {
        return cause;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public String getStack() {
        return stack;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
