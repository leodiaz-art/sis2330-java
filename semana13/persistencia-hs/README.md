# persistencia-hs

Proyecto Haskell que guarda una lista de estudiantes en un archivo CSV y la
vuelve a cargar al iniciar. Las lineas mal formadas se reportan como avisos en
vez de tumbar el programa.

## Como compilar y ejecutar

    stack build
    stack run

Al iniciar carga `estudiantes.csv` si existe, pregunta cuantos estudiantes
nuevos agregar, y guarda la lista completa al terminar.

## Formato del archivo

Una linea por estudiante, nombre y nota separados por coma:

    LEO,51.0
    BRUNO,76.0
    ANA,43.0

## Manejo de errores con Either

`parsearLinea :: String -> Either String Estudiante` devuelve `Right` con el
estudiante cuando la linea es valida, o `Left` con un mensaje cuando no lo es.
El error es un **valor de retorno**, no una excepcion.

Por eso `cargarEstudiantes` devuelve `[Either String Estudiante]`: una lista
donde cada elemento es o un estudiante o la queja sobre esa linea. `Main` recorre
los resultados, imprime los `Left` como avisos y se queda con los `Right`:

    Aviso: linea sin formato nombre,nota: lineamalformada
    Estudiantes cargados: 4

El programa sigue trabajando con las lineas validas. Una linea corrupta es un
dato, no un crash.

`reads` es la version segura de `read`: devuelve `[(valor, "")]` solo si la
conversion salio perfecta y no sobro texto. Cualquier otra forma se convierte en
un `Left`.

## Modulos

- `src/Modelo.hs` - tipo `Estudiante` y calculos puros (`promedio`, `aprobados`)
- `src/Persistencia.hs` - `guardarEstudiantes`, `cargarEstudiantes` y el parseo
  puro `parsearLinea`
- `app/Main.hs` - orquesta la carga, la captura de nuevos datos y el guardado

## Nota

`estudiantes.csv` no se versiona: es dato que genera el programa, no codigo.
`doesFileExist` se consulta antes de leer, para que el primer arranque sin
archivo previo no falle.

## Que se aprendio

`Maybe` y `Either` como forma de representar ausencia y error en el sistema de
tipos, separacion entre parseo puro y acceso a archivos, `readFile`/`writeFile`,
y la idea de que un fallo esperado se modela como dato en vez de como excepcion.
