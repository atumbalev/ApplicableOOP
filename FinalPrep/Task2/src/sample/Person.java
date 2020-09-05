package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Person {
    private String _lastName;
    private String _firstName;
    private LocalDate _hireDate;
    private StringProperty lastName;
    private StringProperty firstName;
    private ObjectProperty<LocalDate> hireDate;

    public Person(String firstName, String lastName, LocalDate hireDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setHireDate(hireDate);
    }

    public final String getLastName() {
        return lastName == null ? _lastName : lastName.get();
    }

    public final void setLastName(String lastName) {
        lastName = lastName == null ? "N/A" : lastName;
        if (this.lastName == null) {
            _lastName = lastName;
        } else {
            this.lastName.set(lastName);
        }
    }

    public final StringProperty lastNameProperty() {
        if (lastName == null) {
            lastName = new SimpleStringProperty(this, "lastName", _lastName);
        }
        return lastName;
    }

    public final String getFirstName() {
        return firstName == null ? _firstName : firstName.get();
    }

    public final void setFirstName(String firstName) {
        firstName = firstName == null ? "N/A" : firstName;
        if (this.firstName == null) {
            _firstName = firstName;
        } else {
            this.firstName.set(firstName);
        }
    }

    public final StringProperty firstNameProperty() {
        if (firstName == null) {
            firstName = new SimpleStringProperty(this, "firstName", _firstName);
        }
        return firstName;
    }

    public final LocalDate getHireDate() {
        if (hireDate == null) {
            return _hireDate;
        }
        return hireDate.get();
    }

    public final void setHireDate(LocalDate hireDate) {
        hireDate = hireDate == null ? LocalDate.now() : hireDate;
        if (this.hireDate == null) {
            _hireDate = hireDate;
        } else {
            this.hireDate.setValue(hireDate);
        }
    }

    public final ObjectProperty<LocalDate> hireDateProperty() {
        if (hireDate == null) {
            hireDate = new SimpleObjectProperty<>(LocalDate.now());
        }
        return hireDate;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getLastName(), getFirstName());
    }
}
