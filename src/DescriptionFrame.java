import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class DescriptionFrame extends JFrame {

	//JPanel dPanel;
	JLabel label;
	ImageIcon frameIcon;
	JButton backBtn;
	ImageIcon img = new ImageIcon(DeveloperFrame.class.getResource("/img/toMainBtn.png"));
	ImageIcon img2 = new ImageIcon(DeveloperFrame.class.getResource("/img/toMainBtn2.png"));
	
	DescriptionFrame() {
		setSize(500,500); // <- �̰� �������� �ھƼ� Panel ���� ����;
		
		frameIcon = new ImageIcon(DescriptionFrame.class.getResource("img/SulIcon.png"));
		
		backBtn = new JButton(img);
		backBtn.setRolloverIcon(img2);
		backBtn.setBorderPainted(false);
		//backBtn.setPreferredSize(getSize());
		backBtn.setBounds(10, 10, 50, 50);
		backBtn.addActionListener((e) -> {
			if (e.getSource() == backBtn) {
				dispose();
				MainFrame mainFrame = new MainFrame();
			}
		});
		
		//dPanel = new JPanel();
		//dPanel.setBackground(Color.white);
		
		label = new JLabel("<html>SpaceBar = ����<br>���ƿ��� ��ֹ����� ���� ��Ƴ�������!<br>������ ���� �� �����ڸ� ��ڰ� ������ּ���!</html>");
		label.setFont(new Font(null, Font.PLAIN, 20));		
		//label.setBounds(30, 30, 20, 20);
		label.setLocation(50, 200);
		//dPanel.add(label);
		
		add(backBtn);
		add(label);
		//add(dPanel);
		getContentPane().setBackground(Color.white);
		setTitle("���� ����");
		setIconImage(frameIcon.getImage());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
	}
	
}
