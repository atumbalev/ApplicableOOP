package model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;

public class Course {
    private Faculty faculty;
    private String title;
    private Lecturer lecturer;
    private IntegerProperty numOfLecturers;
    private IntegerProperty numOfLabs;
    public IntegerBinding horarium;

    public Course(Faculty faculty, String title, Lecturer lecturer, int numOfLecturers, int numOfLabs) {
        this.faculty = faculty;
        this.title = title;
        this.lecturer = lecturer;
        setNumOfLecturers(numOfLecturers);
        setNumOfLabs(numOfLabs);
        horarium.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                lecturer.setWorkingHours(lecturer.getWorkingHours() + numOfLabs + numOfLecturers);
            }
        });
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getTitle() {
        return title;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public int getNumOfLecturers() {
        return numOfLecturers.get();
    }

    public IntegerProperty numOfLecturersProperty() {
        return numOfLecturers;
    }

    public int getNumOfLabs() {
        return numOfLabs.get();
    }

    public IntegerProperty numOfLabsProperty() {
        return numOfLabs;
    }

    public Number getHorarium() {
        return horarium.get();
    }

    public IntegerBinding horariumProperty() {
        return horarium;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setNumOfLecturers(int numOfLecturers) {
        this.numOfLecturers.set(numOfLecturers);
    }

    public void setNumOfLabs(int numOfLabs) {
        this.numOfLabs.set(numOfLabs);
    }
}
