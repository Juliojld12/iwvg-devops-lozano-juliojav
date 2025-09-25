package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction f = new Fraction();
        assertEquals(1, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testParameterizedConstructor() {
        Fraction f = new Fraction(3, 4);
        assertEquals(3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testSettersAndGetters() {
        Fraction f = new Fraction();
        f.setNumerator(5);
        f.setDenominator(6);
        assertEquals(5, f.getNumerator());
        assertEquals(6, f.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction f = new Fraction(1, 4);
        assertEquals(0.25, f.decimal(), 1e-10);
    }

    @Test
    void testIsProper() {
        assertTrue(new Fraction(1, 3).isProper());
        assertFalse(new Fraction(5, 3).isProper());
    }

    @Test
    void testIsImproper() {
        assertTrue(new Fraction(5, 3).isImproper());
        assertFalse(new Fraction(1, 3).isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(new Fraction(2, 4).isEquivalent(new Fraction(1, 2)));
        assertFalse(new Fraction(3, 4).isEquivalent(new Fraction(2, 5)));
    }

    @Test
    void testAdd() {
        Fraction result = new Fraction(1, 2).add(new Fraction(1, 3));
        assertEquals(new Fraction(5, 6), result);
    }

    @Test
    void testMultiply() {
        Fraction result = new Fraction(2, 3).multiply(new Fraction(3, 5));
        assertEquals(new Fraction(6, 15), result);
    }

    @Test
    void testDivide() {
        Fraction result = new Fraction(2, 3).divide(new Fraction(3, 5));
        assertEquals(new Fraction(10, 9), result);
    }

    @Test
    void testEquals() {
        assertEquals(new Fraction(2, 4), new Fraction(1, 2));
        assertNotEquals(new Fraction(3, 4), new Fraction(2, 3));
    }

    @Test
    void testToString() {
        assertEquals("3/5", new Fraction(3, 5).toString());
    }

    @Test
    void testIllegalDenominatorInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Fraction(1, 0));
    }

    @Test
    void testIllegalDenominatorInSetter() {
        Fraction f = new Fraction();
        assertThrows(IllegalArgumentException.class, () -> f.setDenominator(0));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> new Fraction(1, 2).divide(new Fraction(0, 3)));
    }

}
