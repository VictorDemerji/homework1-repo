import java.util.Scanner;
import java.time.Year;

class Student {
    String nume;
    int anulNasterii;
    String specialitate;
    double nota1, nota2, notaExamen;

    public Student(String nume, int anulNasterii, String specialitate, double nota1, double nota2, double notaExamen) {
        this.nume = nume;
        this.anulNasterii = anulNasterii;
        this.specialitate = specialitate;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaExamen = notaExamen;
    }

    public int getVarsta() {
        int anulCurent = Year.now().getValue();
        return anulCurent - anulNasterii;
    }

    public double getMedia() {
        return (nota1 + nota2 + notaExamen) / 3.0;
    }

    public void afisareRezultate() {
        System.out.println("Student: " + nume + ", Varsta: " + getVarsta() + " ani");
        System.out.println("Specialitate: " + specialitate);
        double media = getMedia();
        System.out.println("Media studentului este: " + String.format("%.2f", media));
        if (media > 9) {
            System.out.println("Esti promovat!");
        } else {
            System.out.println("Nu ati trecut cu brio, incercati in semestrul urmator!");
        }
    }
}

public class Universitate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Intrare in program...");
        System.out.print("Introducere facultate (Matematica / Informatica): ");
        String facultate = scanner.nextLine();
        System.out.println("A fost aleasa Facultatea " + facultate + ".");

        System.out.print("Doriti sa introduceti studenti noi? (Da/Nu): ");
        String raspuns = scanner.nextLine();

        if (raspuns.equalsIgnoreCase("Nu")) {
            System.out.println("Iesire din program...");
            return;
        }

        System.out.print("Creati numele grupei noi: ");
        String grupa = scanner.nextLine();
        System.out.println("Introducerea studentilor grupei " + grupa);

        System.out.print("Introduceti numele studentului 1: ");
        String nume = scanner.nextLine();

        System.out.print("Introduceti anul nasterii studentului: ");
        int anulNasterii = scanner.nextInt();
        scanner.nextLine(); // consumă newline

        System.out.println("Student: " + nume + ", Varsta: " + (Year.now().getValue() - anulNasterii) + " ani");

        System.out.print("Introduceti specialitate (Algebra/Geometrie/Calcul_Integral): ");
        String specialitate = scanner.nextLine();
        System.out.println("A fost aleasa specialitatea " + specialitate + ".");

        System.out.print("Introduceti nota test1: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Introduceti nota test2: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Introduceti nota examen: ");
        double notaExamen = scanner.nextDouble();

        Student student = new Student(nume, anulNasterii, specialitate, nota1, nota2, notaExamen);

        System.out.println("----- Rezultate finale -----");
        student.afisareRezultate();

        System.out.println("Iesire din program...");
    }
}