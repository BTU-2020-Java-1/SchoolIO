package ge.edu.btu.model;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 101L;

    private String id;

    private String name;

    private int sumOfMarks;

    private int numberOfMarks;

    public Student() {}

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String id, String name, int sumOfMarks, int numberOfMarks) {
        this.id = id;
        this.name = name;
        this.sumOfMarks = sumOfMarks;
        this.numberOfMarks = numberOfMarks;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSumOfMarks() {
        return sumOfMarks;
    }
    public void setSumOfMarks(int sumOfMarks) {
        this.sumOfMarks = sumOfMarks;
    }

    public int getNumberOfMarks() {
        return numberOfMarks;
    }
    public void setNumberOfMarks(int numberOfMarks) {
        this.numberOfMarks = numberOfMarks;
    }

    public void addMark(int mark) {
        sumOfMarks = sumOfMarks + mark;
        numberOfMarks++;
    }

    public double getAverageMark() {
        return (double) sumOfMarks / numberOfMarks;
    }

    public static String format(Student student) {
        String str = "id:" + student.getId() + System.lineSeparator();
        str = str + "name:" + student.getName() + System.lineSeparator();
        str = str + "sumOfMarks:" + student.getSumOfMarks() + System.lineSeparator();
        str = str + "numberOfMarks:" + student.getNumberOfMarks();
        return str;
    }

    public static Student parse(String str) {
        String[] lines = str.split(System.lineSeparator());
        String id = lines[0].split(":")[1];
        String name = lines[1].split(":")[1];
        int sumOfMarks = Integer.parseInt(lines[2].split(":")[1]);
        int numberOfMarks = Integer.parseInt(lines[3].split(":")[1]);
        return new Student(id, name, sumOfMarks, numberOfMarks);
    }
}
