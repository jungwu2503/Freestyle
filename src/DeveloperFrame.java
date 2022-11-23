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
		
		label2 = new JLabel("<html>위 프로그램의 모든 작업은 SuldenLion이 수행하였음.<br>디자인적인 요소나 심지어는 bgm으로 사용된 비트도 SuldenLion이 제작.<br>코딩 실력이 부족하므로 버그가 발견될 수 있음.<br>멀티플레이 모드나 데이터베이스 사용해서 기록저장 같은걸 구현해보는 것이 목표.<br><br>↓ SuldenLion 개발자 홈페이지 방문하기 ↓</html>");
		label2.setBounds(90, 70, 300, 300);
		label2.setFont(new Font(null, Font.PLAIN, 15));
		
		urlBtn = new JButton("<html><a href=\"https://jwsite.cf/\" title=\"SuldenLion HomePage 바로가기\">SuldenLion HomePage</a></html>");
		urlBtn.setBounds(90, 335, 300, 40);
		urlBtn.setFocusable(false);
		urlBtn.setToolTipText("SuldenLion 홈페이지 바로가기");
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
		setTitle("개발자 정보");
		setIconImage(frameIcon.getImage());
		getContentPane().setBackground(Color.white);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
}
