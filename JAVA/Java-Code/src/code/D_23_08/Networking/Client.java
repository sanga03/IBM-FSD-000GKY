package code.D_23_08.Networking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Client extends JFrame {

	private JPanel contentPane;
	private static Socket client;
	private JTextField number;
	private JTextField result;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		number = new JTextField();
		contentPane.add(number, "flowx,cell 1 1,alignx left");
		number.setColumns(10);
		
		JButton sendButton = new JButton("sendButton");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					client = new Socket(InetAddress.getLocalHost(), 4400);
				
					OutputStream os = client.getOutputStream();
					PrintWriter pw = new PrintWriter(os,true);
					pw.println(number.getText());
					
					
					InputStream clientIn = client.getInputStream();
	                BufferedReader br = new BufferedReader(new
	                        InputStreamReader(clientIn));
	                String fact = br.readLine();
	                result.setText(fact);
	                System.out.println(fact);
	                pw.close();
	                br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(sendButton, "cell 1 1");
		
		result = new JTextField();
		contentPane.add(result, "cell 1 3,alignx left");
		result.setColumns(10);
	}

}
