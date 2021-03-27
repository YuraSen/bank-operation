package com.senin.bank_operation.service;

import com.senin.bank_operation.exception.IncorrectIdRuntimeException;

public class UtilityService {
    private static final String ID_EMPTY = "ID can not be empty";
    private static final String ID_POSITIVE = "ID must be positive";
    public static final String ID_CORRECT = "ID must be correct";

    public static void isIdPositive(Long id) {
        if (id == null && id < 0) {
            throw new IncorrectIdRuntimeException(ID_POSITIVE);
        }
    }

}