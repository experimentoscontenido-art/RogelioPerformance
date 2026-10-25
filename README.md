# Rogelio Performance — base de diagnóstico 0.1.0

Proyecto inicial para Minecraft Java 1.21.11 + Fabric Loader 0.19.3, compilado con Java 21.

## Importante
Esta primera base **no promete aumentar los FPS**. Su objetivo es recopilar muestras de FPS y memoria Java cada ~5 segundos mientras estás en un mundo. No modifica el renderizado ni los datos del mundo, y está pensada para obtener una medición inicial antes de introducir optimizaciones específicas para el cuello de botella real.

## Compilación automática en GitHub (sin instalar herramientas localmente)
1. Crear un repositorio nuevo en GitHub llamado `RogelioPerformance`.
2. Subir el contenido de esta carpeta al repositorio (incluida la carpeta oculta `.github/workflows`).
3. Abrir la pestaña **Actions** y habilitar los workflows si GitHub lo solicita.
4. Ejecutar **Build Rogelio Performance** con **Run workflow**, o hacer un commit/push.
5. Abrir la ejecución que termine con un check verde y descargar el artefacto `rogelio-performance-jar`.
6. Descomprimir el artefacto y copiar el `.jar` a `%AppData%\.minecraft\mods`.

## Dónde mirar las métricas
Tras ejecutar Minecraft y entrar en un mundo, las muestras aparecen en `.minecraft/logs/latest.log` con el texto `[RP-METRICS]`.

## Siguiente etapa
Comparar una misma ruta con y sin Voxy (misma distancia, ajustes, clima y posición inicial). Estas muestras son solo una referencia sencilla; para medir los tirones conviene además observar el F3 y repetir la ruta. Las optimizaciones posteriores deben dirigirse al cuello de botella detectado y probarse por separado.
