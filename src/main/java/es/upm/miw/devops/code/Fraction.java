package es.upm.miw.devops.code;

import java.util.Objects;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
        this(1, 1);
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) this.numerator / this.denominator;
    }

    public boolean isProper() {
        return Math.abs(this.numerator) < Math.abs(this.denominator);
    }

    public boolean isImproper() {
        return !isProper();
    }

    public boolean isEquivalent(Fraction other) {
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    public Fraction add(Fraction other) {
        return new Fraction(
                this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator
        );
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(
                this.numerator * other.numerator,
                this.denominator * other.denominator
        );
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return new Fraction(
                this.numerator * other.denominator,
                this.denominator * other.numerator
        );
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.isEquivalent(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.decimal());
    }
}

