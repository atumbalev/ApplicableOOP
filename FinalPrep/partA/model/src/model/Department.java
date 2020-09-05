package model;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Department {
    private Manager manager;
    private String deptName;
    private List<Staff> staff;

    public BiConsumer<Staff, Double> appointmentHandler = (worker, workerSalary) ->{
        worker.setWorkAt(deptName);
        worker.setHiredAt(LocalDate.now());
        worker.setSalary(workerSalary);
        staff.add(worker);
    };

    public Department(Manager manager, String deptName) {
        setManager(manager);
        setDeptName(deptName);
        staff = new ArrayList<>();
    }

    public void setManager(Manager manager) {
        if (manager == null) {
            throw new InvalidParameterException("Invalid parameter");
        }
        this.manager = manager;
    }

    public void setDeptName(String deptName) {
        if (deptName == null) {
            throw new InvalidParameterException("Invalid parameter");
        }
        this.deptName = deptName;
    }

    public final List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Manager: %s, Dept NAme: %s, Staff:", manager, deptName));
        for (Staff s : staff) {
            res.append(s.toString()).append('\n');
        }
        return res.toString();
    }


}
