package input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import main.APP_STATE;
import main.Menu;
import main.Points;

public class MouseWatcher implements MouseListener{
	Button gameButton,dataButton,backButton,enterDataButton,noPlayButton;
	JTextField jtx = new JTextField();
	public MouseWatcher(Button gameButton,Button dataButton,Button backButton,Button enterDataButton,Button noPlayButton) {
		this.gameButton=gameButton;
		this.dataButton=dataButton;
		this.backButton=backButton;
		this.enterDataButton=enterDataButton;
		this.noPlayButton=noPlayButton;		
	}


	///we need this boi

	public void mousePressed(MouseEvent e) {
		if(Menu.appState==APP_STATE.NO_PLAY) {
			if(mouseClickInsideButton(e,noPlayButton)) {
				Menu.appState=APP_STATE.MAIN_MENU;
			}
		}
		if(Menu.appState==APP_STATE.MAIN_MENU) {
			if(mouseClickInsideButton(e,gameButton)) {
				if(Menu.numOfSpendablePoints < 100) {
					Menu.appState=APP_STATE.NO_PLAY;
				}
				else {
					Menu.numOfSpendablePoints -= 100;
					Menu.appState=APP_STATE.GAME_TEE_HEE;
					Points.fileOutput(Menu.gramsSaved, Points.getMPG(), Menu.numOfSpendablePoints);
					Menu.game.init();
				}
			} else if(mouseClickInsideButton(e, dataButton)) {
				Menu.appState=APP_STATE.DATA_ENTRY;
				KeyWatcher.resetInput();
			}
		}else if(Menu.appState==APP_STATE.DATA_ENTRY) {
			if(mouseClickInsideButton(e,backButton)) {
				Menu.appState=APP_STATE.MAIN_MENU;
			}
		}
	}
	public boolean mouseClickInsideButton(MouseEvent e,Button b) {
		if(e.getX()>b.getX()&&e.getX()<b.getX()+b.getW()) {
			if(e.getY()>b.getY()&&e.getY()<b.getY()+b.getH()) {
				return true;
			}
		}
		return false;
	}
	public String getInput() {
		return "sdfsd";
	}


	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
