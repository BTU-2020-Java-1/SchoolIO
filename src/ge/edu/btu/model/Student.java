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

    public void addMark(int mark) {
        sumOfMarks = sumOfMarks + mark;
        numberOfMarks++;
    }

    public double getAverageMark() {
        return (double) sumOfMarks / numberOfMarks;
    }
}
