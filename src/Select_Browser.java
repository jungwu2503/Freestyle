import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class Select_Browser extends CursorSet {
	ImageIcon frameIcon;
	JTextField url;
	JButton loadBtn;
	JButton backBtn;
	Stack urlStack = new Stack();
	JEditorPane editorPane;
	JCheckBox editable;
	
	Select_Browser() {
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
		
		setIconImage(frameIcon.getImage());
		setTitle("Browser");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		url = new JTextField(30);
		
		loadBtn = new JButton("Load");
		loadBtn.addActionListener((e) -> {
			try {
				urlStack.push(url.getText());
				
				editorPane.setPage(url.getText());
			} catch (IOException ex) {
				editorPane.setText("Error: " + ex);
			}
		});
		
		backBtn = new JButton("Back");
		backBtn.addActionListener((e) -> {
			if (urlStack.size() <= 1) return;
			try {
				urlStack.pop();
				
				String urlString = (String)urlStack.peek();
				url.setText(urlString);
				
				editorPane.setPage(urlString);
			} catch (IOException ex) {
				editorPane.setText("Error: " + ex);
			}
		});
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent event) {
				if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					try {
						urlStack.push(event.getURL().toString());
						url.setText(event.getURL().toString());
						editorPane.setPage(event.getURL());
					} catch (IOException ex) {
						editorPane.setText("Error: " + ex);					
					}
				}
			}
		});
		
		editable = new JCheckBox();
		editable.addActionListener((e) -> {
			editorPane.setEditable(editable.isSelected());
		});
		
		Container contentPane = getContentPane();
		contentPane.add(new JScrollPane(editorPane), "Center");
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("URL:"));
		panel.add(url);
		panel.add(loadBtn);
		panel.add(backBtn);
		panel.add(new JLabel("Editable"));
		panel.add(editable);
		
		contentPane.add(panel, "South");
	}
	
}
