# Gestion de Vehiculos

## Descripcion
Clase abstracta Vehiculo con subclases Auto, Moto y Camion. La interfaz
Electrico la implementa AutoElectrico, que ademas hereda de Auto. El recorrido
de un ArrayList<Vehiculo> demuestra binding dinamico.

## Archivos

- `src/modelo/Vehiculo.java` - clase abstracta con metodo abstracto describir()
- `src/modelo/Auto.java`, `Moto.java`, `Camion.java` - subclases concretas
- `src/modelo/Electrico.java` - interfaz con cargarBateria()
- `src/modelo/AutoElectrico.java` - extends Auto implements Electrico
- `src/app/GestionVehiculos.java` - recorrido polimorfico

## Como compilar y ejecutar

    javac -d out src/modelo/*.java src/app/GestionVehiculos.java
    java -cp out app.GestionVehiculos

## Que se aprendio

Herencia con extends y super, polimorfismo con @Override y binding dinamico,
clases abstractas que no se pueden instanciar, interfaces como contrato de
capacidad, y pattern matching con instanceof.
