module Persistencia
  ( guardarEstudiantes
  ) where

import Modelo (Estudiante)

-- Convierte un Estudiante a una linea de texto "nombre,nota"
formatearLinea :: Estudiante -> String
formatearLinea (nombre, nota) = nombre ++ "," ++ show nota

guardarEstudiantes :: FilePath -> [Estudiante] -> IO ()
guardarEstudiantes ruta estudiantes =
  writeFile ruta (unlines (map formatearLinea estudiantes))
