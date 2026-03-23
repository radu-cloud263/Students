package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> listaStudenti = new ArrayList<>();

        try {
            File fisier = new File("studenti_in.txt");
            Scanner scanner = new Scanner(fisier);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] date = line.split(",");

                if (date.length == 4) {
                    int numarMatricol = Integer.parseInt(date[0].trim());
                    String prenume = date[1].trim();
                    String nume = date[2].trim();
                    String formatieDeStudiu = date[3].trim();

                    Student student = new Student(numarMatricol, prenume, nume, formatieDeStudiu);
                    listaStudenti.add(student);
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            return;
        }

        System.out.println("Studenti nesortati:");
        for (Student s : listaStudenti) {
            System.out.println(s.toString());
        }

        listaStudenti.sort(
                Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume)
        );

        try {
            File fisierOutSorted = new File("studenti_out_sorted.txt");
            PrintWriter writer = new PrintWriter(fisierOutSorted);

            for (Student s : listaStudenti) {
                writer.println(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
            }

            writer.close();
            System.out.println("\nStudentii au fost sortati si salvati in 'studenti_out_sorted.txt'");
        } catch (FileNotFoundException e) {
            System.err.println("Eroare: Nu s-a putut accesa fisierul 'studenti_out_sorted.txt'");
        }
    }

}
