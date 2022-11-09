import java.awt.*;
import java.io.*;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {

	JButton newWindowBtn;
	JButton descriptionBtn;
	JButton developerInfo;
	JLabel imgLabel;
	ImageIcon imageIcon;
	ImageIcon frameIcon;
	LineBorder lb;
	//EmptyBorder eb;
	File mainBgmFile;
	Clip mainBgmClip;
	//FileInputStream fis; 
	
	MainFrame() {
		
		//imgLabel = new JLabel(new Icon("../img/suldenlion.jpeg", 30));
		//image = Toolkit.getDefaultToolkit().getImage("suldenlion.jpeg");
		imageIcon = new ImageIcon(MainFrame.class.getResource("img/GUIsuldenlion.png"));
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
		 
		imgLabel = new JLabel(imageIcon);
		imgLabel.setBounds(70, 60, 350, 200);
		//imgLabel.setPreferredSize(new Dimension(100, 100));
		//imgLabel.setLocation(50, 50);
		
		newWindowBtn = new JButton("게임 시작");
		//newWindowBtn.setSize(200, 150);
		newWindowBtn.setBounds(140, 280, 200, 80);
		newWindowBtn.setFont(new Font(null, Font.BOLD, 30));
		newWindowBtn.setFocusable(false);
		lb = new LineBorder(Color.blue, 3);
		newWindowBtn.setBorder(lb);
		newWindowBtn.addActionListener((e) -> {
			if (e.getSource() == newWindowBtn) {
				dispose();
				audioOff();
				// <게임 프레임 만들기>
			}
		});
		
		descriptionBtn = new JButton("게임 설명");
		descriptionBtn.setBounds(140, 375, 200, 25);
		descriptionBtn.setFont(new Font(null, Font.ITALIC, 20));
		descriptionBtn.setFocusable(false);
		descriptionBtn.setBorderPainted(false);
		descriptionBtn.setContentAreaFilled(false);
		/*eb = new EmptyBorder(5,3,5,3);
		descriptionBtn.setBorder(eb);*/	
		descriptionBtn.addActionListener((e) -> {
			if (e.getSource() == descriptionBtn) {
				dispose();
				audioOff();
				DescriptionFrame df = new DescriptionFrame();
			}
		});
		
		developerInfo = new JButton("개발자 정보");
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
		
		setTitle("SuldenLion의 Freestyle GUI 게임");
		setIconImage(frameIcon.getImage());
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		//setLayout(new BorderLayout());
		//add(newWindowBtn, BorderLayout.CENTER);
		setVisible(true);
		
		audioOn();
	}
	
	public void audioOn() {
		try {
			mainBgmFile = new File("SuldenBeat.wav");
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
