import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Select_Calculator extends JFrame implements ActionListener {

	
	JTextField textfield;
	JTextField minifield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Arial", Font.BOLD,30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Select_Calculator() {
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(420,550);
		setLayout(null);
		setLocationRelativeTo(null);
		
		textfield = new JTextField();
		textfield.setBounds(50,50,300,65);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		minifield = new JTextField();
		minifield.setBounds(250,10,100,40);
		minifield.setFont(myFont);
		minifield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
				
		panel = new JPanel();
		panel.setBounds(50,120,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.gray);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		add(panel);
		add(negButton);
		add(delButton);
		add(clrButton);
		add(textfield);
		add(minifield);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0; i<10; i++) {
			if(e.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource()==addButton) {
			minifield.setText(textfield.getText());
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");			
		}
		if (e.getSource()==subButton) {
			minifield.setText(textfield.getText());
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource()==mulButton) {
			minifield.setText(textfield.getText());
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource()==divButton) {
			minifield.setText(textfield.getText());
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource()==equButton) {
			minifield.setText("");
			num2=Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if (e.getSource()==clrButton) {
			textfield.setText("");
		}
		if (e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if (e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		
	}

}
