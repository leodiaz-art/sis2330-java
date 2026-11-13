# Gestor de Tareas - Grid y CRUD

## Descripcion
Aplicacion web Vaadin con tabla editable (Grid), formulario validado (Binder) y
operaciones CRUD completas sobre una lista de tareas en memoria.

## Como ejecutar

    mvn spring-boot:run

Abrir http://localhost:8080 y detener con Ctrl+C.

## Estructura

- `com.tareas.Tarea` - record inmutable con id, descripcion y completada
- `com.tareas.views.TareaEditable` - clase mutable para el Binder
- `com.tareas.views.TareasView` - vista con Grid y formulario lateral

## Por que existe TareaEditable

El Binder escribe en el objeto mientras el usuario teclea, asi que necesita
setters. Tarea es un record y no los tiene, porque es inmutable. TareaEditable
hace de puente: el formulario trabaja sobre ella y al guardar se construye un
Tarea nuevo.

## Como funciona el CRUD

Al hacer clic en una fila, el listener del Grid carga esa tarea en el formulario
y guarda la seleccion. Guardar agrega una tarea nueva si no hay seleccion, o
reemplaza la seleccionada buscandola **por id**, nunca por referencia: como los
records se reconstruyen, comparar con == falla. Despues de cada operacion se
llama a grid.setItems() para redibujar la tabla.

## Nota

Los datos viven en memoria y se pierden al reiniciar. La persistencia llega en
la semana 10.

## Que se aprendio

Grid con columnas definidas por metodos del record, seleccion simple con
asSingleSelect, Binder para enlazar formulario y objeto, validacion con
asRequired, y la diferencia practica entre un modelo inmutable y uno mutable.
