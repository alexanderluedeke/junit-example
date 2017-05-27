package de.apage4u.student;

public class Student {
    private String name;
    private int age;
    private int totalMarks;

    public Student(String name, int age, int totalMarks) {
        this.name = name;
        this.age = age;
        this.totalMarks = totalMarks;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", totalMarks=" + totalMarks +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        return
                age == student.age && totalMarks == student.totalMarks
                        && (name != null ? name.equals(student.name) : student.name == null);
    }
}