# Parte2
##  PID y  PPID
### Programa lanzado desde IDE
![Cap1](capturas/Cap1.png)

- PID: 4876
- PPID: 4560
- Se identifica mediante el campo PPID (Parent Process ID), que señala al proceso ejecutor que generó al proceso actual (PID). Por diseño en el sistema operativo, un proceso hijo siempre nace a partir de una llamada emitida por su proceso padre.

Para sacar por windows el comando que me saca PID y el PPID le pregunte a geminis ( pasarme el comando ps -ef | grep InformeSistema para windows)

### Programa lanzado desde Terminal
![Cap2](capturas/Cap2.png)

- PID: 4876
- PPID: 4560

Para ejecutarlo en Windows, le pedí a Gemini que me dijera el comando. (Pasame el comando de compilación y de ejecución en windows usado el ejecutor de IntelliJ)

### ¿Por qué no cambia el PPID?

En mi caso el PPID no cambia y se mantiene siempre en **4560**. Esto ocurre porque no estoy lanzando el programa compilando y ejecutando directamente desde la terminal con el JDK a mano, sino que lo estoy haciendo a través del botón de **Run de IntelliJ**.

Al usar el ejecutor de IntelliJ, el propio IDE crea y mantiene un proceso entorno ("runner") que actúa como el padre de mi programa. Como IntelliJ se queda abierto y ejecutando el proceso en todo momento, ese proceso padre (PID 4560) nunca se cierra ni muere. Al estar el padre siempre activo, el valor del PPID no tiene ninguna razón para cambiar durante la prueba.

### Comparación las cuatro cifras de memoria
