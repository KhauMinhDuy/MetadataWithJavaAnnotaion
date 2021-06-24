package com.khauminhduy.calcengine;

@CommandKeyword("sub")
public class Subtracter implements MathProcessing {

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal - rightVal;
    }

}
