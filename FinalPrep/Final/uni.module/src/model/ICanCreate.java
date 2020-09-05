package model;


import java.util.function.Supplier;

public interface ICanCreate {
    Supplier<Course> create();
    Lecturer select(Lecturer[] lecturers);
}
