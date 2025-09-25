package es.upm.miw.devops.functionaltests;


import es.upm.miw.devops.code.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testConstructorAndGetters() {
        User user = new User("1", "Julio", "Lozano");

        assertEquals("1", user.getId());
        assertEquals("Julio", user.getName());
        assertEquals("Lozano", user.getFamilyName());
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
}
