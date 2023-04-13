package com.kpi.zaranik.journal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Register {

    private final ConcurrentMap<Student, List<Integer>> studentGradesMap = new ConcurrentHashMap<>();
    private final List<Group> groupList = new ArrayList<>();

    private final Lock lock = new ReentrantLock();

    public void addGroup(Group group) {
        lock.lock();
        try {
            groupList.add(group);

            for (var student : group.getStudentsList()) {
                if (!studentGradesMap.containsKey(student)) {
                    studentGradesMap.put(student, new ArrayList<>());
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void addGrade(Student student, int grade) {
        if (grade < 0 || grade > 100) {
            throw new RuntimeException("Wrong grade");
        }
        studentGradesMap.get(student).add(grade);
    }

    public List<Group> getGroupList() {
        return new ArrayList<>(groupList);
    }

    public List<Integer> getGrades(Student student) {
        return this.studentGradesMap.get(student);
    }
}