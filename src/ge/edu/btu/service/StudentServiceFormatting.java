package ge.edu.btu.service;

import ge.edu.btu.model.SchoolException;
import ge.edu.btu.model.Student;

import java.io.*;

public class StudentServiceFormatting implements StudentService {

    @Override
    public void saveStudent(Student student) throws SchoolException {
        String path = "db2/" + student.getId() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(Student.format(student));
        } catch (IOException ex) {
            throw new SchoolException("Can't save student");
        }
    }

    @Override
    public Student readStudentById(String id) throws SchoolException {
        String path = "db2/" + id + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = reader.readLine()) != null) {
                sb.append(s).append(System.lineSeparator());
            }

            return Student.parse(sb.toString());
        } catch (IOException ex) {
            throw new SchoolException("Can't save student");
        }
    }
}
