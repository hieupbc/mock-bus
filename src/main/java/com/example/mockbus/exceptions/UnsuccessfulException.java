package com.example.mockbus.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsuccessfulException extends  RuntimeException {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public UnsuccessfulException(String s) {
        super(s);
        logger.error(this.getMessage());

    }
}
