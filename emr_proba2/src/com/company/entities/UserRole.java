package com.company.entities;

public enum UserRole {
    patient(1),
    doctor(2)
    ;
    private final int value;

    UserRole(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static UserRole fromValue(int value) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.getValue() == value) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid value for Speciality: " + value);
    }

}
