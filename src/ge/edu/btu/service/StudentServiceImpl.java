package ge.edu.btu.service;

import ge.edu.btu.model.SchoolException;
import ge.edu.btu.model.Student;

import java.io.*;

public class StudentServiceImpl implements StudentService {

    @Override
    public void saveStudent(Student student) {
        String path = "db/" + student.getId() + ".txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(student);
        } catch (IOException ex) {
            System.out.println("დაფიქსირდა გაუთვალისწინებელი შემთხვევა, " + ex.getMessage());
        }
    }

    @Override
    public Student readStudentById(String id) throws SchoolException {
        String path = "db/" + id + ".txt";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (Student) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new SchoolException("Can't read student by id " + id);
        }
    }
}
