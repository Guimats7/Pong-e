import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KL implements KeyListener {
    private boolean[] keyPressed = new boolean[128];

    @Override
    public void keyTyped(KeyEvent keyEvento) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvento) {
        keyPressed[keyEvento.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent keyEvento) {
        keyPressed[keyEvento.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int KeyCode) {
        return keyPressed[KeyCode];
    }

}
