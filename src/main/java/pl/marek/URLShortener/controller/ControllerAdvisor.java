package pl.marek.URLShortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.marek.URLShortener.link.LinkAlreadyExistsException;
import pl.marek.URLShortener.link.LinkNotFoundException;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(LinkAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleLinkAlreadyExistsException(LinkAlreadyExistsException linkAlreadyExistsException) {
        return new ExceptionResponse(linkAlreadyExistsException.getMessage());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handleLinkNotFoundException(LinkNotFoundException linkNotFoundException) {
        return new ExceptionResponse(linkNotFoundException.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleError(Exception ex) {
        return new ExceptionResponse(ex.getMessage());
    }
}
