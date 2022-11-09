import java.awt.*;
import java.net.*;

import javax.swing.*;

public class DeveloperFrame extends JFrame {
	
	//JPanel dPanel;
	JLabel label;
	JLabel label2;
	JButton urlBtn;
	JButton backBtn;
	ImageIcon img = new ImageIcon(DeveloperFrame.class.getResource("/img/toMainBtn.png"));
	ImageIcon img2 = new ImageIcon(DeveloperFrame.class.getResource("/img/toMainBtn2.png"));
	ImageIcon frameIcon;
	
	DeveloperFrame() {
		/*dPanel = new JPanel();
		dPanel.setPreferredSize(null);		
		dPanel.add(textArea);		
		add(dPanel);*/
		
		frameIcon = new ImageIcon(MainFrame.class.getResource("img/SulIcon.png"));
				
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
		
		label = new JLabel("Developer : SuldenLion");
		label.setBounds(100, 50, 300, 50);
		label.setFont(new Font(null, Font.BOLD, 25));
		
		label2 = new JLabel("<html>�� ���α׷��� ��� �۾��� SuldenLion�� �����Ͽ���.<br>���������� ��ҳ� ������� bgm���� ���� ��Ʈ�� SuldenLion�� ����.<br>�ڵ� �Ƿ��� �����ϹǷ� ���װ� �߰ߵ� �� ����.<br>��Ƽ�÷��� ��峪 �����ͺ��̽� ����ؼ� ������� ������ �����غ��� ���� ��ǥ.<br><br>�� SuldenLion ������ Ȩ������ �湮�ϱ� ��</html>");
		label2.setBounds(90, 70, 300, 300);
		label2.setFont(new Font(null, Font.PLAIN, 15));
		
		urlBtn = new JButton("<html><a href=\"https://jwsite.cf/\" title=\"SuldenLion HomePage �ٷΰ���\">SuldenLion HomePage</a></html>");
		urlBtn.setBounds(90, 335, 300, 40);
		urlBtn.setFocusable(false);
		urlBtn.setToolTipText("SuldenLion Ȩ������ �ٷΰ���");
		urlBtn.addActionListener((e) -> {
			if (e.getSource() == urlBtn) {	
				try {
					URI uri = new URI("https://jwsite.cf/");
					Desktop dt = Desktop.getDesktop();
					dt.browse(uri.resolve(uri));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}			
		}); 
		
		add(backBtn);
		add(label);
		add(label2);
		add(urlBtn);
		setTitle("������ ����");
		setIconImage(frameIcon.getImage());
		getContentPane().setBackground(Color.white);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
}
