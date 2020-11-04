package gradiente;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

/**
 *
 * @author pablo
 */
public class Window extends JPanel {
    private final int WIDTH = 100, HEIGHT = 170;
    private JFrame ventana;
    private Container contenedor;

    public Window() {
        ventana = new JFrame("Gradiente");

        configureWindow();
        configureContainer();
        this.setBackground(Color.decode("#ECF87F"));
    }

    private void configureContainer() {
        contenedor = ventana.getContentPane();
        contenedor.setSize(WIDTH, HEIGHT);
        contenedor.add(this, BorderLayout.CENTER);
    }

    private void configureWindow() {
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setSize(WIDTH, HEIGHT);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        GradientPaint aciclico = new GradientPaint(
            0, 0,
            Color.BLUE,
            100, 0,
            Color.RED
        );
        g.setPaint(aciclico);
        g.fillRect(0, 0, 100, 40);

        GradientPaint ciclico = new GradientPaint(
            0, 50,
            Color.BLUE,
            20, 50,
            Color.RED,
            true
        );
        g.setPaint(ciclico);
        g.fillRect(0, 50, 100, 40);

        GradientPaint transparente = new GradientPaint(
            0, 50,
            new Color(191, 0, 255, 50), // Violeta
            20, 50,
            new Color(0, 191, 255, 50), // Azul
            true
        );
        g.setPaint(transparente);
        g.fillRect(0, 100, 100, 40);
    }
}
