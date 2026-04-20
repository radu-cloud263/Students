package ro.ulbs.proiectaresoftware.students;

import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class Main {


    public static void salveazaInFisier(String numeFisier, Collection<? extends Student> colectieStudenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            for (Student student : colectieStudenti) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Lista a fost salvata cu succes in: " + numeFisier);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisierul " + numeFisier + ": " + e.getMessage());
        }
    }
    public static void main(String[] args) {


        List<StudentBursier> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));


        salveazaInFisier("bursieri_out.txt", bursieri);
    }
}
