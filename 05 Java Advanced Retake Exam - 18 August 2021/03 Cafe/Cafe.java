package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee employeeToRemove = this.employees.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (employeeToRemove != null) {
            this.employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public String report() {
        return "Employees working at Cafe " + this.name + ":" + System.lineSeparator() +
                this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public int getCount() {
        return this.employees.size();
    }
}
