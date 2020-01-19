package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyWatcher implements KeyListener{
	static StringBuilder sb=new StringBuilder();
	
	public static boolean leftKeyDown,
		rightKeyDown,
		upKeyDown,
		downKeyDown,
		spaceKeyDown,
		oneDown,
		twoDown,
		threeDown,
		fourDown,
		fiveDown,
		sixDown,
		sevenDown,
		eightDown,
		nineDown;
	
	public KeyWatcher() {
		leftKeyDown=false;
		rightKeyDown=false;
		upKeyDown=false;
		downKeyDown=false;
		spaceKeyDown=false;
		oneDown=false;
		twoDown=false;
		threeDown=false;
		fourDown=false;
		fiveDown=false;
		sixDown=false;
		sevenDown=false;
		eightDown=false;
		nineDown=false;
		
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
		if(e.getKeyCode()==e.VK_1) {
			oneDown=true;
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
		if(e.getKeyCode()==e.VK_1) {
			oneDown=false;
		}
	}
	public String getInput() {
		if(oneDown) {
			sb.append("1");
		}
		return sb.toString();
	}
	public static void resetInput() {
		sb=new StringBuilder();
	}
	
}
