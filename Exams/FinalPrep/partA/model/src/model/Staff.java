package model;

import java.time.LocalDate;

public class Staff extends Employee {
    private String workAt;
    private LocalDate hiredAt;

    public Staff(String name, double salary, String workAt, LocalDate hiredAt) {
        super(name, salary);
        setWorkAt(workAt);
        setHiredAt(hiredAt);
    }

    public Staff() {
        this("No name", 1000, "Candidate", LocalDate.now());
    }

    public final String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt;
    }

    public final LocalDate getHiredAt() {
        return hiredAt;
    }

    public  void setHiredAt(LocalDate hiredAt) {
        this.hiredAt = hiredAt;
    }

    @Override
    public String toString() {
        return String.format("%s, Work at: %s, hired: %s", super.toString(), workAt, hiredAt.toString());
    }
}
