package main;

import java.awt.Canvas;

import javax.swing.JFrame;

import game.Game;

public class Core {
	public static void main(String[] args) {
		Canvas c= new Canvas();
		JFrame j= new JFrame();
		j.setVisible(true);
		j.setSize(640,640);
		j.add(c);
		j.setLocationRelativeTo(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread t = new Thread();
		new Game(c,j,true,t,0);
	}
}
