package com.kpi.zaranik.journal;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Teacher {

    private final Register register;
    private final List<Group> groups;

    @SneakyThrows
    public void addGrades() {
        GradeAdditionProcess gradeAdditionProcess = new GradeAdditionProcess(register, groups);
        gradeAdditionProcess.start();
        gradeAdditionProcess.join();
    }
}
