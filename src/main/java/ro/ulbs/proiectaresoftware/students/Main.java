package ro.ulbs.proiectaresoftware.students;

import java.util.*;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {


            Map<Integer, Student> mapStudenti = new HashMap<>();
            List<Student> listaStudenti = new ArrayList<>();


            try (Scanner scanner = new Scanner(new File("studenti_in.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] date = line.split(",");

                    if (date.length == 4) {
                        int numarMatricol = Integer.parseInt(date[0].trim());
                        String prenume = date[1].trim();
                        String nume = date[2].trim();
                        String formatieDeStudiu = date[3].trim();

                        Student student = new Student(numarMatricol, prenume, nume, formatieDeStudiu);


                        mapStudenti.put(numarMatricol, student);
                        listaStudenti.add(student);
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Eroare: Fisierul 'studenti_in.txt' nu a fost gasit");
                return;
            }


            try (Scanner scannerNote = new Scanner(new File("note_anon.txt"))) {
                while (scannerNote.hasNextLine()) {
                    String line = scannerNote.nextLine();
                    String[] date = line.split(",");

                    if (date.length >= 2) {
                        int numarMatricol = Integer.parseInt(date[0].trim());
                        double nota = Double.parseDouble(date[1].trim());


                        Student studentGasit = mapStudenti.get(numarMatricol);


                        if (studentGasit != null) {
                            studentGasit.setNota(nota);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Eroare: fisierul 'note_anon.txt' nu a fost gasit");
            }

            System.out.println("Studenti si Note din Map:");
            for (Map.Entry<Integer, Student> entry : mapStudenti.entrySet()) {
                System.out.println(entry.getValue().toString());
            }

            listaStudenti.sort(
                    Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume)
            );

            try (PrintWriter writer = new PrintWriter(new File("studenti_out_sorted.txt"))) {
                for (Student s : listaStudenti) {
                    writer.println(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu() + "," + s.getNota());
                }
                System.out.println("Studentii au fost sortati si salvati in 'studenti_out_sorted.txt'");
            } catch (FileNotFoundException e) {
                System.err.println("Eroare: Nu s-a putut crea/accesa fisierul 'studenti_out_sorted.txt'");
            }
    }
}
