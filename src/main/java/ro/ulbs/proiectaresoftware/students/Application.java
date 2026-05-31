package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1", 9.80);
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1", 8.70);
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2", 8.90);
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1", 5.40);
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2", 6.20);
        Student s6 = new Student(1029, "Bianca", "Popescu", "TI131/1", 9.10);

        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);
        listaStudenti.add(s4);
        listaStudenti.add(s5);
        listaStudenti.add(s6);

        Map<Integer, Student> mapStudentiComplet = new HashMap<>();
        for (Student st : listaStudenti) {
            mapStudentiComplet.put(st.getNumarMatricol(), st);
        }

        System.out.println("Rezultat Căutare Notă în O(1)");

        double notaM = gasesteNota("Bianca", "Popescu", mapStudentiComplet);
        double notaN = gasesteNota("Ioan", "Popa", mapStudentiComplet);

        System.out.println("Nota pentru Bianca Popescu: " + notaM);
        System.out.println("Nota pentru Ioan Popa: " + notaN);
    }

    public static double gasesteNota(String prenume, String nume, Map<Integer, Student> ultimaInstantaMap) {
        Map<String, Student> mapCautareRapida = new HashMap<>();

        for (Student st : ultimaInstantaMap.values()) {
            String cheieUnica = (st.getPrenume() + "-" + st.getNume()).toLowerCase();
            mapCautareRapida.put(cheieUnica, st);
        }

        String cheieCautata = (prenume + "-" + nume).toLowerCase();

        if (mapCautareRapida.containsKey(cheieCautata)) {
            return mapCautareRapida.get(cheieCautata).getNota();
        }

        return 0.0;
    }
}