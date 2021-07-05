package com.kuang.kaobei;

public class Student implements Cloneable{
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(10,"hhh");
        Student student1 = (Student) student.clone();
        student.setAge(20);
        student.setName("THU");
        System.out.println(student.getName().hashCode());
        System.out.println(student1.getName().hashCode());
    }
}
