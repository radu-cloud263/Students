package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISMI41/1", 10.0),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/1", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );


        Exporter exporter = new Exporter();


        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);


        String fileNameTxt = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);


        String fileNameXlsx = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(fileNameXlsx);
        exporter.startExport(strategyFisierExcel, studenti);

        System.out.println("\n-----------------------------------\n");

        Importer importer = new Importer();


        IStudentiImport citireTextStrategy = new StudentiDinFisierText(fileNameTxt);
        List<Student> studentiDinText = importer.startImport(citireTextStrategy);
        System.out.println("Primul student citit din TXT: " +
                (!studentiDinText.isEmpty() ? studentiDinText.get(0).getNume() : "Lista goala"));

        IStudentiImport citireExcelStrategy = new StudentiDinFisierXlsx(fileNameXlsx);
        List<Student> studentiDinExcel = importer.startImport(citireExcelStrategy);
        System.out.println("Primul student citit din XLSX: " +
                (!studentiDinExcel.isEmpty() ? studentiDinExcel.get(0).getNume() : "Lista goala"));
    }
}