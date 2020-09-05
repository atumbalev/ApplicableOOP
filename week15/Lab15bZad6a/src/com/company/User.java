package com.company;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private String _lastname;
    private StringProperty lastname;
    private StringProperty password;

    public User(String lastname, String password) {
        setLastname(lastname);
        password = password != null ? password : "123";
        this.password = new SimpleStringProperty(this, "password", password);
    }

    public User() {
        this("James", "007");
    }

    public final String getLastname() {
        if (lastname == null) {
            return _lastname;
        } else {
            return lastname.get();
        }
    }

    public final StringProperty lastnameProperty() {
        if (lastname == null) {
            lastname = new SimpleStringProperty(this, "lastname", _lastname);
        }
        return lastname;
    }

    public final void setLastname(String lastname) {
        lastname = lastname != null ? lastname : "unknown";
        if (this.lastname == null) {
            _lastname = lastname;
        } else {
            this.lastname.set(lastname);
        }
    }

    public final String getPassword() {
        return password.get();
    }

    public final StringProperty passwordProperty() {
        return password;
    }

    public final void setPassword(String password) {
        password = password != null ? password : "123";
        this.password.set(password);
    }
}
