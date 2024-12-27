import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Time;

public class Janela extends JFrame implements Runnable {

    Graphics2D g2;
    KL keyListener = new KL();
    Retangulo playerOne, ai, ball;

    public Janela() {
        this.setSize( Constantes.LARGURA_TELA, Constantes.ALTURA_TELA);
        this.setTitle(Constantes.TITULO_TELA);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Retangulo(100, Constantes.ALTURA_TELA / 2, Constantes.LARGURA_P1, Constantes.ALTURA_P1, Constantes.CONST_COR);
        ai = new Retangulo(Constantes.LARGURA_TELA - 100 - Constantes.LARGURA_AI, Constantes.ALTURA_TELA / 2, Constantes.LARGURA_AI, Constantes.ALTURA_AI, Constantes.CONST_COR);
        ball = new Retangulo(Constantes.LARGURA_TELA / 2, Constantes.ALTURA_TELA / 2, Constantes.LARGURA_BALL, Constantes.ALTURA_BALL, Constantes.CONST_COR);
    }

    public void update(double dt) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constantes.LARGURA_TELA, Constantes.ALTURA_TELA);

        playerOne.desenhar(g2);
        ai.desenhar(g2);
        ball.desenhar(g2);
    }

    public void run() {
        double ultimoFrameTempo = 0.0;
        while (true){
            double tempo = Tempo.getTempo();
            double deltaTempo = tempo - ultimoFrameTempo;
            ultimoFrameTempo = tempo;

            update(deltaTempo);

            try {
                Thread.sleep((long) 7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
