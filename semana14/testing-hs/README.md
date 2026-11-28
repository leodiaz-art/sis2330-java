# testing-hs

Proyecto Haskell con funciones puras sobre notas de estudiantes, una suite de
tests automatizados (HUnit + QuickCheck) y un modulo de conteo basado en `State`
que lleva estado sin variables mutables.

## Como correr

    stack build && stack test && stack run

## Modulos

- `src/Notas.hs` - funciones puras sobre estudiantes: `promedio`, `masAlto`,
  `ordenarPorNota`, `aprobados` y `parsearLinea`. Sin `IO`.
- `src/Historial.hs` - conteo de consultas dentro de `State Conteo`, sin `IORef`
  ni mutacion directa.
- `test/Spec.hs` - 6 tests HUnit y 1 propiedad QuickCheck.
- `app/Main.hs` - unico modulo con `IO`: procesa las lineas, arma el reporte y
  decide cuando ejecutar las transiciones de estado con `execState`.

## Los dos estilos de test

**HUnit** prueba casos concretos que uno escribe a mano: "el promedio de 10, 20 y
30 es 20". Sirve para fijar el comportamiento esperado en situaciones puntuales,
incluida la linea invalida que debe devolver `Left`.

**QuickCheck** prueba propiedades. En vez de dar ejemplos, se declara algo que
debe valer siempre —`length (ordenarPorNota xs) == length xs`— y la libreria
genera cien listas al azar para intentar romperlo:

    Cases: 6  Tried: 6  Errors: 0  Failures: 0
    Propiedad QuickCheck: ordenar preserva longitud
    +++ OK, passed 100 tests.

Si alguna entrada la rompiera, QuickCheck reduce el caso hasta el ejemplo minimo
que falla.

## Estado sin mutacion

`registrarConsulta :: String -> State Conteo ()` no modifica nada cuando se
escribe: describe una transformacion del conteo. `Main` encadena cinco de esas
transformaciones y las ejecuta de una vez con `execState` sobre un mapa vacio.

Por eso `Historial` sigue siendo puro y testeable sin preparar ningun entorno:
no hay `IORef`, ni `MVar`, ni variable global que alguien pueda haber tocado
antes.

## Que se aprendio

Testing automatizado con HUnit, testing basado en propiedades con QuickCheck,
la monada `State` para llevar estado de forma pura, `Data.Map` para conteos, y
el diseno de mantener toda la logica fuera de `IO` para que los tests puedan
llamarla directamente.
