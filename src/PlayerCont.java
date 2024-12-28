import java.awt.event.KeyEvent;

public class PlayerCont {

    public Retangulo ret;
    public KL keyListener;

    public PlayerCont (Retangulo ret, KL keyListener){
        this.ret = ret;
        this.keyListener = keyListener;
    }

    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_DOWN) || keyListener.isKeyPressed(KeyEvent.VK_S)) {
            if((ret.y + 100 * dt) + ret.height < Constantes.ALTURA_TELA - Constantes.TELA_FUNDO) {
                this.ret.y += (Constantes.VELOCIDADE_P1 * dt);
            }
        }
        else if (keyListener.isKeyPressed(KeyEvent.VK_UP) || keyListener.isKeyPressed(KeyEvent.VK_W)) {
            if(ret.y - 100 * dt > Constantes.TOOLBAR_ALTURA) {
                this.ret.y -= (Constantes.VELOCIDADE_P1 * dt);
            }
        }

    }
}
