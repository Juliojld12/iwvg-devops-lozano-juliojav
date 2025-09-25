package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UsersDatabaseTest {

    @Test
    void testFindAll() {
        UsersDatabase usersDatabase = new UsersDatabase();

        List<User> users = usersDatabase.findAll().collect(Collectors.toList());

        assertEquals(4, users.size());
        assertEquals("Oscar", users.get(0).getName());
        assertEquals("Perez", users.get(1).getFamilyName());
        assertEquals("Luis", users.get(2).getName());
        assertEquals("Lopez", users.get(3).getFamilyName());
    }
}
