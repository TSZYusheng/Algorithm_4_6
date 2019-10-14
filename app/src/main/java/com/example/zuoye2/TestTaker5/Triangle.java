package com.example.zuoye2.TestTaker5;

public class Triangle extends Shape {
    private double n;
    private double m;
    public Triangle(double n, double m) {
        this.n = n;
        this.m = m;
    }
    @Override
    public double calArea() {
        return n*m/2;
    }
}
