import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyAdapterClass implements KeyListener {
  public void keyPressed(KeyEvent e) {
    System.out.println("key pressed "+e.getKeyChar());
  }
  public void keyReleased(KeyEvent e) {
    System.out.println("key pressed "+e.getKeyChar());
  }
  public void keyTyped(KeyEvent e) {
    System.out.println("key pressed "+e.getKeyChar());
  }
}
