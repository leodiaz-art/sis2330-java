# Semana 11 - Haskell I: Entorno, Tipos y Pureza

El capstone de esta semana vive en la subcarpeta `calculadora-hs/`. Es el primer
proyecto del bloque funcional del curso.

## Capstone

[calculadora-hs/](calculadora-hs/) - Calculadora con funciones puras en `Lib.hs`
y un programa interactivo en `Main.hs`.

## Que se aprendio

Haskell separa lo puro de lo impuro en el sistema de tipos: una funcion sin `IO`
en su firma no puede leer archivos, imprimir ni cambiar nada fuera de si misma,
y el compilador lo garantiza. El `=` define, no asigna. Stack gestiona el
compilador y las dependencias del proyecto.
