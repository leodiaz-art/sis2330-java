public class Fundamentos {

    public static void main(String[] args) {
        // --- Tipos primitivos ---
        int edad = 20;
        double promedio = 78.5;
        boolean aprobado = true;
        char inicial = 'L';

        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobado: " + aprobado);
        System.out.println("Inicial: " + inicial);

        // --- Division entera vs decimal ---
        int suma = 7;
        int cantidad = 2;

        System.out.println("7 / 2 (entera) = " + (suma / cantidad));
        System.out.println("7 / 2 (decimal) = " + ((double) suma / cantidad));

        // --- Operador modulo ---
        int numero = 17;
        System.out.println("17 % 5 = " + (numero % 5));
        System.out.println("17 es par? " + (numero % 2 == 0));

        // --- Operadores logicos y cortocircuito ---
        int divisor = 0;
        if (divisor != 0 && 10 / divisor > 1) {
            System.out.println("No entra aqui");
        } else {
            System.out.println("Cortocircuito evito la division por cero");
        }
        
        // --- if / else if / else ---
        double nota = 78.5;
        if (nota >= 90) {
            System.out.println("Calificacion: Excelente");
        } else if (nota >= 51) {
            System.out.println("Calificacion: Aprobado");
        } else {
            System.out.println("Calificacion: Reprobado");
        }

        // --- switch expression ---
        int dia = 3;
        String nombreDia = switch (dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miercoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            default -> "Fin de semana";
        };
        System.out.println("Dia " + dia + ": " + nombreDia);

        // --- Bucle for ---
        System.out.print("Contando con for: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // --- Bucle while ---
        System.out.print("Contando con while: ");
        int contador = 5;
        while (contador > 0) {
            System.out.print(contador + " ");
            contador--;
        }
        System.out.println();
                // --- Arrays 1D ---
        int[] notas = {85, 90, 78, 92, 65};
        System.out.print("Notas: ");
        for (int n : notas) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Cantidad de notas: " + notas.length);

        // --- Arrays 2D (matriz) ---
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Matriz 3x3:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // --- Metodos con sobrecarga ---
        System.out.println("Promedio del array: " + promedio(notas));
        System.out.println("Promedio de 5.0 y 7.0: " + promedio(5.0, 7.0));
        imprimirLinea();
    }
    
    // Promedio de un arreglo de enteros
    static double promedio(int[] valores) {
        int suma = 0;
        for (int v : valores) {
            suma += v;
        }
        return (double) suma / valores.length;
    }

    // Sobrecarga: mismo nombre, distintos parametros
    static double promedio(double a, double b) {
        return (a + b) / 2;
    }

    // Metodo void: no retorna nada
    static void imprimirLinea() {
        System.out.println("------------------");
    }
}
