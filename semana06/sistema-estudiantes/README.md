# Sistema de Estudiantes (Maven + JUnit)

## Descripcion
Proyecto Maven que implementa un sistema de estudiantes con CRUD, ranking por
promedio y busqueda por codigo, con una suite de pruebas JUnit 5.

## Como ejecutar

    mvn test                 # corre la suite de tests
    mvn clean package        # genera el .jar en target/
    java -jar target/sistema-estudiantes-1.0.0.jar

## Tests incluidos

- `registrarEstudianteNuevoDevuelveTrue` - registro exitoso de un codigo libre
- `registrarCodigoDuplicadoDevuelveFalse` - rechaza un codigo ya usado
- `buscarPorCodigoExistenteDevuelveEstudiante` - busqueda que encuentra
- `buscarPorCodigoInexistenteDevuelveNull` - busqueda que no encuentra
- `actualizarPromedioDeEstudianteExistenteDevuelveTrue` - actualiza y verifica el valor nuevo
- `actualizarPromedioDeEstudianteInexistenteDevuelveFalse` - no actualiza lo que no existe
- `eliminarEstudianteExistenteDevuelveTrueYLoQuitaDelRanking` - elimina de las dos estructuras
- `listarRankingConColeccionVaciaDevuelveListaVacia` - caso borde sin datos
- `listarRankingOrdenaPorPromedioDescendente` - verifica el orden del TreeSet
- `topNConNMayorAlTotalDevuelveTodosSinLanzarExcepcion` - pide mas de los que hay

## Resultado

    Tests run: 10, Failures: 0, Errors: 0

## Que se aprendio

Maven como gestor de dependencias y ciclo de vida, la estructura estandar
src/main/java y src/test/java, JUnit 5 con @Test y @BeforeEach para aislar cada
caso, el scope test para que JUnit no viaje en el jar, y por que importa probar
la coleccion vacia.
