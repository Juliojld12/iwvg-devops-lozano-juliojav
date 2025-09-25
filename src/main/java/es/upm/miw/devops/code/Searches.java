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

    public Stream<String> findUserIdByAllProperFraction() {
        return this.usersDatabase.findAll()
                .filter(user -> !user.getFractions().isEmpty())
                .filter(user -> user.getFractions().stream().allMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Stream<String> findUserFamilyNameBySomeImproperFraction() {
        return this.usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isImproper))
                .map(User::getFamilyName);
    }




}
