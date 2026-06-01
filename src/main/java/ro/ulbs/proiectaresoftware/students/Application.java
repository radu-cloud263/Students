package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        List<Student> studentiNota10 = studentiCuNote.stream()
                .filter(s -> s.getNota() == 10.0)
                .collect(Collectors.toList());
        System.out.println("a) Studenti cu nota 10:\n" + studentiNota10);

        List<Student> studentiSub5 = studentiCuNote.stream()
                .filter(s -> s.getNota() < 5.0)
                .collect(Collectors.toList());
        System.out.println("\nb) Studenti cu nota sub 5:\n" + studentiSub5);

        List<Student> studentiMapati = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4.0) {
                        return new Student(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), 4.0);
                    }
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("\nc) Lista dupa ce notele sub 4 devin 4:\n" + studentiMapati);

        double sumaNotelor = studentiCuNote.stream()
                .map(Student::getNota)
                .reduce(0.0, Double::sum);
        System.out.println("\nd) Suma tuturor notelor: " + sumaNotelor);

        double media = sumaNotelor / studentiCuNote.size();
        System.out.println("e) Media notelor: " + media);
    }
}