import java.awt.*;

public class Main {
    public static void main(String[] args){
        Janela janela = new Janela();
        Thread t1 = new Thread(janela);
        t1.start();
    }
}