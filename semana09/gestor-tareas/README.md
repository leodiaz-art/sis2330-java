# Gestor de Tareas - Navegacion Multi-Vista

## Descripcion
Aplicacion web Vaadin con navegacion entre pantallas: listado con Grid, vista de
detalle por ID y una vista informativa, todas envueltas en un layout con menu
lateral.

## Como ejecutar

    mvn spring-boot:run

Abrir http://localhost:8080 y detener con Ctrl+C.

## Rutas

- `/` - Lista de tareas (TareasView)
- `/tareas/{id}` - Detalle de una tarea (TareaDetalleView)
- `/acerca` - Informacion (AcercaDeView)

## Estructura

- `com.tareas.Tarea` - record inmutable
- `com.tareas.views.MainLayout` - AppLayout con navbar y menu lateral
- `com.tareas.views.TareasView` - Grid con alta de tareas y enlace al detalle
- `com.tareas.views.TareaDetalleView` - detalle por ID con HasUrlParameter
- `com.tareas.views.AcercaDeView` - vista informativa

## Como funciona la navegacion

Cada vista declara su URL con @Route y el layout que la envuelve. MainLayout no
lleva @Route: no es una pantalla, es el marco comun. Los RouterLink del menu
navegan sin recargar la pagina, porque Vaadin solo reemplaza el contenido del
layout.

TareaDetalleView implementa HasUrlParameter<Long>, asi que Vaadin le pasa el
numero de la URL al metodo setParameter antes de mostrarla. Si no existe una
tarea con ese id, la vista lo informa en vez de fallar.

## Nota

La lista es un campo static compartido por las vistas, porque cada navegacion
construye una instancia nueva de la vista. Los datos se pierden al reiniciar;
la persistencia llega en la semana 10.

## Que se aprendio

Router de Vaadin con @Route y layouts anidados, AppLayout con navbar y drawer,
RouterLink para navegar sin recargar, HasUrlParameter para recibir parametros de
la URL, y ComponentRenderer para poner componentes dentro de una celda del Grid.
