import java.awt.*;

public class Game extends Thread {
	
	int playerX, playerY;
	
	@Override
	public void run() {
		
	}
	
	public void reset() {
		
		//playerX = 100;
		//playerY = 300;
	}
	
	public void gameDraw(Graphics g) {
		playerDraw(g);
	}
	
	public void playerDraw(Graphics g) {
		g.drawOval(50, 250, 40, 40);
		g.drawLine(70, 290, 70, 340);
		g.drawLine(70, 290, 90, 310);
		g.drawLine(50, 310, 70, 290);
		g.drawLine(70, 340, 90, 360);
		g.drawLine(70, 340, 50, 360);
	}

}
