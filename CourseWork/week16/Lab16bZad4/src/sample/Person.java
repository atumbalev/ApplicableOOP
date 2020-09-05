package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private ObjectProperty<LocalDate> hireDate;
    private String _firstName;
    private String _lastName;
    private LocalDate _hireDate;

    public Person(String firstName, String lastName, LocalDate hireDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setHireDate(hireDate);
    }

    public String getFirstName() {
        return firstName == null ? _firstName : firstName.get();
    }

    public StringProperty firstNameProperty() {
        if (firstName == null) {
            firstName = new SimpleStringProperty(this, "firstName", _firstName);
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName != null && !firstName.isEmpty() ? firstName : "unknown";
        if (this.firstName == null) {
            _firstName = firstName;
        } else {
            this.firstName.set(firstName);
        }
    }

    public String getLastName() {
        return lastName == null ? _lastName : lastName.get();
    }

    public StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty(this, "lastName", _lastName);
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName != null && !lastName.isEmpty() ? lastName : "unknown";
        if (this.lastName == null) {
            _lastName = lastName;
        } else {
            this.lastName.set(lastName);
        }
    }

    public LocalDate getHireDate() {
        return hireDate == null ? _hireDate : hireDate.get();
    }

    public ObjectProperty<LocalDate> hireDateProperty() {
        if (hireDate == null) {
            hireDate = new SimpleObjectProperty<>(this, "hireDate", _hireDate);
        }
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        hireDate = hireDate != null ? hireDate : LocalDate.now();
        if (this.hireDate == null) {
            _hireDate = hireDate;
        } else {
            this.hireDate.set(hireDate);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s, Hire date: %s", _firstName, _lastName, _hireDate);
    }
}
