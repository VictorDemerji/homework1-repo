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
        System.out.println("\n----- Rezultate finale -----");
        System.out.println("Student: " + nume + ", Varsta: " + getVarsta() + " ani");
        System.out.println("Specialitate: " + specialitate);
        double media = getMedia();
        System.out.println("Media studentului este: " + media);
        if (media >= 9) {
            System.out.println("Esti promovat!");
        } else {
            System.out.println("Nu ati trecut cu brio, incercati in semestrul urmator!");
        }
        System.out.println("-----------------------------\n");
    }
}

public class Universitate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String raspunsProgram;

        System.out.println("=== Sistem de evidenta a studentilor ===");

        do {
            String facultate;
            while (true) {
                System.out.print("Introduceti facultatea (Matematica / Informatica): ");
                facultate = scanner.nextLine();
                if (facultate.equalsIgnoreCase("Matematica") || facultate.equalsIgnoreCase("Informatica")) {
                    System.out.println("A fost aleasa Facultatea " + facultate + ".");
                    break;
                } else {
                    System.out.println("Eroare: Facultatea introdusa nu este valida! Alegeti doar Matematica sau Informatica.");
                }
            }

            System.out.print("Doriti sa introduceti studenti noi? (Da/Nu): ");
            String raspuns = scanner.nextLine();
            if (raspuns.equalsIgnoreCase("Nu")) {
                System.out.println("Iesire din program...");
                return;
            }

            System.out.print("Creati numele grupei noi: ");
            String grupa = scanner.nextLine();
            System.out.println("Introducerea studentilor grupei " + grupa);

            System.out.print("Introduceti numele studentului: ");
            String nume = scanner.nextLine();

            System.out.print("Introduceti anul nasterii studentului: ");
            int anulNasterii = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Student: " + nume + ", Varsta: " + (Year.now().getValue() - anulNasterii) + " ani");

            String specialitate;
            while (true) {
                System.out.print("Introduceti specialitate (Algebra / Geometrie / Calcul_Integral): ");
                specialitate = scanner.nextLine();
                if (specialitate.equalsIgnoreCase("Algebra") ||
                        specialitate.equalsIgnoreCase("Geometrie") ||
                        specialitate.equalsIgnoreCase("Calcul_Integral")) {
                    System.out.println("A fost aleasa specialitatea " + specialitate + ".");
                    break;
                } else {
                    System.out.println("Eroare: Specialitatea introdusa nu este valida! Alegeti doar dintre: Algebra / Geometrie / Calcul_Integral.");
                }
            }

            double nota1 = citesteNota(scanner, "Introduceti nota test1: ");
            double nota2 = citesteNota(scanner, "Introduceti nota test2: ");
            double notaExamen = citesteNota(scanner, "Introduceti nota examen: ");

            Student student = new Student(nume, anulNasterii, specialitate, nota1, nota2, notaExamen);
            student.afisareRezultate();

            System.out.print("Doriti sa introduceti alt student? (Da/Nu): ");
            scanner.nextLine();
            raspunsProgram = scanner.nextLine();

        } while (raspunsProgram.equalsIgnoreCase("Da"));

        System.out.println("Program incheiat. Multumim!");
    }

    public static double citesteNota(Scanner scanner, String mesaj) {
        double nota;
        while (true) {
            System.out.print(mesaj);
            nota = scanner.nextDouble();
            if (nota >= 1 && nota <= 10) {
                break;
            } else {
                System.out.println("Nota invalida! Introduceti o valoare intre 1 si 10.");
            }
        }
        return nota;
    }
}