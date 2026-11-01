package com.juniverse.fibonacci;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Panel Swing que genera la serie de Fibonacci y la dibuja como un gráfico de barras
 * cuya altura es proporcional a cada término.
 *
 * @author linux
 */
public class FibonacciGraphics extends JPanel {

    /** Con {@code long} el término 92 es el último que no desborda. */
    private static final int MAX_TERMS = 92;

	/** Lista donde se guarda la serie. */
    private final List<Long> fibonacciSeries;

    /**
     * Crea el panel con los primeros {@code max} términos.
     * @param max cantidad de términos (entre 2 y 92)
     * @throws IllegalArgumentException si {@code max} está fuera de rango
     */
    public FibonacciGraphics(int max) {
        if (max < 2 || max > MAX_TERMS) {
            throw new IllegalArgumentException("La cantidad de términos debe estar entre 2 y " + MAX_TERMS);
        }
        this.fibonacciSeries = generateFibonacci(max);
    }

    /** Crea el panel con 30 términos. */
    public FibonacciGraphics() {
        this(30);
    }

    /**
     * Devuelve la serie generada.
     * @return lista de términos, empezando por 0 y 1
     */
    public List<Long> getFibonacciSeries() {
        return fibonacciSeries;
    }

    /**
     * Genera la serie sumando los dos términos anteriores.
     * @param max cantidad de términos
     * @return lista con los {@code max} primeros términos
     */
    private List<Long> generateFibonacci(int max) {
        List<Long> series = new ArrayList<>();
        series.add(0L);
        series.add(1L);
        for (int i = 2; i < max; i++) {
            series.add(series.get(i - 1) + series.get(i - 2));
        }
        return series;
    }

    /** Dibuja una barra por término, escalada al valor máximo, con su valor encima. */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / fibonacciSeries.size();
        long max = fibonacciSeries.stream().max(Long::compareTo).orElse(1L);

        g2d.setBackground(Color.BLACK);
        g2d.clearRect(0, 0, width, height);

        g2d.setColor(Color.BLUE);
        for (int i = 0; i < fibonacciSeries.size(); i++) {
            long value = fibonacciSeries.get(i);
            int barHeight = (int) ((double) value / max * (height - 50));
            g2d.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
            g2d.drawString(String.valueOf(value), i * barWidth, height - barHeight - 5);
        }
    }

    /**
     * Crea y muestra la ventana con este panel, centrada en la pantalla.
     * @param width ancho en píxeles
     * @param height alto en píxeles
     */
    public void createWindow(int width, int height) {
        JFrame frame = new JFrame("Fibonacci");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.add(this);
        frame.setVisible(true);
        setLocationCenter(frame);
    }

    /** Centra la ventana en la pantalla. */
    private void setLocationCenter(JFrame frame) {
        setLocationMove(frame, 0, 0);
    }

    /**
     * Coloca la ventana centrada y la desplaza el valor indicado.
     * @param frame ventana a mover
     * @param moveWidth desplazamiento horizontal en píxeles
     * @param moveHeight desplazamiento vertical en píxeles
     */
    private void setLocationMove(JFrame frame, int moveWidth, int moveHeight) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        frameSize.width = frameSize.width > screenSize.width ? screenSize.width : frameSize.width;
        frameSize.height = frameSize.height > screenSize.height ? screenSize.height : frameSize.height;
        frame.setLocation((screenSize.width - frameSize.width) / 2 + moveWidth, (screenSize.height - frameSize.height) / 2 + moveHeight);
    }
}
