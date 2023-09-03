package voy.task.unibell.http;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import voy.task.unibell.model.dto.ErrorDto;
import voy.task.unibell.model.exception.EntityNotFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

@ControllerAdvice
@Order()
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorDto> handelException(RuntimeException ex, WebRequest request) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String cause = ex.getMessage();
        ErrorDto errorDto = new ErrorDto(cause, ex.getClass().getSimpleName(), stackTrace, LocalDateTime.now());
        return new ResponseEntity<>(errorDto, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
