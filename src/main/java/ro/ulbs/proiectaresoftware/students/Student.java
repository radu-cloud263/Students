package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    int numarMatricol;
    String Prenume;
    String Nume;
    String formatieDeStudiu;
    double Nota;

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return Prenume;
    }

    public String getNume() {
        return Nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public double getNota() { return Nota; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, Prenume, Nume, formatieDeStudiu, Nota);
    }

    public void setNota(double nota) { this.Nota = nota; };

    @Override
    public String toString() {
        return String.format("%10d %14s %11s %15s %5.2f", numarMatricol, Prenume, Nume, formatieDeStudiu, Nota);
    }

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        Prenume = prenume;
        Nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.Nota = 0;
    }
}

