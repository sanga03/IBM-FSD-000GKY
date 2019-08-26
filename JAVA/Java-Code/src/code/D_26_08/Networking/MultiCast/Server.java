package code.D_26_08.Networking.MultiCast;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MultipleGradientPaint;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Server extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	static JTextArea textArea;
	static MulticastSocket serverSocket;
	static InetAddress group;
	static int portnumber =1234;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
					
					 serverSocket = new MulticastSocket(portnumber);
					 group = InetAddress.getByName("225.0.0.1");
					serverSocket.joinGroup(group);
					textArea.setText("hey");
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][grow]", "[][][][grow]"));
		
		JButton btnStartServer = new JButton("start server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				byte[] buff =new byte[1024];
					DatagramPacket dp = new DatagramPacket(buff, buff.length, group, portnumber);
					try {
						serverSocket.receive(dp);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String msg =new  String(dp.getData()).trim();
					
					textArea.setText(msg);
					System.out.println(msg);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			
		});
		contentPane.add(btnStartServer, "cell 6 0");
		
		 textArea = new JTextArea();
		contentPane.add(textArea, "cell 0 1 7 3,grow");
	}

}
