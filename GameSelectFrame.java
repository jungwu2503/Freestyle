import java.awt.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.*;

/*class ButtonMenuCellRenderer extends DefaultTableCellRenderer {
	
	class ButtonMenuCell extends JPanel {
		
		ButtonMenuCell(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
			
		}
	
		public void paintComponent(Graphics g) {
			
		}
	}
	
	//MenuModel model;
	//MenuNameCellRenderer(MenuModel model) {
	//	this.model = model;
	//}
	
	public Component getTableCellRendererComponent(JTable table, 
			Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		if (col == 1) {
			return new ButtonMenuCell(table, value, isSelected, hasFocus, row, col);
		} else {
			Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
			return cell;
		}
	}
	
}

class MenuModel extends AbstractTableModel {

	
	
	ArrayList<JButton> list = new ArrayList<JButton>();
	
	MenuModel() {
		
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
	//MenuModel model;
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
		
		tablePanel = new JPanel(new GridLayout(3, 3, 30, 30));
		tablePanel.setBackground(Color.green);
		tablePanel.setPreferredSize(new Dimension(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT));
		
		//table = new JTable(model = new MenuModel());
		//JScrollPane sp = new JScrollPane(table);
		//table.setDefaultRenderer(JButton.class, new ButtonMenuCellRenderer());
		
		JButton digitalClockBtn = new JButton("DigitalClock");
		digitalClockBtn.addActionListener((e) -> {
			Select_DigitalClock frame = new Select_DigitalClock();
			frame.setVisible(true);
		});
		tablePanel.add(digitalClockBtn);
		JButton analogClockBtn = new JButton("AnalogClock");
		analogClockBtn.addActionListener((e) -> {
			JFrame frame = new Select_AnalogClock();
			frame.setVisible(true);
		});
		tablePanel.add(analogClockBtn);
		JButton calculatorBtn = new JButton("Calculator");
		tablePanel.add(calculatorBtn);
		calculatorBtn.addActionListener((e) -> {
			Select_Calculator frame = new Select_Calculator();
			frame.setVisible(true);
		});
		JButton calendarBtn = new JButton("Calendar");
		tablePanel.add(calendarBtn);
		JButton mailBtn = new JButton("메일보내기");
		tablePanel.add(mailBtn);
		JButton browserBtn = new JButton("브라우저 띄우기(Only Html)");
		tablePanel.add(browserBtn);
		browserBtn.addActionListener((e) -> {
			Select_Browser frame = new Select_Browser();
			frame.setVisible(true);
		});
		JButton quizBtn = new JButton("Quiz");
		tablePanel.add(quizBtn);
		quizBtn.addActionListener((e) -> {
			Select_Quiz frame = new Select_Quiz();
			frame.setVisible(true);
		});
		JButton drawerBtn = new JButton("Drawer");
		tablePanel.add(drawerBtn);
		drawerBtn.addActionListener((e) -> {
			Select_Drawer frame = new Select_Drawer();
			frame.setVisible(true);
		});
		JButton chattingBtn = new JButton("Chatting");
		tablePanel.add(chattingBtn);
		JButton horseBtn = new JButton("Horse");
		tablePanel.add(horseBtn);
		JButton ladderBtn = new JButton("사다리");
		tablePanel.add(ladderBtn);
		JButton rhythmBtn = new JButton("Rhythm");
		tablePanel.add(rhythmBtn);
		JButton snakeBtn = new JButton("Snake");
		tablePanel.add(snakeBtn);	
		JButton planeBtn = new JButton("전투기");
		tablePanel.add(planeBtn);	
		JButton mineBtn = new JButton("Mines");
		tablePanel.add(mineBtn);	
		
		add(titlePanel, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		
		setTitle("Select Menu");
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
