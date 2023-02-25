package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new IOException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            IllegalArgumentException ex = new IllegalArgumentException("Resource is missing");
            ex.initCause(e);
            throw ex;
        } catch (IOException e) {
            IllegalArgumentException ex = new IllegalArgumentException("Resource error");
            ex.initCause(e);
            throw ex;
        } catch (ArithmeticException | NumberFormatException e) {
            if (e instanceof ArithmeticException) System.err.println("ar");
            if (e instanceof NumberFormatException) System.err.println("nfe");
        }
    }
}
