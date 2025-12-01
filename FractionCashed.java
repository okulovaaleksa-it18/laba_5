package ru.okulova.lab5.math;

public class FractionCashed extends Fraction {

    private Double cachedValue = null;

    public FractionCashed(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public double getValue() {
        if (cachedValue == null) {
            cachedValue = super.getValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cachedValue = null; // сброс кэша
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cachedValue = null; // сброс кэша
    }
}
