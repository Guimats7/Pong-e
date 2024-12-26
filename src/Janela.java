import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Time;

public class Janela extends JFrame implements Runnable {

    Graphics2D g2;
    KL keyListener = new KL();

    public Janela() {
        this.setSize( Constantes.LARGURA_TELA, Constantes.ALTURA_TELA);
        this.setTitle(Constantes.TITULO_TELA);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();
    }

    public void update(double dt) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constantes.LARGURA_TELA, Constantes.ALTURA_TELA);
        if ((keyListener.isKeyPressed(KeyEvent.VK_UP))||((keyListener.isKeyPressed(KeyEvent.VK_W)))){
            System.out.println("user is pressing up");
        } else if ((keyListener.isKeyPressed(KeyEvent.VK_DOWN))||((keyListener.isKeyPressed(KeyEvent.VK_S)))) {
            System.out.println("user is pressing down");
        } else if ((keyListener.isKeyPressed(KeyEvent.VK_RIGHT))||((keyListener.isKeyPressed(KeyEvent.VK_D)))) {
            System.out.println("user is pressing right");
        } else if ((keyListener.isKeyPressed(KeyEvent.VK_LEFT))||((keyListener.isKeyPressed(KeyEvent.VK_A)))) {
            System.out.println("user is pressing left");
        }
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
