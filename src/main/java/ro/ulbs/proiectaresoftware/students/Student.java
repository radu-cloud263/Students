package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    int numarMatricol;
    String Prenume;
    String Nume;

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

    @Override
    public String toString() {
        // Folosim String.format pentru a alinia textul pe coloane
        return String.format("%10d %14s %11s %15s", numarMatricol, Prenume, Nume, formatieDeStudiu);
    }

    String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        Prenume = prenume;
        Nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
}

