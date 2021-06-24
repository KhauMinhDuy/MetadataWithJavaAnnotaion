package com.khauminhduy.calcengine;

public class PowerOf implements MathProcessing {

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal, rightVal);
    }

}
