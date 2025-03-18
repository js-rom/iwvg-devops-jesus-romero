package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .toList());
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .toList());
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres", "Romero"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .toList());
    }

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("O.", "A.", "O.", "A.", "J."), new Searches().findUserFamilyNameInitialByAnyProperFraction()
                .toList());
    }

    @Test
    void testFindUserIdByAnyProperFraction() {
        assertEquals(List.of("1", "2", "3", "5", "7"), new Searches().findUserIdByAnyProperFraction()
                .toList());
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        Fraction multiplication = new Searches().findFractionMultiplicationByUserFamilyName("Fernandez");
        assertInstanceOf(Fraction.class, multiplication);
        assertEquals(new Fraction(0, 1).getNumerator(), multiplication.getNumerator());
        assertEquals(new Fraction(0, 1).getDenominator(), multiplication.getDenominator());
    }

    @Test
    void testfindFirstFractionDivisionByUserId() {
        Fraction division = new Searches().findFirstFractionDivisionByUserId("1");
        assertInstanceOf(Fraction.class, division);
        assertEquals(new Fraction(0, 1).getNumerator(), division.getNumerator());
        assertEquals(new Fraction(0, 1).getDenominator(), division.getDenominator());
    }

    @Test
    void testFindFirstDecimalFractionByUserName() {
        assertEquals(0.0, new Searches().findFirstDecimalFractionByUserName("Oscar"));
        assertEquals(2.0, new Searches().findFirstDecimalFractionByUserName("Ana"));
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertEquals(List.of("7"), new Searches().findUserIdByAllProperFraction().toList());
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(2.0, 1.3333333333333333),
                new Searches().findDecimalImproperFractionByUserName("Ana").toList());
        assertEquals(List.of(2.0, -0.5), new Searches().findDecimalImproperFractionByUserName("Oscar").toList());
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertEquals(new Fraction(0, 1).getNumerator(),
                new Searches().findFirstProperFractionByUserId("1").getNumerator());
        assertEquals(new Fraction(0, 1).getDenominator(),
                new Searches().findFirstProperFractionByUserId("1").getDenominator());

        assertThrows(NoSuchElementException.class, () -> new Searches().findFirstProperFractionByUserId("4"));
    }

    @Test
    void testFindUserFamilyNameByImproperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López", "Blanco", "Torres"),
                new Searches().findUserFamilyNameByImproperFraction().toList());
    }

}
