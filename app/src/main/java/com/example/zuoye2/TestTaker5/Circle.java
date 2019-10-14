package com.example.zuoye2.TestTaker5;

public class Circle extends Shape {
    private double n;

    public Circle(double n) {
        this.n = n;
    }

    @Override
    public double calArea() {
        return n*n*Math.PI;
    }
}
