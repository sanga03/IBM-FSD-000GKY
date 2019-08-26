package code.D_26_08.Networking.MultiCast;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	private JPanel contentPane;
static int portnumber =1234;
static MulticastSocket clientSocket;
static  InetAddress group;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Client frame = new Client();
					frame.setVisible(true);
			
				 clientSocket = new MulticastSocket(portnumber);
				  group =
			                InetAddress.getByName("225.0.0.1");
			        
			        // Joins a multicast group
			        clientSocket.joinGroup(group);
			        
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
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][]"));
		
		textField = new JTextField();
		contentPane.add(textField, "flowx,cell 2 2,alignx left,aligny top");
		textField.setColumns(10);
		
		JButton send = new JButton("send");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String msg = textField.getText();
				DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,group,portnumber);
				try {
					clientSocket.send(dp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(send, "cell 2 3");
	}

}
