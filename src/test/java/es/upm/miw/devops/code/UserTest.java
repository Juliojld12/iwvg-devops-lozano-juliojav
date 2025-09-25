package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testConstructorAndGetters() {
        User user = new User("1", "Julio", "Lozano");

        assertEquals("1", user.getId());
        assertEquals("Julio", user.getName());
        assertEquals("Lozano", user.getFamilyName());

        assertNotNull(user.getFractions());
        assertTrue(user.getFractions().isEmpty());
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setId("2");
        user.setName("Javier");
        user.setFamilyName("Lopez");

        assertEquals("2", user.getId());
        assertEquals("Javier", user.getName());
        assertEquals("Lopez", user.getFamilyName());
    }

    @Test
    void testToString() {
        User user = new User("3", "Carlos", "Perez");
        String result = user.toString();

        assertTrue(result.contains("id='3'"));
        assertTrue(result.contains("name='Carlos'"));
        assertTrue(result.contains("familyName='Perez'"));
    }

    @Test
    void testConstructorWithFractions() {
        List<Fraction> fractions = List.of(
                new Fraction(1, 2),
                new Fraction(3, 4)
        );

        User user = new User("4", "Lucia", "Martinez", fractions);

        assertEquals("4", user.getId());
        assertEquals("Lucia", user.getName());
        assertEquals("Martinez", user.getFamilyName());

        assertEquals(2, user.getFractions().size());
        assertEquals("1/2", user.getFractions().get(0).toString());
        assertEquals("3/4", user.getFractions().get(1).toString());
    }

    @Test
    void testSetFractions() {
        User user = new User("5", "David", "Sanchez");
        List<Fraction> newFractions = List.of(
                new Fraction(5, 6),
                new Fraction(7, 8)
        );

        user.setFractions(newFractions);

        assertEquals(2, user.getFractions().size());
        assertEquals("5/6", user.getFractions().get(0).toString());
    }
}
