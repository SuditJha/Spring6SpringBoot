package com.exception;

public class UnavailableCollegeException extends Exception {
    private static final long serialVersionUID = 1L;

    public UnavailableCollegeException(String msg) {
        super(msg);
    }
}
