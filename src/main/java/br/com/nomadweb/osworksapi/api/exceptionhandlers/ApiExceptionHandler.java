package br.com.nomadweb.osworksapi.api.exceptionhandlers;

import br.com.nomadweb.osworksapi.domain.exceptions.BusinessException;
import br.com.nomadweb.osworksapi.domain.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest req) {
        var status = HttpStatus.BAD_REQUEST;
        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDateTime(OffsetDateTime.now());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, req);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest req) {
        var status = HttpStatus.NOT_FOUND;
        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitle(ex.getMessage());
        problem.setDateTime(OffsetDateTime.now());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, req);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var fields = new ArrayList<Problem.Field>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            fields.add(new Problem.Field(((FieldError) error).getField(), error.getDefaultMessage()));
        }

        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitle("One or more attributes are invalid.");
        problem.setDateTime(OffsetDateTime.now());
        problem.setFields(fields);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}
