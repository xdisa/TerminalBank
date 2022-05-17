package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {

    private String lastName;

    private String firstName;

    private String patronymic;

    private HashMap<Integer, Double> accs;

    private int pin;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Map<Integer, Double> getAccs() {
        return accs;
    }

    public void setAccs(HashMap<Integer, Double> accs) {
        this.accs = accs;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Person() {
    }

    public Person(String lastName, String firstName, String patronymic, HashMap<Integer, Double> accs, int pin) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.accs = accs;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "models.Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", accs=" + accs +
                ", pin=" + pin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return pin == person.pin && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(patronymic, person.patronymic) && Objects.equals(accs, person.accs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, accs, pin);
    }
}
