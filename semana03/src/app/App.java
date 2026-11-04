package app;

import java.util.List;
import java.util.Scanner;
import modelo.Tarea;

public class App {

    private static final GestorTareas gestor = new GestorTareas();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1" -> agregarTarea();
                case "2" -> listarTareas();
                case "3" -> completarTarea();
                case "4" -> eliminarTarea();
                case "0" -> salir = true;
                default -> System.out.println("Opcion invalida.");
            }
            System.out.println();
        }

        System.out.println("Hasta luego.");
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== GESTOR DE TAREAS =====");
        System.out.println("Total: " + gestor.total()
                + " | Pendientes: " + gestor.contarPendientes());
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Eliminar tarea");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    private static void agregarTarea() {
        System.out.print("Descripcion: ");
        String desc = sc.nextLine();
        try {
            gestor.agregar(desc);
            System.out.println("Tarea agregada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarTareas() {
        List<Tarea> lista = gestor.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }
        for (Tarea t : lista) {
            System.out.println("  " + t);
        }
    }

    private static void completarTarea() {
        int id = leerId();
        if (gestor.completar(id)) {
            System.out.println("Tarea completada.");
        } else {
            System.out.println("No existe una tarea con ID " + id);
        }
    }

    private static void eliminarTarea() {
        int id = leerId();
        if (gestor.eliminar(id)) {
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("No existe una tarea con ID " + id);
        }
    }

    private static int leerId() {
        System.out.print("ID: ");
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
