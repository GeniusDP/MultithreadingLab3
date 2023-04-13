package com.kpi.zaranik.journal;

import java.util.Objects;
import java.util.UUID;
import lombok.Getter;

@Getter
public class Student {

    private final UUID id = UUID.randomUUID();
    private Group group;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}