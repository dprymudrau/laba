package com.solvd.hospital.exception;

public class HolidayException extends NotFoundException{
    public HolidayException(int message) { super("\"" + message + "\" Your appointment was canceled due to doctor's leave.");
    }
}
