package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    public static void addStudent(Student student) {
        StudentRepository.addStudent(student);
    }

    public static void addTeacher(Teacher teacher) {
        StudentRepository.addTeacher(teacher);
    }

    public static void addStudentTeacherPair(String student, String teacher) {
        StudentRepository.addPair(student,teacher);
    }

    public static Student getStudentByName(String name) {
        Optional<Student> stu = StudentRepository.getByStudentName(name);
        if(stu.isPresent()) return stu.get();
        return null;
    }

    public static Teacher getTeacherByNmae(String name) {
        Optional<Teacher> tea = StudentRepository.getByTeacherName(name);
        if(tea.isPresent()) return tea.get();
        return null;
    }

    public static List<String> getPairList(String teacher) {
        return StudentRepository.getList(teacher);
    }

    public static List<String> getStudents() {
        List<Student> studentList = StudentRepository.getAllStudents();
        List<String> AllStudentnameList = new ArrayList<>();
        for(Student s : studentList){
            AllStudentnameList.add(s.getName());
        }
        return AllStudentnameList;
    }

    public static void deleteByTeacher(String teacher) {
        List<String> studentsToBeDel = getPairList(teacher);
        StudentRepository.delByTeacherName(teacher);
        for(String sName : studentsToBeDel){
            StudentRepository.delStudents(sName);
        }
    }

    public static void delAllTeachers() {
        List<Teacher> teacherList = StudentRepository.getAllTeachers();
        for(Teacher t : teacherList){
            deleteByTeacher(t.getName());
        }
    }
}