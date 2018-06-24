package com.example.mockbus.controllers;

import com.example.mockbus.exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.IllegalFormatException;

@ControllerAdvice
public class ExceptionHandlerController {
    Logger logger = LogManager.getLogger();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalFormatException.class)
    public ModelAndView handelIllegalFormatEx(Exception e) {
        logger.error("Illegal Format Exception");
        logger.error(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("400");
        modelAndView.addObject("exception", e);
        return modelAndView;

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundEx(Exception e) {
        logger.error("Not Found Exception");
        logger.error(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("404");
        modelAndView.addObject("exception", e);
        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound() {
        return "404";
    }
}
