package code.D_21_08.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{

	private JLabel jLabel;
	private JTextField jTextField;
	private JButton button;

public MyFrame() {
	super();
	jLabel = new JLabel();
	jLabel.setText("Enter Name");
	jTextField = new JTextField(25);
	button = new JButton();
	button.setText("Hello");
	button.addActionListener(this);
	this.setTitle("My Frame");
	this.setSize(500, 500);
	this.setLayout(new FlowLayout());
	this.add(jLabel);
	this.add(jTextField);
	this.add(button);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JOptionPane.showMessageDialog(this, "hey"+jTextField.getText().toString());
}
}
