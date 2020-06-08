package com.company;

import java.util.function.DoubleUnaryOperator;

public class IntegralProcessor {

    private DoubleUnaryOperator func;

    public IntegralProcessor(DoubleUnaryOperator f) {
        this.func = f;
    }

    public double calcLeftMethod(double a, double b, int n){
        double h = (b-a)/n;
        double result = func.applyAsDouble(a);
        System.out.println("    step: "+1+", delta: "+result);
        for (int i = 1; i <= n-1; i++) {
            double delta = func.applyAsDouble(a + i*h);
            result += delta;
            System.out.println("    At: "+(a + i*h)+", step: "+(i+1)+", delta: "+delta);
        }
        result*= h;
        return result;
    }

    public double calcRightMethod(double a, double b, int n){
        double result = func.applyAsDouble(b);
        double h = (b-a)/n;
        for (int i = 1; i <= n-1; i++) {
            result += func.applyAsDouble(a + i*h);
        }
        result *=h;
        return result;
    }

    public double calcTrapetzMethod(double a, double b, int n){
        double result = (func.applyAsDouble(a)+func.applyAsDouble(b))/2;
        double h = (b-a)/n;
        for (int i = 1; i <= n-1; i++) {
            result += func.applyAsDouble( a + i*h);
        }
        result *=h;
        return result;
    }

    public double calcSimpsonMethod(double a, double b, int n){
        double result = func.applyAsDouble(a)+func.applyAsDouble(b);
        double h = (b-a)/(2*n);
        double k =1;
        for (int i = 1; i <= 2*n-1; i++) {
            result += func.applyAsDouble(a + h*i) * (3+k);
            k = -k;}
        result *=h/3;
        return result;
    }

    public double calcLeftPhyramid(double a, double b, double e){
        int n = 2;
        double result = calcLeftMethod(a,b,n);
        double m;
        System.out.println("Steps: "+n+", result: "+result);
        do {
            n *= 2;
            double result1 = calcLeftMethod(a,b,n);
            m = Math.abs(result1 - result);
            result = result1;
            System.out.println("Steps: "+n+", result: "+result);
        }
        while(m>e);
        return result;
    }

    public double calcRightPhyramid(double a, double b, double e){
        int n = 2;
        double result = calcRightMethod(a,b,n);
        double m;
        do {
            n *= 2;
            double result1 = calcRightMethod(a,b,n);
            m = Math.abs(result1 - result);
            result = result1;
        }
        while(m>e);
        return result;
    }

    public double calcTrapetzPhyramid(double a, double b, double e){
        int n = 2;
        double m;
        double result = calcTrapetzMethod(a, b, n);
        do {
            n *= 2;
            double result1  = calcTrapetzMethod(a, b, n);
            m = Math.abs(result1 - result );
            result = result1 ;
        } while (m>=3*e);
        return result;

    }

    public double calcSimpsonPhyramid(double a, double b, double e){
        double m;
        int n = 2;
        double result  = calcSimpsonMethod(a, b, n);
        do {
            n *= 2;
            double result1 =  calcSimpsonMethod(a, b, n);
            m = Math.abs(result1 - result);
            result =result1;
        } while (m>=15*e);
        return result;
    }
}
