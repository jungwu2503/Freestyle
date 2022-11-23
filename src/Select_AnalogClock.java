import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Select_AnalogClock extends JFrame {
	Container contentPane;
	
	Select_AnalogClock() {
		setTitle("Clock");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		contentPane = getContentPane();
		
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(650, 650);
		setVisible(true);
	}
	
	class MyPanel extends JPanel implements Runnable {
		int ox, oy, r;
		Calendar cal;
		
		public MyPanel() {
			setBackground(Color.white);
			ox = oy = 300;
			r = 200;
			Thread t = new Thread(this);
			t.start();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			cal = Calendar.getInstance();
			int sec = cal.get(Calendar.SECOND);
			int min = cal.get(Calendar.MINUTE);
			int hour = cal.get(Calendar.HOUR);
			int millis = cal.get(Calendar.MILLISECOND);
			
			g.setColor(Color.blue);
			g.drawOval(100, 100, 400, 400);
			g.setColor(Color.red);
			int j = 1;
			for (int i = 0 ; i <= 360; i += 6) {
				int x1 = (int) (r * Math.sin(Math.PI * i / 180) + ox);
				int y1 = (int) (r * Math.cos(Math.PI * i / 180) + oy);
				int x2 = (int) ((r-5) * Math.sin(Math.PI * i / 180) + ox);
				int y2 = (int) ((r-5) * Math.cos(Math.PI * i / 180) + oy);
				int x3 = (int) ((r-5) * Math.sin(Math.PI * i / 180) + ox);
				int y3 = (int) ((r-5) * Math.cos(Math.PI * i / 180) + oy);
				
				if (i % 30 == 0) {
					//int j = 1;
					x2 = (int) ((r - 20) * Math.sin(Math.PI * i / 180) + ox);
					y2 = (int) ((r - 20) * Math.cos(Math.PI * i / 180) + oy);
				}
				g.drawLine(x1, y1, x2, y2);
				
				if (i % 30 == 0) {
					x3 = (int) ((r + 20) * Math.sin(Math.PI * i / 180) + ox);
					y3 = (int) ((r + 20) * -Math.cos(Math.PI * i / 180) + oy);
					if (j <= 12) g.drawString(""+(j++-1), x3, y3);
				}
				
			}			
			
			if (sec == 60) {
				sec = 0;
				min++;
			}
			if (min == 60) {
				min = 0;
				hour++;
			}
			if (min == 60 && hour == 12) {
				hour = 0;
			}
			
			sec = sec * 6 - 90;
			int xSecond = (int) (r * Math.cos(Math.PI * sec / 180) + ox);
			int ySecond = (int) (r * Math.sin(Math.PI * sec / 180) + oy);
			g.setColor(Color.red);
			g.drawLine(ox, oy, xSecond, ySecond);
			
			min = cal.get(Calendar.MINUTE)*6 + sec/60 - 90;
			int xMinute = (int) (150 * Math.cos(Math.PI * min / 180) + ox);
			int yMinute = (int) (150 * Math.sin(Math.PI * min / 180) + oy);
			g.setColor(Color.blue);
			g.drawLine(ox, oy, xMinute, yMinute);
						
			hour = hour * 30 + cal.get(Calendar.MINUTE) / 2 - 90;
			int xHour = (int) (100 * Math.cos(Math.PI * hour / 180) + ox);
			int yHour = (int) (100 * Math.sin(Math.PI * hour / 180) + oy);
			g.setColor(Color.black);
			g.drawLine(ox, oy, xHour, yHour);						
		}
		
		public void run() {
			try {
				while (true) {
					Thread.sleep(1000);
					repaint();
				}
			} catch (Exception e) {
			}
		}
		
	}
	
}

/*
import java.awt.*;
import javax.swing.*;


class DrawerPanel extends JPanel
{
	static int xCenter = 300;
	static int yCenter = 300;
	static int r = 200;
	
	DrawerPanel() {
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawOval(xCenter, yCenter, 5, 5);
		g.drawString("12", xCenter, yCenter/2-60);
		g.drawString("3", xCenter*2-90, yCenter);
		g.drawString("6", xCenter, yCenter*2-80);
		g.drawString("9", xCenter/2-70, yCenter);
		
		double hourAngle = 2 * Math.PI * (3 * 60) / (12 * 60);
		double minuteAngle = 2 * Math.PI * (30 - 15) / 60;
		g.drawLine(xCenter, yCenter, xCenter+(int)(30*Math.cos(hourAngle)), yCenter+(int)(30*Math.sin(hourAngle)));
		g.drawLine(xCenter, yCenter, xCenter+(int)(45*Math.cos(minuteAngle)), yCenter+(int)(45*Math.sin(minuteAngle)));
		
		double theta = 0;
		double delta = (2.0*Math.PI)/100;
		
		int oldX = (int)(r * Math.cos(0.0) + xCenter);
		int oldY = (int)(r * Math.sin(0.0) + yCenter);
		
		for (theta = 0; theta < 3*2*Math.PI + 0.1; theta = theta + delta) {
			int x;
			int y;
			
			x = (int)(r * Math.cos(theta) + xCenter);
			y = (int)(r * Math.sin(theta) + yCenter);
			
			g.drawLine(oldX, oldY, x, y);
			
			oldX = x;
			oldY = y;
			
		}
		
			
	}
}

class DrawerFrame extends JFrame
{
	DrawerFrame() {
		setTitle("Sin Graph");
		setSize(600,600);
		setLocation(100,100);

		JTextField hourField = new JTextField("12", 3);
		JTextField minuteField = new JTextField("00", 3);
		
		DrawerPanel panel = new DrawerPanel();
		
		panel.add(hourField);
		panel.add(minuteField);
		setContentPane(panel);
	}
}

public class Clock {

	public static void main(String[] args) {
		JFrame frame = new DrawerFrame();
		frame.setVisible(true);
	}

} */
