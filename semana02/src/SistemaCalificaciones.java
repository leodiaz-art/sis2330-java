import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaCalificaciones {

    // Lee una nota validando que sea numero y este entre 0 y 100
    static double leerNota(Scanner sc, String mensaje) {
        double nota = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                nota = sc.nextDouble();
                if (nota < 0 || nota > 100) {
                    System.out.println("Error: la nota debe estar entre 0 y 100.");
                    continue;
                }
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un numero valido.");
                sc.next();
            }
        }
        return nota;
    }

    // Promedio de las notas de un estudiante
    static double promedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }

    // Nota mas alta
    static double maximo(double[] notas) {
        double max = notas[0];
        for (double n : notas) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    // Nota mas baja
    static double minimo(double[] notas) {
        double min = notas[0];
        for (double n : notas) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    // Determina si aprobo segun el promedio
    static String estado(double promedio) {
        return promedio >= 51 ? "Aprobado" : "Reprobado";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int ESTUDIANTES = 5;
        final int NOTAS = 3;

        String[] nombres = new String[ESTUDIANTES];
        double[][] notas = new double[ESTUDIANTES][NOTAS];

        // Captura de datos
        for (int i = 0; i < ESTUDIANTES; i++) {
            System.out.print("Nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.next();

            for (int j = 0; j < NOTAS; j++) {
                notas[i][j] = leerNota(sc, "  Nota " + (j + 1) + ": ");
            }
        }

        // Reporte final
        System.out.println();
        System.out.println("=============== REPORTE FINAL ===============");
        System.out.printf("%-12s %10s %8s %8s %12s%n",
                "NOMBRE", "PROMEDIO", "MAXIMO", "MINIMO", "ESTADO");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < ESTUDIANTES; i++) {
            double prom = promedio(notas[i]);
            System.out.printf("%-12s %10.2f %8.2f %8.2f %12s%n",
                    nombres[i],
                    prom,
                    maximo(notas[i]),
                    minimo(notas[i]),
                    estado(prom));
        }
        System.out.println("=============================================");

        sc.close();
    }
}