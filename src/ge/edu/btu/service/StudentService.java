package ge.edu.btu.service;

import ge.edu.btu.model.SchoolException;
import ge.edu.btu.model.Student;

public interface StudentService {

    void saveStudent(Student student) throws SchoolException;

    Student readStudentById(String id) throws SchoolException;
}
