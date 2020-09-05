package model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Supplier;

public class Faculty implements ICanCreate{
    private String facultyName;
    private Lecturer[] lecturers;
    public Supplier<String> cidGenerator;
    private Random rnd;
    private static int cnt;

    @Override
    public Supplier<Course> create() {
        return () -> new Course(this,
                cidGenerator.get(), select(lecturers),
                rnd.nextInt(3) + 1,
                rnd.nextInt(3) + 1);
    }

    @Override
    public Lecturer select(Lecturer[] lecturers) {
        return Arrays.stream(lecturers).min(Comparator.comparing(Lecturer::getWorkingHours)).orElse(new Lecturer());
    }

    public Faculty(String facultyName, Lecturer[] lecturers) {
        this.facultyName = facultyName;
        this.lecturers = lecturers;
        this.cidGenerator = () -> String.format("%s-%03d", facultyName, cnt++);
        this.rnd = new Random();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }
}
