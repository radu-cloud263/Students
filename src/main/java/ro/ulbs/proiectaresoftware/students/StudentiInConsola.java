package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {

    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("--- Export Studenti in Consola ---");
        for (Student st : studenti) {
            System.out.println(st.toString());
        }
    }
}