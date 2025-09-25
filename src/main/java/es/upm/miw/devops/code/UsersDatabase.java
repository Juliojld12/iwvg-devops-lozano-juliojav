package es.upm.miw.devops.code;

import java.util.List;
import java.util.stream.Stream;

public class UsersDatabase {

    public Stream<User> findAll() {
        return List.of(
                new User("1", "Oscar", "Fernandez", List.of(
                        new Fraction(3, 4),
                        new Fraction(2, 5)
                )),
                new User("2", "Ana", "Perez", List.of(
                        new Fraction(1, 3),
                        new Fraction(1, 2)
                )),
                new User("3", "Luis", "Gonzalez", List.of(
                        new Fraction(5, 2),
                        new Fraction(3, 1)
                )),
                new User("4", "Elena", "Lopez", List.of(
                        new Fraction(2, 3),
                        new Fraction(2, 5)
                ))
        ).stream();
    }
}
