package de.apage4u.registry;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import de.apage4u.student.Student;
import de.apage4u.student.StudentBuilder;

class StudentsRegistry {

    private static final StudentBuilder student = new StudentBuilder();
    private static final List<Student> students = Arrays.asList(
            student.withName("Peter").withAge(19).withTotalMarks(3).build(),
            student.withName("Alex").withAge(21).withTotalMarks(1).build(),
            student.withName("Stefan").withAge(34).withTotalMarks(2).build()
    );

    Optional<Student> getByName(String name) {
        return students.stream().filter(student -> student.getName().equals(name)).findFirst();
    }
}
