package org.example;

public class Fraction {
    Complex m;
    Complex n;

    public Fraction(Complex m, Complex n) {
        this.m = m;
        this.n = n;
    }

    public Fraction add(Fraction other) {
        Complex newM = this.m.multiply(other.n).add(other.m.multiply(this.n));
        Complex newN = this.n.multiply(other.n);
        return new Fraction(newM, newN);
    }

    @Override
    public String toString() {
        return "(" + m + ") / (" + n + ")";
    }
}