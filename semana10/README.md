# Semana 10 - Vaadin: Servicio y Persistencia

El capstone de esta semana vive en la subcarpeta `gestor-tareas/`. Cierra el
bloque Java del curso.

## Capstone

[gestor-tareas/](gestor-tareas/) - Gestor de Tareas con capa de servicio
inyectada por Spring, persistencia en JSON y jar ejecutable.

## Que se aprendio

La anotacion @Service convierte una clase en componente gestionado por Spring,
con una sola instancia inyectada donde haga falta. La persistencia con Gson
serializa la lista a un archivo y la recupera al arrancar, de modo que los datos
sobreviven al reinicio.
