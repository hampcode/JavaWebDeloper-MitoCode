package com.example.handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.exception.BadRequestException;
import com.example.exception.ResourceNotFoundException;


@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView ResourceNotFoundView(ResourceNotFoundException exception){
        ModelAndView modelAndView = new ModelAndView("errorView");
        modelAndView.addObject("title", "Resource Not Found");
        modelAndView.addObject("ex", exception);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ModelAndView BadRequestView(BadRequestException exception){
        ModelAndView modelAndView = new ModelAndView("errorView");
        modelAndView.addObject("title", "Bad Request");
        modelAndView.addObject("ex", exception);
        return modelAndView;
    }

    @ExceptionHandler({NumberFormatException.class, NoHandlerFoundException.class, IllegalArgumentException.class})
    public ModelAndView NumberFormatView(Exception exception){
        ModelAndView modelAndView = new ModelAndView("errorView");
        modelAndView.addObject("title", "Oops...");
        modelAndView.addObject("ex", exception);
        return modelAndView;
    }
}