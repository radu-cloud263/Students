package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private final String fileName;


    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Studenti");
            int rowNum = 0;


            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Numar Matricol");
            headerRow.createCell(1).setCellValue("Prenume");
            headerRow.createCell(2).setCellValue("Nume");
            headerRow.createCell(3).setCellValue("Formatie");
            headerRow.createCell(4).setCellValue("Nota");


            for (Student st : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(st.getNumarMatricol());
                row.createCell(1).setCellValue(st.getPrenume());
                row.createCell(2).setCellValue(st.getNume());
                row.createCell(3).setCellValue(st.getFormatieDeStudiu());
                row.createCell(4).setCellValue(st.getNota());
            }


            try (FileOutputStream out = new FileOutputStream(fileName)) {
                workbook.write(out);
                System.out.println("Export xlsx realizat cu succes in fisierul: " + fileName);
            }
        } catch (Exception e) {
            System.err.println("Eroare la crearea fisierului Excel: " + e.getMessage());
        }
    }
}