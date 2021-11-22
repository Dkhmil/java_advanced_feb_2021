package service;

import exception.CannotDivideIntoNullException;

public class CalculationsImpl implements Calculations {

    @Override
    public double suma(double a, double b) {
        return a + b;
    }

    @Override
    public double minus(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws CannotDivideIntoNullException {
        if (b == 0) throw new CannotDivideIntoNullException("Cannot divide into 0");
        else return a / b;
    }

    @Override
    public boolean isPositive(double number) {
        return number > 0;
    }
}
