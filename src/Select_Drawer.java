import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class Select_Drawer extends CursorSet {
	ImageIcon frameIcon;
	D_DrawerView canvas;
	
	Select_Drawer() {
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
		
		/* Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorImage;
		try {
			cursorImage = ImageIO.read(MainFrame.class.getResource("img/StarArrow.gif"));
			Cursor cursor = tk.createCustomCursor(cursorImage, new Point(0,0), "");
			setCursor(cursor);
		} catch (IOException e1) {
			e1.printStackTrace();
		} */
		
		setIconImage(frameIcon.getImage());
		setTitle("Drawer");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		Container container = this.getContentPane();
		canvas = new D_DrawerView();
		container.add(canvas);
		
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
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		JMenuItem openFile = new JMenuItem("Open File");
		fileMenu.add(openFile);
		openFile.setMnemonic('O');
		openFile.setBackground(Color.white);
		openFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/openFile.png")));
		openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		
		JMenuItem saveFile = new JMenuItem("Save");
		fileMenu.add(saveFile);
		saveFile.setMnemonic('S');
		saveFile.setBackground(Color.white);
		saveFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/saveFile.png")));
		saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));		
		
		JMenuItem saveAsFile = new JMenuItem("Save As");
		fileMenu.add(saveAsFile);
		saveAsFile.setMnemonic('A');
		saveAsFile.setBackground(Color.white);
		saveAsFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/saveAsFile.png")));
		saveAsFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		
		fileMenu.addSeparator();

		JMenuItem printFile = new JMenuItem("Print");
		fileMenu.add(printFile);
		printFile.setMnemonic('P');
		printFile.setBackground(Color.white);
		printFile.setIcon(new ImageIcon(MainFrame.class.getResource("img/printFile.png")));
		printFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));

		fileMenu.addSeparator();
		
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(exit);
		exit.setMnemonic('X');
		exit.setBackground(Color.white);
		exit.setIcon(new ImageIcon(MainFrame.class.getResource("img/exit.png")));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JMenu figureMenu = new JMenu("Figures");
		menus.add(figureMenu);
		
		JMenuItem figureBox = new JMenuItem("Box");
		figureMenu.add(figureBox);
		figureBox.addActionListener((e) -> canvas.selectFigure(D_DrawerView.DRAW_BOX));

		JMenuItem figureLine = new JMenuItem("Line");
		figureMenu.add(figureLine);
		figureLine.addActionListener((e) -> canvas.selectFigure(D_DrawerView.DRAW_LINE));
		
		JMenu toolMenu = new JMenu("Tool");
		menus.add(toolMenu);
		
		JMenuItem modalTool = new JMenuItem("Modal");
		toolMenu.add(modalTool);
		modalTool.addActionListener((e) -> {
			D_FigureDialog dialog = new D_FigureDialog("Figure Dialog", canvas);
			dialog.setModal(true);
			dialog.setVisible(true);
		});

		JMenuItem modalessTool = new JMenuItem("Modaless");
		toolMenu.add(modalessTool);
		modalessTool.addActionListener((e) -> {
			D_FigureDialog dialog = new D_FigureDialog("Figure Dialog", canvas);
			dialog.setModal(false);
			dialog.setVisible(true);
		});
		
		JMenu helpMenu = new JMenu("Help");
		menus.add(helpMenu);
		helpMenu.setMnemonic('H'); 
		
		JMenuItem helpInfo = new JMenuItem("Information");
		helpMenu.add(helpInfo);
		helpInfo.setMnemonic('I'); 
		helpInfo.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null, "SuldenLion's Drawer");
		});
		
	}
}
