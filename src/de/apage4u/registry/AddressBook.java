package de.apage4u.registry;

import java.util.Optional;

import de.apage4u.student.Student;

class AddressBook {
    private StudentsRegistry studentsRegistry;

    AddressBook(StudentsRegistry studentsRegistry) {
        this.studentsRegistry = studentsRegistry;
    }

    Optional<Student> getByName(String name) {
        return studentsRegistry.getByName(name);
    }
}
