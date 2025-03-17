package es.upm.miw.iwvg_devops.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    User user;

    @BeforeEach
    void Before() {

        this.user = new UsersDatabase().findAll()
                .filter(user -> "1".equals(user.getId()))
                .findFirst().orElse(null);

        this.user.setName("Oscar");
        this.user.setFamilyName("Fernandez");
    }

    @Test
    void testSetFractions() {
        this.user = new User();

        List<Fraction> fractions = new UsersDatabase().findAll()
                .filter(user -> "1".equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .toList();

        this.user.setFractions(fractions);
        assertEquals(fractions, this.user.getFractions());
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
