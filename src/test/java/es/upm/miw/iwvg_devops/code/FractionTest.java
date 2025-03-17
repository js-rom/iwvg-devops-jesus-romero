package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
