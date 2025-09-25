package es.upm.miw.devops.code;

import java.util.stream.Stream;

public class Searches {

    private final UsersDatabase usersDatabase;

    public Searches(UsersDatabase usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    public Fraction findFractionDivisionByUserId(String id) {
        return this.usersDatabase.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::divide)
                .orElse(null);
    }


}
