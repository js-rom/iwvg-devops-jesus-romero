package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FractionTest {

    Fraction fraction;

    @BeforeEach
    void before() {
        this.fraction = new Fraction(2, 4);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testFraction() {
        this.fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, fraction.decimal());
    }

    @Test
    void testIsProper() {
        assertTrue(fraction.isProper());
    }

    @Test
    void testIsImproper() {
        assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        assertTrue(fraction.isEquivalent(new Fraction(4, 8)));
        assertFalse(fraction.isEquivalent(new Fraction(1, 3)));
    }

    @Test
    void testDivide() {
        fraction = fraction.divide(new Fraction(2, 4));
        assertEquals(8, fraction.getNumerator());
        assertEquals(8, fraction.getDenominator());
    }

    @Test
    void testMultiply() {
        fraction = fraction.multiplay(new Fraction(2, 4));
        assertEquals(4, fraction.getNumerator());
        assertEquals(16, fraction.getDenominator());
    }

}
