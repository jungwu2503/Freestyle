import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;
import javax.swing.*;

public class GameFrame extends JFrame {

	ImageIcon frameIcon;
	File mainBgmFile;
	Clip mainBgmClip;
	Player player;
	
	Game game = new Game();
	
	GameFrame() {
		
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
		
		//setContentPane(player);
		
		setTitle("SuldenLion Game");
		setIconImage(frameIcon.getImage());
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		audioOn();
		
		init();
	}
	
	public void init() {
		addKeyListener(new KeyListener());
	}
	
	class KeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}
	
	public void paint(Graphics g) {
		screenDraw(g);
	}
	
	public void screenDraw(Graphics g) {
		game.gameDraw(g);
		repaint();
	}
	
	public void audioOn() {
		try {
			mainBgmFile = new File("SuldenBeat2.wav");
			mainBgmClip = AudioSystem.getClip();
			mainBgmClip.open(AudioSystem.getAudioInputStream(mainBgmFile));
			mainBgmClip.loop(Clip.LOOP_CONTINUOUSLY);
			mainBgmClip.start();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void audioOff() {
		mainBgmClip.stop();
	}
	
}
