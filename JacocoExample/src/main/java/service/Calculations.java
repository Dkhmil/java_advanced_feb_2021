package service;

import exception.CannotDivideIntoNullException;

public interface Calculations {

    double suma(double a, double b);

    double minus(double a, double b);

    double multiply(double a, double b);

    double divide(double a, double b) throws CannotDivideIntoNullException;

    boolean isPositive(double number);
}
