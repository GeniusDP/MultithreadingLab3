package com.kpi.zaranik.journal;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GradeAdditionProcess extends Thread {

    private final Register register;
    private final List<Group> groups;

    @Override
    public void run() {
        for (Group group : groups) {
            List<Student> studentList = group.getStudentsList();

            for (Student student : studentList) {
                register.addGrade(student, Math.toIntExact(Math.round(Math.random() * 100)));
            }
        }
    }
}