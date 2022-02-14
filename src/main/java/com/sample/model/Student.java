package com.sample.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private String email;

    static List<Student> students = new ArrayList<Student>();

    public Student() {

    }

    public Student(int argStudentId, String argStudentName, int argAge, String argEmail) {
        this.studentId = argStudentId;
        this.studentName = argStudentName;
        this.age = argAge;
        this.email = argEmail;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (studentId != other.studentId && studentName != other.studentName && age != other.age && email != other.email)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [Id = " + studentId + " Name = " + studentName + " Age =" + age + 
        " Email = " + email + "]";
    }

    public String addStudent(String argName, int argAge, String argEmail) {
        int len = students.size();
        int id = 0;
        if (len == 0) {
            id = 1;
        } else {
            Student s = students.get(students.size() - 1);
            id = s.getStudentId() + 1;
        }

        Student student = new Student(id, argName, argAge, argEmail);
        students.add(student);

        len = students.size();
        if (len > 0) {
            return "Student Added Successfully";    
        } else {
            return "Student not added";
        }
        
    }

    public void listAllStudents() {
        int len = students.size();

     //   System.out.println(len);

        if(len > 0) {
            for(Student s: students) {
                System.out.println(s.toString());
            }
        } else {
            System.out.println("Database empty. Please add students!");
        }
    }

    public void updateStudentDetails( int id, int argAge, String argEmail) {
        int index = 0;

        for(Student s: students) {
            if(s.getStudentId() == id) {
                index = students.indexOf(s);
                String argName = s.getStudentName();
                Student s1 = new Student(id, argName, argAge, argEmail);
                students.set(index, s1);
                System.out.println("Student details updated");
                break;
            } else {
                System.out.println("Student Not Found In Database!");
            }
        }
    }

    public boolean removeStudent(int id) {
        boolean removed = false;

        for (Student s: students) {
            if (s.getStudentId() == id) {
                removed = students.remove(s);
                break;
            }
        }
        return removed;
    }

    public void listStudentDetails(int id) {

        for (Student s: students) {
            if (s.getStudentId() == id) {
                System.out.println(s.toString());
                break;
            } else {
                System.out.println("Student does not exist in Database");
            }
        }
    }
}