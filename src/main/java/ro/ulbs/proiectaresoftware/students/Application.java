package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");

        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);
        listaStudenti.add(s4);
        listaStudenti.add(s5);

        System.out.println(String.format("%10s %14s %11s %15s %5s", "MATRICOL", "PRENUME", "NUME", "FORMATIE", "NOTA"));
        for (Student st : listaStudenti) {
            System.out.println(st);
        }
        System.out.println();

        Student studentCautatB = new Student(120, "Alis", "Popa", "TI21/2");
        Student studentCautatC = new Student(112, "Maria", "Popa", "TI21/1");

        System.out.println("Prezent studentul B? " + cautaInLista(listaStudenti, studentCautatB));
        System.out.println("Prezent studentul C? " + cautaInLista(listaStudenti, studentCautatC));
        System.out.println();

        Set<Student> setStudenti = new HashSet<>(listaStudenti);

        System.out.println("Prezent studentul B (O(1))? " + setStudenti.contains(studentCautatB));
        System.out.println("Prezent studentul C (O(1))? " + setStudenti.contains(studentCautatC));
    }

    public static boolean cautaInLista(List<Student> lista, Student cautat) {
        for (Student st : lista) {
            if (st.getPrenume().equals(cautat.getPrenume()) &&
                    st.getNume().equals(cautat.getNume()) &&
                    st.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) {
                return true;
            }
        }
        return false;
    }
}
