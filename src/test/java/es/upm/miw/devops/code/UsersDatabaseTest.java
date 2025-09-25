package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersDatabaseTest {

    @Test
    void testFindAllUsers() {
        UsersDatabase usersDatabase = new UsersDatabase();
        List<User> users = usersDatabase.findAll().toList();

        assertEquals(4, users.size());

        assertEquals("Oscar", users.get(0).getName());
        assertEquals("Perez", users.get(1).getFamilyName());
        assertEquals("Luis", users.get(2).getName());
        assertEquals("Lopez", users.get(3).getFamilyName());

        assertEquals(2, users.get(0).getFractions().size());
        assertEquals(2, users.get(1).getFractions().size());
        assertEquals(2, users.get(2).getFractions().size());
        assertEquals(2, users.get(3).getFractions().size());

        assertEquals("3/4", users.get(0).getFractions().get(0).toString());
        assertEquals("2/5", users.get(0).getFractions().get(1).toString());
    }
}
