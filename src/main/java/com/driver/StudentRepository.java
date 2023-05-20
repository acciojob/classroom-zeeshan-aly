package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class StudentRepository {

    private static HashMap<String,Student> studentData = new HashMap<>();
    private static HashMap<String,Teacher> teacherData = new HashMap<>();
    private static HashMap<String, ArrayList<String>> studentTeacherPair = new HashMap<>();


    public static void addStudent(Student student) {
        studentData.put(student.getName(),student);
    }

    public static void addTeacher(Teacher teacher) {
        teacherData.put(teacher.getName(),teacher);
    }

    public static void addPair(String student, String teacher) {
        if(studentTeacherPair.containsKey(teacher)){
            ArrayList<String> temp = studentTeacherPair.get(teacher);
            temp.add(student);
            return;
        }
        ArrayList<String> newList = new ArrayList<>();
        newList.add(student);
        studentTeacherPair.put(teacher,newList);
    }

    public static Optional<Student> getByStudentName(String name) {
        if(studentData.containsKey(name)){
            return Optional.of(studentData.get(name));
        }
        return Optional.empty();
    }

    public static Optional<Teacher> getByTeacherName(String name) {
        if(teacherData.containsKey(name)){
            return Optional.of(teacherData.get(name));
        }
        return Optional.empty();
    }

    public static List<String> getList(String teacher) {
        return studentTeacherPair.get(teacher);
    }


    public static List<Student> getAllStudents() {
        return new ArrayList<>(studentData.values());
    }

    public static void delByTeacherName(String teacher) {
        studentTeacherPair.remove(teacher);
        teacherData.remove(teacher);
    }

    public static void delStudents(String sName) {
        studentData.remove(sName);
    }

    public static List<Teacher> getAllTeachers() {
        return new ArrayList<>(teacherData.values());
    }
}