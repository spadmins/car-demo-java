package com.sample.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class StudentTest {

    /**
     * to test the parameterized constructor
     */
    @Test
    public final void testStudent() {
        Student s = new Student(102, "Kanak Gupta", 16, "kanak@abc.com");

        assertEquals(102, s.getStudentId());
        assertEquals("Kanak Gupta", s.getStudentName());
        assertEquals(16, s.getAge());
        assertEquals("kanak@abc.com", s.getEmail());

        Student s1 = new Student();
        assertFalse(s1.equals(s));
    }

    /**
     * test to add a student
     */
    @Test
    public final void testAddStudent() {
        List<Student> students = new ArrayList<Student>();

        Student s = new Student(101, "Monisha", 16, "m@a.c");
        Student s1 = new Student(102, "Cathy", 16, "c@a.c");
        students.add(s);
        students.add(s1);

        System.out.println("Running testAddStudent");
        assertEquals(2, students.size());

        Student s2 = new Student(103, "Alexa", 16, "a@a.c");
        students.add(s2);
        assertEquals(3, students.size());
        assertEquals(students.get(1), s1);
    }
}