# calculadora-hs

Proyecto Haskell que separa las funciones puras de la interaccion con el
usuario. `Lib.hs` concentra el calculo y `Main.hs` concentra el IO: esa
separacion es el eje de la programacion funcional.

## Como correr

    stack build
    stack run

El programa pide dos numeros por consola y muestra su suma.

## Modulos

- `src/Lib.hs` - funciones puras: `suma`, `doble` y `promedio`. Ninguna tiene
  `IO` en su tipo, asi que el compilador garantiza que son deterministas y no
  tocan nada fuera de si mismas.
- `app/Main.hs` - la parte impura: lee del teclado, convierte el texto a `Int`
  con `read` y delega el calculo a `Lib`.

## Detalles del codigo

`promedio` esta definida con dos ecuaciones: una para la lista vacia y otra para
el resto. Eso es pattern matching, el reemplazo del `if` cuando los casos
dependen de la forma del dato.

`fromIntegral` convierte el `Int` que devuelve `length` a `Double`. Haskell no
convierte tipos numericos de forma implicita como Java, hay que pedirlo.

## Que se aprendio

Firmas de tipo explicitas, funciones puras frente a acciones `IO`, pattern
matching, el bloque `do` para encadenar entrada y salida, la diferencia entre
`<-` (extraer de una accion IO) y `let` (definir un valor puro), y el manejo de
un proyecto con Stack.
