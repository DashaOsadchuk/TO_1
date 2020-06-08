package com.company;

public class Function {

    public double calc(double x) {
        return (x*x)*Math.tan((x/2)*Math.PI/180);
    }

    public double calc_(double x) {
        return (Math.sin((0.2*x-3)*Math.PI/180)/(x*x+1));
    }
}
