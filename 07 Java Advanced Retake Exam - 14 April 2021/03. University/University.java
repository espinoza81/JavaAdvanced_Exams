package university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.students = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (students.stream().anyMatch(s -> s.firstName.equals(student.firstName) && s.lastName.equals(student.lastName))) {
            return "Student is already in the university";
        } else if (this.students.size() < this.capacity) {
            this.students.add(student);
            return String.format("Added student %s %s", student.firstName, student.lastName);
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (this.students.remove(student)) {
            return String.format("Removed student %s %s", student.firstName, student.lastName);
        } else {
            return "Student not found";
        }
    }

    public String getStatistics() {
        return this.students.stream()
                .map(student -> "==Student: First Name = " + student.firstName + ", Last Name = " + student.lastName + ", Best Subject = " + student.bestSubject)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream().filter(s -> s.firstName.equals(firstName) && s.lastName.equals(lastName)).findFirst().orElse(null);
    }
}
