# Semana 13 - Haskell III: Monads y Archivos

El capstone de esta semana vive en la subcarpeta `persistencia-hs/`.

## Capstone

[persistencia-hs/](persistencia-hs/) - Persistencia de estudiantes en CSV con
manejo seguro de errores mediante `Either`.

## Que se aprendio

Un fallo esperado no tiene por que ser una excepcion: `Either String a` lo
convierte en un valor que el tipo obliga a considerar. El parseo se mantiene
puro y separado del acceso a archivos, que es la parte con `IO`.
