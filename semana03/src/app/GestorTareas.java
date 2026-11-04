package app;

import java.util.ArrayList;
import java.util.List;
import modelo.Tarea;

public class GestorTareas {

    private final List<Tarea> tareas = new ArrayList<>();

    public void agregar(String descripcion) {
        tareas.add(new Tarea(descripcion));
    }

    public List<Tarea> listar() {
        return new ArrayList<>(tareas);
    }

    // Busca por ID; devuelve null si no existe
    public Tarea buscarPorId(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public boolean completar(int id) {
        Tarea t = buscarPorId(id);
        if (t == null) {
            return false;
        }
        t.marcarCompletada();
        return true;
    }

    public boolean eliminar(int id) {
        Tarea t = buscarPorId(id);
        if (t == null) {
            return false;
        }
        return tareas.remove(t);
    }

    public int contarPendientes() {
        int cuenta = 0;
        for (Tarea t : tareas) {
            if (!t.isCompletada()) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public int total() {
        return tareas.size();
    }
}
