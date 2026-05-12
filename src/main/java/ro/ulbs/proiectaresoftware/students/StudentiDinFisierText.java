package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private final String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;


                String[] parts = line.trim().split("\\s+");

                if (parts.length >= 5) {
                    int nrMatricol = Integer.parseInt(parts[0]);
                    String prenume = parts[1];
                    String nume = parts[2];
                    String formatie = parts[3];

                    double nota = Double.parseDouble(parts[4].replace(",", "."));

                    students.add(new Student(nrMatricol, prenume, nume, formatie, nota));
                }
            }
            System.out.println("Import txt realizat cu succes din fisierul: " + fileName);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Eroare la citirea din fisierul text: " + e.getMessage());
        }
        return students;
    }
}