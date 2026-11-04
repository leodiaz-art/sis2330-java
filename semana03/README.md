# Semana 03 - POO I

## Capstone: Gestor de Tareas

Aplicacion de consola que administra tareas con operaciones CRUD sobre un
ArrayList. Cada tarea recibe un ID autoincremental generado por un contador
static de la propia clase.

## Estructura

- `src/modelo/Tarea.java` - entidad con atributos privados, getters/setters validados y toString
- `src/app/GestorTareas.java` - logica CRUD sobre ArrayList
- `src/app/App.java` - menu interactivo con Scanner

## Como compilar y ejecutar

    javac -d out src/modelo/Tarea.java src/app/GestorTareas.java src/app/App.java
    java -cp out app.App

## Que se aprendio

Encapsulacion con atributos privados, constructores con validacion, metodos
static de clase para generar IDs, sobrescritura de toString, organizacion en
paquetes (modelo y app) y uso de ArrayList con recorrido for-each.
