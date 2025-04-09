package com.gym.api.exception;

public class EnrollmentNotFoundException extends RuntimeException {

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment with id " + id + " is not found.");
    }


}
