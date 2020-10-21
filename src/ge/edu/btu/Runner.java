package ge.edu.btu;

import ge.edu.btu.model.SchoolException;
import ge.edu.btu.model.Student;
import ge.edu.btu.service.StudentService;
import ge.edu.btu.service.StudentServiceFormatting;

import java.util.Scanner;

public class Runner {

    private static Scanner scanner = new Scanner(System.in);

    private static StudentService studentService = new StudentServiceFormatting();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. მოსწავლის დამატება");
            System.out.println("2. მოსწავლისთვის ქულის დამატება");
            System.out.println("3. საშუალო ქულის დადგენა");
            System.out.println("0. დახურვა");

            String number = scanner.nextLine();
            if (number.equals("0")) {
                break;
            }
            switch (number) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    addMarkForStudent();
                    break;
                case "3":
                    printAverageMark();
                    break;
                default:
                    System.out.println("არასწორი ნომერი");
            }
        }
    }

    private static void printAverageMark() {
        try {
            System.out.println("მოსწავლის id:");
            String id = scanner.nextLine();
            Student student = studentService.readStudentById(id);
            System.out.println("მოსწავლის საშუალო ქულაა " + student.getAverageMark());
        } catch (SchoolException ex) {
            System.out.println("დაფიქსირდა გაუთვალისწინებელი შემთხვეა, " + ex.getMessage());
        }
    }

    private static void addMarkForStudent() {
        try {
            System.out.println("მოსწავლის id:");
            String id = scanner.nextLine();
            Student student = studentService.readStudentById(id);
            System.out.println("ქულა:");
            int mark = Integer.parseInt(scanner.nextLine());
            student.addMark(mark);
            studentService.saveStudent(student);
        } catch (SchoolException ex) {
            System.out.println("დაფიქსირდა გაუთვალისწინებელი შემთხვეა, " + ex.getMessage());
        }
    }

    private static void addStudent() {
        try {
            System.out.println("id:");
            String id = scanner.nextLine();
            System.out.println("სახელი და გვარი:");
            String name = scanner.nextLine();
            Student student = new Student(id, name);
            studentService.saveStudent(student);
        } catch (SchoolException ex) {
            System.out.println("დაფიქსირდა გაუთვალისწინებელი შემთხვეა, " + ex.getMessage());
        }
    }
}
