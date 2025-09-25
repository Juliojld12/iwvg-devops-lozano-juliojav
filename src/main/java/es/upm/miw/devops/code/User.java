package es.upm.miw.devops.code;

import java.util.List;

public class User {

    private String id;
    private String name;
    private String familyName;
    private List<Fraction> fractions;

    public User() {
        this.fractions = List.of();
    }

    public User(String id, String name, String familyName) {
        this(id, name, familyName, List.of());
    }

    public User(String id, String name, String familyName, List<Fraction> fractions) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.fractions = fractions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public List<Fraction> getFractions() {
        return fractions;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setFractions(List<Fraction> fractions) {
        this.fractions = fractions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", fractions=" + fractions +
                '}';
    }
}
