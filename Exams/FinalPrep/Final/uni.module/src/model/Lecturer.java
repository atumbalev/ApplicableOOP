package model;

import javafx.beans.property.IntegerProperty;

public class Lecturer {
    private IntegerProperty workingHours;
    private String name;

    public Lecturer(int workingHours, String name) {
        this.workingHours.setValue(workingHours);
        this.name = name;
    }

    public Lecturer() {
        this(0, "");
    }

    public int getWorkingHours() {
        return workingHours.get();
    }

    public String getName() {
        return name;
    }

    public IntegerProperty workingHoursProperty() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours.set(workingHours);
    }

    public void setName(String name) {
        this.name = name;
    }
}
