package es.upm.miw.devops.code;

import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {
        return List.of(
                new User("1", "Oscar", "Fernandez"),
                new User("2", "Ana", "Perez"),
                new User("3", "Luis", "Gonzalez"),
                new User("4", "Elena", "Lopez")
        ).stream();
    }
}
