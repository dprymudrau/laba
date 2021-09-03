package com.solvd.hospital.exception;

public class QuarantineException extends NotFoundException{
    public QuarantineException(int message) { super("\"" + message + "\" Your appointment was postponed due to quarantine at the department.");
    }
}
