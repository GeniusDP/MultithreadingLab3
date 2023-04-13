package com.kpi.zaranik.journal;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Group group1 = Group.randomGroup(50);
        Group group2 = Group.randomGroup(30);
        Group group3 = Group.randomGroup(40);

        Register register = new Register();

        register.addGroup(group1);
        register.addGroup(group2);
        register.addGroup(group3);

        Teacher lecturer = new Teacher(register, register.getGroupList());
        Teacher assistant1 = new Teacher(register, List.of(group1));
        Teacher assistant2 = new Teacher(register, List.of(group2));
        Teacher assistant3 = new Teacher(register, List.of(group3));

        for (int i = 0; i < 10; i++) {
            lecturer.addGrades();
            assistant1.addGrades();
            assistant2.addGrades();
            assistant3.addGrades();
        }

        List<Integer> grades = register.getGrades(group1.getStudentsList().get(0));
        System.out.println(grades);
    }
}