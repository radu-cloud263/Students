package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
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

    public static List<Student> readFromXls(String fileName) {
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next(); // Skip header
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();

                students.add(new Student(nrMatricol, prenume, nume, formatie, nota));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {

        Set<Student> studenti = new LinkedHashSet<>();

        studenti.add(new Student(1025, "Andrei", "Popa", "Veche", 8.70));
        studenti.add(new Student(1024, "Ioan", "Mihalcea", "Veche", 10.0));
        studenti.add(new Student(1026, "Anamaria", "Prodan", "Veche", 8.90));
        studenti.add(new Student(1029, "Bianca", "Popescu", "Veche", 10.0));
        studenti.add(new Student(1030, "Mihai", "Eminescu", "Veche", 9.50));

        Set<Student> studentiImpartiti = imparteInDouaFormatii(studenti, "TI 211 1", "TI 211 2");

        String xlsFileName = "laborator8_students.xlsx";


        StudentExporter baseExporter = new XlsStudentExporter();


        StudentExporter timedExporter = new TimeMeasuringExporterDecorator(baseExporter);


        timedExporter.export(studentiImpartiti, xlsFileName);

        List<Student> studentsFromXls = readFromXls(xlsFileName);

        System.out.println("\nStudenti cititi din excel:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }
}