# Gestor de Tareas (Vaadin)

## Descripcion
Aplicacion web construida con Vaadin y Spring Boot que permite agregar tareas a
una lista en memoria y verlas como texto plano. No hay HTML, CSS ni JavaScript
escritos a mano: toda la interfaz son objetos Java del lado del servidor.

## Como ejecutar

    mvn spring-boot:run

Abrir http://localhost:8080 y detener con Ctrl+C.

## Estructura

- `com.tareas.Application` - punto de entrada con @SpringBootApplication
- `com.tareas.Tarea` - record con id, descripcion y completada
- `com.tareas.views.TareasView` - vista unica con @Route("") en la ruta raiz

## Como funciona

La vista extiende VerticalLayout y arma sus componentes en el constructor. El
Button recibe una lambda que se ejecuta en el servidor al hacer clic: valida el
campo, crea la Tarea con un id incremental y vuelve a dibujar la lista. Vaadin
traduce ese arbol de componentes a HTML y solo envia al navegador lo que cambio.

## Nota

Las tareas viven en una List en memoria, asi que se pierden al reiniciar la
aplicacion. La persistencia llega en la semana 10.

## Que se aprendio

Vaadin como framework de UI en Java puro, la anotacion @Route para publicar una
vista en una URL, los layouts VerticalLayout y HorizontalLayout, componentes
TextField, Button, Div y Notification, lambdas como manejadores de eventos del
lado del servidor, y records de Java como modelos inmutables.
