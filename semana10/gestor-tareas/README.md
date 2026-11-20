# Gestor de Tareas - Spring Boot + Vaadin + Persistencia

## Descripcion
Aplicacion web completa: frontend Vaadin, backend Spring Boot, logica de negocio
en un servicio inyectado y persistencia JSON en tareas.json. Las tareas
sobreviven a reinicios de la aplicacion.

## Como ejecutar

    mvn spring-boot:run

Abrir http://localhost:8080 y detener con Ctrl+C.

## Empaquetar

    mvn clean package -Pproduction
    java -jar target/gestor-tareas-0.0.1-SNAPSHOT.jar

El perfil `production` construye el frontend empaquetado, necesario porque
`application.properties` declara `vaadin.productionMode=true`.

## Persistencia

Los datos se guardan en `tareas.json`, en el directorio desde donde se ejecuta
el comando. El archivo no se versiona: es dato, no codigo.

## Estructura

- `com.tareas.Tarea` - record inmutable
- `com.tareas.TareaService` - logica de negocio + persistencia JSON
- `com.tareas.views.TareasView` - Grid con CRUD
- `com.tareas.views.TareaDetalleView` - detalle por ID
- `com.tareas.views.TareaEditable` - clase mutable para el Binder
- `com.tareas.views.MainLayout` - AppLayout con menu lateral

## Por que el servicio es la unica fuente de verdad

Las vistas no guardan listas propias ni campos estaticos: piden todo a
TareaService, que Spring inyecta por constructor. Como @Service crea una sola
instancia, las dos vistas ven exactamente los mismos datos. Escribir
`new TareaService()` a mano rompería eso: crearía una copia con su propia lista,
desincronizada del resto.

Los metodos del servicio son `synchronized` porque Vaadin puede atender eventos
de sesiones distintas a la vez, y dos guardados simultaneos corromperian la
lista antes de escribir el archivo.

## Que se aprendio

Inyeccion de dependencias por constructor, @Service como capa de negocio
gestionada por Spring, serializacion y deserializacion con Gson y TypeToken,
manejo del caso en que el archivo todavia no existe, y empaquetado de una
aplicacion Vaadin como jar ejecutable.
