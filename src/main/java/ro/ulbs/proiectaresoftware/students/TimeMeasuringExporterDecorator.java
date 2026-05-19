package ro.ulbs.proiectaresoftware.students;

import java.util.Set;

public class TimeMeasuringExporterDecorator implements StudentExporter {
    private StudentExporter wrappedExporter;

    public TimeMeasuringExporterDecorator(StudentExporter wrappedExporter) {
        this.wrappedExporter = wrappedExporter;
    }

    @Override
    public void export(Set<Student> studenti, String fileName) {
        long startTime = System.currentTimeMillis();


        wrappedExporter.export(studenti, fileName);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Timpul de executie pentru export: " + executionTime + " ms");
    }
}