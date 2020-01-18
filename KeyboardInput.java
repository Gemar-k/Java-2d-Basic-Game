import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import constants.Keys;

public class KeyboardInput implements KeyListener{
    public boolean[] pressedKey;
    
    public KeyboardInput(){
        this.pressedKey = new boolean[265];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
        this.pressedKey[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.pressedKey[e.getKeyCode()] = false;
    }
    
    public boolean getKey(Keys key){
        return this.pressedKey[key.getValue()];
    }
}