# estadisticas-hs

Proyecto Haskell que procesa listas de estudiantes usando recursion,
comprensiones de lista y funciones de orden superior. El modulo de calculo es
completamente puro: no lee, no escribe, no imprime.

## Como compilar y ejecutar

    stack build
    stack run

## Modulos

- `src/Estadisticas.hs` - todas las funciones puras sobre listas de estudiantes:
  `promedio`, `masAlto`, `ordenarPorNota` y `aprobados`. Ninguna tiene `IO` en su
  tipo.
- `app/Main.hs` - la parte interactiva: pregunta cuantos estudiantes, los lee uno
  por uno y arma el reporte llamando a `Estadisticas`.

## Ejemplo de ejecucion

    Cuantos estudiantes vas a ingresar?
    2
    Nombre:
    leo
    Nota:
    51
    Nombre:
    ana
    Nota:
    54
    Promedio del grupo: 52.5
    Mas alto: ("ana",54.0)
    Ordenados por nota: [("ana",54.0),("leo",51.0)]
    Aprobados: [("leo",51.0),("ana",54.0)]

## Detalles del codigo

`masAlto` es recursiva: se llama con la cola de la lista hasta llegar a un solo
elemento, y al volver compara. Las guardas `|` reemplazan al if/else, y el
`where` define el resultado parcial una sola vez.

`ordenarPorNota` esta escrita sin mencionar la lista: `sortBy (comparing
(negate . snd))`. El punto compone funciones, y negar la nota invierte el orden
para que quede de mayor a menor.

`aprobados` usa una comprension de lista: `[e | e <- xs, snd e >= 51]` se lee
"cada e que viene de xs cuya nota llega a 51".

`replicateM` en Main repite una accion IO N veces y junta los resultados: es el
equivalente de un bucle que llena un arreglo, sin indice ni variable mutable.

## Nota

Si se ingresan 0 estudiantes el programa lo informa en vez de fallar, porque
`masAlto` no esta definida para la lista vacia.

## Que se aprendio

Tuplas y alias de tipo, recursion sobre listas, guardas y `where`, comprensiones
de lista, funciones de orden superior (`map`, `sortBy`, `comparing`), composicion
con `.` y separacion estricta entre modulo puro y modulo con IO.
