import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.*;

/*
class ButtonsModel extends AbstractTableModel {

	ArrayList<JButton> list = new ArrayList<JButton>();
	
	ButtonsModel() {
		
	}
	
	@Override
	public int getRowCount() {		
		return 5;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	
}*/

public class GameSelectFrame extends JFrame {

	ImageIcon frameIcon;
	ImageIcon menuTitleImg;
	File mainBgmFile;
	Clip mainBgmClip;
	JPanel titlePanel;
	JPanel tablePanel;
	JTable table;
	//ButtonsModel model;
	JButton[] buttons;

	public GameSelectFrame() {
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));	
		menuTitleImg = new ImageIcon(MainFrame.class.getResource("img/menuTitleImg.png"));	
		
		titlePanel = new JPanel() {
			Image img = menuTitleImg.getImage();
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
		};		
		titlePanel.setPreferredSize(new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT/7));
		
		tablePanel = new JPanel();
		tablePanel.setBackground(Color.white);
		tablePanel.setPreferredSize(new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT));
		
		//table = new JTable(model = new ButtonsModel());
		//table.setDefaultRenderer(JButton.class, null)
		JButton btn = new JButton("koko");
		//add(tablePanel, new GridLayout(5, 3)); 이딴식으로 못쓰는듯
		/*buttons = new JButton[15];
		for (int i = 0; i < 15; i++) {
			tablePanel.add(buttons[i]);
		}*/
		
		add(titlePanel, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		
		setIconImage(frameIcon.getImage());
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
