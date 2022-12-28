import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.*;

class MagicPanel extends JPanel {
	FunctionPanel functionPanel;
	MagicPanel(FunctionPanel functionPanel) {
		this.functionPanel = functionPanel;
		
		JOptionPane.showMessageDialog(null, "1~64 중 하나의 숫자를 고른 후 그 숫자가 포함된 카드를 선택하시오");
		
		setLayout(new GridLayout(2,3));
		
		JPanel card1Panel = new JPanel();
		card1Panel.setLayout(new BorderLayout());
		card1Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton card1 = new JButton("1번 card");
		card1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionPanel.addField("1");
			}
		});
		JTextArea card1Field = new JTextArea("1 3 5 7 9 11\n13 15 17 19 21 23\n25 27 29 31 33 35\n37 39 41 43 45 47\n49 51 53 55 57 59");
		card1Field.setFont(new Font("Consolas", Font.BOLD, 16));
		card1Field.setEditable(false);
		card1Panel.add(card1, "North");
		card1Panel.add(card1Field, "Center");
		
		JPanel card2Panel = new JPanel();
		card2Panel.setLayout(new BorderLayout());
		card2Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton card2 = new JButton("2번 card");
		card2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionPanel.addField("2");
			}
		});
		JTextArea card2Field = new JTextArea("2 3 6 7 10 11\n14 15 18 19 22 23\n26 27 30 31 34 35\n38 39 42 43 46 47\n50 51 54 55 58 59");
		card2Field.setFont(new Font("Consolas", Font.BOLD, 16));
		card2Field.setEditable(false);
		card2Panel.add(card2, "North");
		card2Panel.add(card2Field, "Center");
		
		JPanel card3Panel = new JPanel();
		card3Panel.setLayout(new BorderLayout());
		card3Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton card3 = new JButton("3번 card");
		card3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionPanel.addField("3");
			}
		});
		JTextArea card3Field = new JTextArea("4 5 6 7 12 13\n14 15 20 21 22 23\n28 29 30 31 36 37\n38 39 44 45 46 47\n52 53 54 55 60");
		card3Field.setFont(new Font("Consolas", Font.BOLD, 16));
		card3Field.setEditable(false);
		card3Panel.add(card3, "North");
		card3Panel.add(card3Field, "Center");
		
		JPanel card4Panel = new JPanel();
		card4Panel.setLayout(new BorderLayout());
		card4Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton card4 = new JButton("4번 card");
		card4.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionPanel.addField("4");
			}
		});
		JTextArea card4Field = new JTextArea("8 9 10 11 12 13\n14 15 24 25 26 27\n28 29 30 31 40 41\n42 43 44 45 46 47\n56 57 58 59 60");
		card4Field.setFont(new Font("Consolas", Font.BOLD, 16));
		card4Field.setEditable(false);
		card4Panel.add(card4, "North");
		card4Panel.add(card4Field, "Center");
		
		JPanel card5Panel = new JPanel();
		card5Panel.setLayout(new BorderLayout());
		card5Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton card5 = new JButton("5번 card");
		card5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionPanel.addField("5");
			}
		});
		JTextArea card5Field = new JTextArea("16 17 18 19 20 21\n22 23 24 25 26 27\n28 29 30 31 48 49\n50 51 52 53 54 55\n56 57 58 59 60");
		card5Field.setFont(new Font("Consolas", Font.BOLD, 16));
		card5Field.setEditable(false);
		card5Panel.add(card5, "North");
		card5Panel.add(card5Field, "Center");
		
		JPanel card6Panel = new JPanel();
		card6Panel.setLayout(new BorderLayout());
		card6Panel.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton card6 = new JButton("6번 card");
		card6.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				functionPanel.addField("6");
			}
		});
		JTextArea card6Field = new JTextArea("32 33 34 35 36 37\n38 39 40 41 42 43\n44 45 46 47 48 49\n50 51 52 53 54 55\n56 57 58 59 60");
		card6Field.setFont(new Font("Consolas", Font.BOLD, 16));
		card6Field.setEditable(false);
		card6Panel.add(card6, "North");
		card6Panel.add(card6Field, "Center");
		
		add(card1Panel);
		add(card2Panel);
		add(card3Panel);
		add(card4Panel);
		add(card5Panel);
		add(card6Panel);
	}
	
}

class FunctionPanel extends JPanel {
	JTextField numField;
	String fieldText;
	JButton okBtn;
	FunctionPanel() {
		numField = new JTextField();
		numField.setPreferredSize(new Dimension(150,30));
		numField.setEditable(false);
		okBtn = new JButton("OK");
		okBtn.addActionListener((e) -> {
			StringTokenizer st = new StringTokenizer(fieldText);
			boolean[] arr = new boolean[6];
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				arr[n-1] = true;
			}
			int ans = 0;
			for (int i = 0; i < 6; i++) {
				if (arr[i]) {
					switch (i) {
						case 0: {
							ans += 1;
							break;
						}
						case 1: {
							ans += 2;
							break;
						}
						case 2: {
							ans += 4;
							break;
						}
						case 3: {
							ans += 8;
							break;
						}
						case 4: {
							ans += 16;
							break;
						}
						case 5: {
							ans += 32;
							break;
						}
					}
				}
			}
			JOptionPane.showMessageDialog(null, "당신이 고른 숫자는 " + ans + "로군요!");
			numField.setText("");
			fieldText = "";
		});
		add(numField);
		add(okBtn);
	}
	
	void addField(String num) {
		if (fieldText == null) fieldText = num;
		else fieldText += " " + num;
		numField.setText(fieldText);
	}
}

public class Select_NumMagic extends CursorSet {
	MagicPanel magicPanel;
	FunctionPanel functionPanel;
	Select_NumMagic() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(650,650);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		functionPanel = new FunctionPanel();
		magicPanel = new MagicPanel(functionPanel);
		getContentPane().add(magicPanel, "Center");
		getContentPane().add(functionPanel, "South");
	}	
}
