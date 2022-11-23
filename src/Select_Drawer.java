import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Select_Drawer extends JFrame {
	ImageIcon frameIcon;
	
	Select_Drawer() {
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
		
		setIconImage(frameIcon.getImage());
		setTitle("Drawer");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JMenuBar menus = new JMenuBar();
		setJMenuBar(menus);
		
		JMenu fileMenu = new JMenu("File");
		menus.add(fileMenu);
		fileMenu.setMnemonic('F');
		
		JMenuItem newFile = new JMenuItem("New File");
		fileMenu.add(newFile);
		newFile.setMnemonic('N');
		newFile.setBackground(Color.white);
		newFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/newFile.png")));
		
		JMenuItem openFile = new JMenuItem("Open File");
		fileMenu.add(openFile);
		openFile.setMnemonic('O');
		openFile.setBackground(Color.white);
		openFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/openFile.png")));
		
		JMenuItem saveFile = new JMenuItem("Save");
		fileMenu.add(saveFile);
		saveFile.setMnemonic('S');
		
		JMenuItem saveAsFile = new JMenuItem("Save As");
		fileMenu.add(saveAsFile);
		saveAsFile.setMnemonic('A');

		JMenuItem printFile = new JMenuItem("Print");
		fileMenu.add(printFile);
		printFile.setMnemonic('P');

		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		exit.setMnemonic('X');
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
}
