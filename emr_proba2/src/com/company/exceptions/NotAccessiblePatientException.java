package com.company.exceptions;

public class NotAccessiblePatientException extends Exception {
    public NotAccessiblePatientException()
    {
        super("This patient is not your patient");
    }
}
