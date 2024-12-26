import javax.swing.JFrame;

public class Janela extends JFrame implements Runnable {

    public Janela() {
        this.setSize(800, 600);
        this.setTitle("Ponge");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        while (true){
            //do whatever
        }
    }
}
