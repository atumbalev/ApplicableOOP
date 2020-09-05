package sample;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private final ReadOnlyIntegerWrapper id;
    private static AtomicInteger idSequence = new AtomicInteger(0);
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phone;
    private DoubleProperty salary;
    private ObjectProperty<LocalDate> birthday;
    private String _firstName;
    private String _lastName;
    private String _email;
    private String _phone;
    private double _salary;
    private LocalDate _birthday;

    public Employee(String firstName, String lastName, String email, String phone, double salary, LocalDate birthday) {
        this.id = new ReadOnlyIntegerWrapper(idSequence.incrementAndGet());
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        setSalary(salary);
        setBirthday(birthday);
    }

    public int getId() {
        return id.get();
    }

    public ReadOnlyIntegerProperty idProperty() {
        return id.getReadOnlyProperty();
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

    public String getEmail() {
        return email == null ? _email : email.get();
    }

    public StringProperty emailProperty() {
        if (email == null) {
            email = new SimpleStringProperty(this, "email", _email);
        }
        return email;
    }

    public void setEmail(String email) {
        email = email != null && !email.isEmpty() ? email : "unknown@mail.com";
        if (this.email == null) {
            _email = email;
        } else {
            this.email.set(email);
        }
    }

    public String getPhone() {
        return phone == null ? _phone : phone.get();
    }

    public StringProperty phoneProperty() {
        if (phone == null) {
            phone = new SimpleStringProperty(this, "phone", _phone);
        }
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone != null && !phone.isEmpty() ? phone : "unknown";
        if (this.phone == null) {
            _phone = phone;
        } else {
            this.phone.set(phone);
        }
    }

    public double getSalary() {
        return salary == null ? _salary : salary.get();
    }

    public DoubleProperty salaryProperty() {
        if (salary == null) {
            salary = new SimpleDoubleProperty(this, "salary", _salary);
        }
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary >= 0 ? salary : 0;
        if (this.salary == null) {
            _salary = salary;
        } else {
            this.salary.set(salary);
        }
    }

    public LocalDate getBirthday() {
        return birthday == null ? _birthday : birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        if (birthday == null) {
            birthday = new SimpleObjectProperty<>(this, "birthday", _birthday);
        }
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        birthday = birthday != null ? birthday : LocalDate.now();
        if (this.birthday == null) {
            _birthday = birthday;
        } else {
            this.birthday.set(birthday);
        }
    }
}
