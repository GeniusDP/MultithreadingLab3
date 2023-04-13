package com.kpi.zaranik.journal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    private final Set<Student> students = new HashSet<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public static Group randomGroup(int capacity) {
        Group group = new Group();
        for (int i = 0; i < capacity; i++) {
            group.addStudent(new Student());
        }

        return group;
    }

    public List<Student> getStudentsList() {
        return new ArrayList<>(students);
    }
}
