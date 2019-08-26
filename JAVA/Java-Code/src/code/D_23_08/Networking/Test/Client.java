package code.D_23_08.Networking.Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.Socket;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
	private static Socket client;
	private static final int port =54321;
	private static String ip="172.18.3.44";

	/**
	 * Launch the application.
	 */
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					client = new Socket(InetAddress.getLocalHost(), port);
					client = new Socket(ip,port);
					OutputStream os = client.getOutputStream();
					PrintWriter pw = new PrintWriter(os,true);
					pw.print(12);
					InputStream is = client.getInputStream();
					ObjectInputStream oss = new ObjectInputStream(is);
//					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					Object t = oss.readObject();
					ResultSet sret = (ResultSet)t;
					System.out.println(sret);
					
//					String dat=br.readLine();
					
				
//					System.out.println();
//					table.add(tb);
					
				
					pw.close();
//					br.close();
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
	}

}
