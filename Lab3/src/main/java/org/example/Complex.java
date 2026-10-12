package org.example;

public class Complex {
    double re;
    double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex add(Complex other) {
        return new Complex(this.re + other.re, this.im + other.im);
    }
    public Complex multiply(Complex other) {
        return new Complex(
                this.re * other.re - this.im * other.im,
                this.re * other.im + this.im * other.re
        );
    }

    @Override
    public String toString() {
        if (im >= 0) return re + "+" + im + "i";
        return re + "" + im + "i";
    }
}