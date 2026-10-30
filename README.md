# Fibonacci gráfico

Genera la serie de Fibonacci y la muestra en una ventana Swing como un gráfico de barras, donde la altura de cada barra es proporcional al término.

## Características

- Serie de Fibonacci con aritmética `long` (hasta 92 términos sin desbordar).
- Gráfico de barras con el valor de cada término.
- Ventana centrada en la pantalla.

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java
```

## Estructura

```text
src/main/java/com/juniverse/fibonacci/
├── Main.java               # punto de entrada
└── FibonacciGraphics.java  # cálculo y dibujo
```

## Notas

- Requiere un entorno con pantalla (usa Swing).
- El número de términos se cambia en `new FibonacciGraphics(n)`.

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-fibonacci-1.0.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.
