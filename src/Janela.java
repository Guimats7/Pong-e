import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;

public class Janela extends JFrame implements Runnable {

    public Graphics2D g2;
    public KL keyListener = new KL();
    public Retangulo playerOne, ai, ball;
    public PlayerCont controlesPlayer;

    public Janela() {
        this.setSize( Constantes.LARGURA_TELA, Constantes.ALTURA_TELA);
        this.setTitle(Constantes.TITULO_TELA);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        Constantes.TOOLBAR_ALTURA = this.getInsets().top;
        Constantes.TELA_FUNDO = this.getInsets().bottom;
        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Retangulo(100, Constantes.ALTURA_TELA / 2, Constantes.LARGURA_P1, Constantes.ALTURA_P1, Constantes.CONST_COR);
        controlesPlayer = new PlayerCont(playerOne, keyListener);
        ai = new Retangulo(Constantes.LARGURA_TELA - 100 - Constantes.LARGURA_AI, Constantes.ALTURA_TELA / 2, Constantes.LARGURA_AI, Constantes.ALTURA_AI, Constantes.CONST_COR);
        ball = new Retangulo(Constantes.LARGURA_TELA / 2, Constantes.ALTURA_TELA / 2, Constantes.LARGURA_BALL, Constantes.ALTURA_BALL, Constantes.CONST_COR);
    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);

        g2.drawImage(dbImage, 0, 0, this);

        controlesPlayer.update(dt);
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

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
        }
    }
}
