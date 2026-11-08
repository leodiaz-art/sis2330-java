# Sistema de Estudiantes Avanzado

## Descripcion
Sistema de consola que registra estudiantes con codigo unico, nombre y promedio,
y mantiene un ranking que se reordena solo. Permite buscar, actualizar promedios,
listar el ranking completo y obtener el top N.

## Por que estas estructuras

- `HashMap<String, Estudiante>`: busqueda por codigo en O(1). Sin el, buscar un
  estudiante obligaria a recorrer toda la coleccion.
- `TreeSet<Estudiante>`: mantiene el ranking siempre ordenado por promedio
  descendente, sin volver a ordenar manualmente en cada consulta. El orden lo
  define `Estudiante.compareTo()`.
- `topN` y `listarRanking` devuelven `ArrayList`: una copia. Nunca se expone el
  TreeSet interno, asi nadie de afuera puede modificar la estructura del sistema.

## Detalle importante

`actualizarPromedio` hace remove, muta y vuelve a add. El TreeSet calcula la
posicion de un elemento al insertarlo; si se cambia el promedio de un objeto que
ya esta adentro, el arbol lo deja en la posicion vieja y el elemento queda
inalcanzable.

## Como compilar y ejecutar

    javac -d out src/modelo/Estudiante.java src/servicio/SistemaEstudiantes.java src/Principal.java
    java -cp out Principal

## Ejemplo de salida

    1.Registrar 2.Buscar 3.Actualizar 4.Ranking 5.Top N 6.Salir
    Opcion: 4
    #345435 bruno (57.0)
    #45324 leo (54.0)

## Que se aprendio

Collections Framework: HashMap para acceso por clave, TreeSet para orden
automatico, ArrayList para resultados. Comparable con compareTo, el contrato
equals/hashCode, y por que no se debe mutar un objeto ya insertado en un TreeSet.
