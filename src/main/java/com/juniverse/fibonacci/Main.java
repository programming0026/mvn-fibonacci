package com.juniverse.fibonacci;

/**
 * Abre una ventana con el gráfico de barras de los primeros 30 números de Fibonacci.
 *
 * @author linux
 */
public class Main {

    /**
     * Punto de entrada.
     * @param args no se usan
     */
    public static void main(String[] args) {
        FibonacciGraphics fg = new FibonacciGraphics();
        fg.createWindow(800, 600);
    }
}
