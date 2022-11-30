import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class Select_DigitalClock extends JFrame {

	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	
	Select_DigitalClock() {
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("My Clock Program");
		setLayout(new FlowLayout());
		setSize(350,200);
		setResizable(false);
		setLocationRelativeTo(null);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MM dd, yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("±√º≠√º",Font.PLAIN,50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("πŸ≈¡",Font.PLAIN,35));
				
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("µ∏øÚ",Font.PLAIN,35));
		
		//JPanel panel = new JPanel();
		
		add(timeLabel);
		add(dayLabel);
		add(dateLabel);
		
		timer.start();
		//setTime();
	}
	
	//public void paintComponent(Graphics g) { }
	
	Timer timer = new Timer(1000,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {				
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			System.out.println(date + " " + day + " " + time);
		}			
	});
	
	/*public void setTime() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			System.out.println(date + " " + day + " " + time);
			try {
				Thread.sleep(1000);
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}*/
	
}


/*
public class Select_DigitalClock extends JFrame implements Runnable{

	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	//Thread t;
	
	Select_DigitalClock() {
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("My Clock Program");
		setLayout(new FlowLayout());
		setSize(350,200);
		setResizable(false);
		setLocationRelativeTo(null);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MM dd, yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("±√º≠√º",Font.PLAIN,50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("πŸ≈¡",Font.PLAIN,35));
				
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("µ∏øÚ",Font.PLAIN,35));
		
		add(timeLabel);
		add(dayLabel);
		add(dateLabel);
		
		//t = new Thread();
		//t.start();
		//setTime();
	}
	
	//public void setTime() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	//}
	
	public void paintComponent(Graphics g) {
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		day = dayFormat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day);
		
		date = dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date);
	}

	@Override
	public void run() {
		while(true) {
			//time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			//dateLabel.setText(date);
			
			try {
				Thread.sleep(1000);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}*/
