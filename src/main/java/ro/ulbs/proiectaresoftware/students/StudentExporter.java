package ro.ulbs.proiectaresoftware.students;

import java.util.Set;

public interface StudentExporter {
    void export(Set<Student> studenti, String fileName);
}