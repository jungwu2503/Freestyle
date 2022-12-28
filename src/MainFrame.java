import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends CursorSet {

	JButton newWindowBtn;
	JButton descriptionBtn;
	JButton developerInfo;
	JLabel imgLabel;
	ImageIcon imageIcon;
	ImageIcon frameIcon;
	LineBorder lb;
	File mainBgmFile;
	Clip mainBgmClip;
	boolean isBgmOn;
	
	MainFrame() {
		imageIcon = new ImageIcon(MainFrame.class.getResource("img/GUIsuldenlion.png"));
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
		 
		imgLabel = new JLabel(imageIcon);
		imgLabel.setBounds(70, 60, 350, 200);
		
		newWindowBtn = new JButton("���� ����");
		newWindowBtn.setBounds(140, 280, 200, 80);
		newWindowBtn.setFont(new Font(null, Font.BOLD, 30));
		newWindowBtn.setFocusable(false);
		lb = new LineBorder(Color.blue, 3);
		newWindowBtn.setBorder(lb);
		newWindowBtn.addActionListener((e) -> {
			if (e.getSource() == newWindowBtn) {
				dispose();
				audioOff();
				GameSelectFrame gsf = new GameSelectFrame();
				gsf.setVisible(true);
			}
		});
		
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (!isBgmOn && e.getKeyCode() == KeyEvent.VK_1) {
					audioOn();
				}
				if (isBgmOn && e.getKeyCode() == KeyEvent.VK_2) {
					audioOff();
				}
			}
		});
		
		descriptionBtn = new JButton("���� ����");
		descriptionBtn.setBounds(140, 375, 200, 25);
		descriptionBtn.setFont(new Font(null, Font.ITALIC, 20));
		descriptionBtn.setFocusable(false);
		descriptionBtn.setBorderPainted(false);
		descriptionBtn.setContentAreaFilled(false);
		descriptionBtn.addActionListener((e) -> {
			if (e.getSource() == descriptionBtn) {
				dispose();
				audioOff();
				DescriptionFrame df = new DescriptionFrame();
			}
		});
		
		developerInfo = new JButton("������ ����");
		developerInfo.setBounds(140, 405, 200, 25);
		developerInfo.setFont(new Font(null, Font.ITALIC, 17));
		developerInfo.setFocusable(false);
		developerInfo.setBorderPainted(false);
		developerInfo.setContentAreaFilled(false);
		developerInfo.addActionListener((e) -> {
			if (e.getSource() == developerInfo) {
				dispose();
				audioOff();
				DeveloperFrame df = new DeveloperFrame();
			}
		});
		
		//add(imgLabel);
		getContentPane().add(imgLabel);
		add(newWindowBtn);
		add(descriptionBtn);
		add(developerInfo);
		
		setTitle("SuldenLion�� Freestyle GUI ����");
		setIconImage(frameIcon.getImage());
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		
		audioOn();
	}
	
	public void audioOn() {
		try {
			mainBgmFile = new File("SuldenBeat.wav");
			mainBgmClip = AudioSystem.getClip();
			mainBgmClip.open(AudioSystem.getAudioInputStream(mainBgmFile));
			mainBgmClip.loop(Clip.LOOP_CONTINUOUSLY);
			mainBgmClip.start();
			isBgmOn = true;
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void audioOff() {
		mainBgmClip.stop();
		isBgmOn = false;
	}
	
	public boolean getIsBgmOn() {
		return isBgmOn;
	}
	
}
