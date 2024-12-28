import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Retangulo {
    public double x, y, width, height;
    public Color cor;

    public Retangulo(double x, double y, double width, double height, Color cor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cor = cor;
    }

    public void desenhar(Graphics2D g2) {
        g2.setColor(cor);
        g2.fill(new Rectangle2D.Double(x, y, width, height));
    }
}
