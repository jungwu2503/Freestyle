import java.awt.*;

import javax.swing.*;

public class Player extends JPanel { // 
	
	Player() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawRect(10,10,50,50); 
		g.drawRect(50,50,50,50); 
	}

}