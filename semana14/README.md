# Semana 14 - Haskell IV: Testing y Estado

El capstone de esta semana vive en la subcarpeta `testing-hs/`.

## Capstone

[testing-hs/](testing-hs/) - Modulo de notas con suite HUnit + QuickCheck y un
historial de consultas basado en `State`.

## Que se aprendio

Las funciones puras son triviales de testear: entrada conocida, salida esperada,
sin preparar entorno. QuickCheck lleva eso mas lejos y verifica propiedades
contra entradas generadas al azar. La monada `State` permite llevar un contador
que cambia sin usar una sola variable mutable.
