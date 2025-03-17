package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    User user;

    @BeforeEach
    void Before() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1));

        this.user = new User("1", "Oscar", "Fernandez", fractions1);
    }

    @Test
    void testUser() {
        this.user = new User();
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testUserStringStringStringList() {
        assertEquals(3, user.getFractions().size());
        assertEquals("1", user.getId());
        assertEquals("Oscar", user.getName());
        assertEquals("Fernandez", user.getFamilyName());
    }

    @Test
    void testAddFraction() {
        this.user = new User();
        this.user.addFraction(new Fraction());
        assertEquals(1, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("Oscar Fernandez", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("O.", user.initials());
    }
}

