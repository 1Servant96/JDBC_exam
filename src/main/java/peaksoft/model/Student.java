package peaksoft.model;

import jakarta.persistence.Table;

//@Table
public class Student {
    private String name;
    private Byte age;
    private static long id;
    public Student(String name, Byte age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    static public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
