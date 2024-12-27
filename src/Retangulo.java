import java.awt.Graphics2D;
import java.awt.Color;

public class Retangulo {
    private int x, y, width, height;
    private Color cor;

    public Retangulo(int x, int y, int width, int height, Color cor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cor = cor;
    }

    public void desenhar(Graphics2D g2) {
        g2.setColor(cor);
        g2.fillRect(x, y, width, height);
    }
}
