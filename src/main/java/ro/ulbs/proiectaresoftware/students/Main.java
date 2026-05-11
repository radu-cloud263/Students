package ro.ulbs.proiectaresoftware.students;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNumarMatricol(), st.getPrenume(), st.getNume(), nouaFormatieDeStudiu, st.getNota());
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> studentiNoi = new LinkedHashSet<>();

        int total = studenti.size();
        int jumatate = (total + 1) / 2;

        int index = 0;
        for (Student st : studenti) {
            if (index < jumatate) {
                studentiNoi.add(schimbaFormatia(st, formatia1));
            } else {
                studentiNoi.add(schimbaFormatia(st, formatia2));
            }
            index++;
        }

        return studentiNoi;
    }

    public static void main(String[] args) {

        Set<Student> studenti = new LinkedHashSet<>();

        studenti.add(new Student(1025, "Andrei", "Popa", "Veche", 8.70));
        studenti.add(new Student(1024, "Ioan", "Mihalcea", "Veche", 10.0));
        studenti.add(new Student(1026, "Anamaria", "Prodan", "Veche", 8.90));
        studenti.add(new Student(1029, "Bianca", "Popescu", "Veche", 10.0));
        studenti.add(new Student(1030, "Mihai", "Eminescu", "Veche", 9.50));

        System.out.println("--- Lista initiala ---");
        for(Student st : studenti) {
            System.out.println(st);
        }

        Set<Student> studentiImpartiti = imparteInDouaFormatii(studenti, "TI 211 1", "TI 211 2");

        System.out.println("\n--- Lista dupa impartirea in formatii noi ---");
        for(Student st : studentiImpartiti) {
            System.out.println(st);
        }
    }
}