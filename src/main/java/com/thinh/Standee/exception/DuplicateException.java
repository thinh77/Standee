package com.thinh.Standee.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateException extends DataIntegrityViolationException {
    public DuplicateException(String message) {
        super(message);
    }
}
