package com.information.exceptionhandling;

public class CustomClassException extends RuntimeException{

    private static final long serialVersionUID = 4664456874499611218L;

    public String errorCode = "Unknown_Exception";

    public CustomClassException(String message, String errorCode) {
        super(message);
        System.out.println(errorCode);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public static void main(String[] args) throws CustomClassException {
        CustomClassException customClassException = new CustomClassException("Custom Exception", "Error_Code-2000");
        throw customClassException;
    }
}
