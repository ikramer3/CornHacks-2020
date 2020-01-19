package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyWatcher implements KeyListener{
	
	public static boolean leftKeyDown,rightKeyDown,upKeyDown,downKeyDown,spaceKeyDown;
	
	public KeyWatcher() {
		leftKeyDown=false;
		rightKeyDown=false;
		upKeyDown=false;
		downKeyDown=false;
		spaceKeyDown=false;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_UP) {
			upKeyDown=true;
		}
		if(e.getKeyCode()==e.VK_DOWN) {
			downKeyDown=true;
		}
		if(e.getKeyCode()==e.VK_LEFT) {
			leftKeyDown=true;
		}
		if(e.getKeyCode()==e.VK_RIGHT) {
			rightKeyDown=true;
		}
		if(e.getKeyCode()==e.VK_SPACE) {
			spaceKeyDown=true;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==e.VK_UP) {
			upKeyDown=false;
		}
		if(e.getKeyCode()==e.VK_DOWN) {
			downKeyDown=false;
		}
		if(e.getKeyCode()==e.VK_LEFT) {
			leftKeyDown=false;
		}
		if(e.getKeyCode()==e.VK_RIGHT) {
			rightKeyDown=false;
		}	
		if(e.getKeyCode()==e.VK_SPACE) {
			spaceKeyDown=false;
		}
	}
	
}
