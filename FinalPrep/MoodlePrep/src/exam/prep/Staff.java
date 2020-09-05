package exam.prep;

public class Staff extends Employee {
    private String workAt;

    public Staff(String name, double salary, String workAt) {
        super(name, salary);
        this.workAt = workAt == null ? "Candidate" : workAt;
    }

    public Staff() {
        this(null, 0, null);
    }

    public String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt;
    }

    @Override
    public String toString() {
        return String.format("%s, Works at %s", super.toString(), workAt);
    }
}
