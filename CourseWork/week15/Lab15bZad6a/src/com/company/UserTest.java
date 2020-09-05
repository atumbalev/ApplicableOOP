package com.company;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserTest {

    public static void main(String[] args) {
        StringProperty lname = new SimpleStringProperty("");
        User user = new User("Bond", "007");
        StringProperty lastname = user.lastnameProperty();
        lname.bindBidirectional(lastname);
        lastname.set("007");
        lname.set("New agent");
        System.out.printf("lastname: %s, lname: %s\n", user.getLastname(), lname.get());
    }
}
