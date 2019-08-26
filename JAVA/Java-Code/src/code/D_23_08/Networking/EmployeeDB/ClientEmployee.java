package code.D_23_08.Networking.EmployeeDB;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ClientEmployee extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;
	private static Socket client;
	private static final int port =54321;
	private static String ip="172.18.3.44";
	private static DefaultTableModel tb;
	private JTextField idd;
	private JTable table;
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		Object[] columnNames = {"id","Fname","lname","salry" };
//	Object[][] data = {{}};
//		 tb = new DefaultTableModel(data, columnNames);
//		 tb.addColumn("id");
//		 
//		tb.addColumn(columnNames);
//		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientEmployee frame = new ClientEmployee();
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
	public ClientEmployee() {
		getContentPane().setLayout(new MigLayout("", "[grow]", "[]"));
		
	
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][]", "[][grow]"));
		
		JButton btnRead = new JButton("Read");
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					client = new Socket(InetAddress.getLocalHost(), port);
//					client = new Socket(ip,port);
				
					OutputStream os = client.getOutputStream();
					PrintWriter pw = new PrintWriter(os,true);
					pw.println(idd.getText());
//					
					InputStream is = client.getInputStream();
					
//					ObjectInputStream oos = new ObjectInputStream(is);
//					Object dummy = oos.readObject();
//					System.out.println(dummy);
//					
					
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String dat=br.readLine();
					System.out.println();
					String[] cl =dat.split(",");
					
//					System.out.println();
//					table.add(tb);
					Object[] data= new String[4];
					int i=0;
					for(String a:cl) {
						System.out.println(a);
						data[i]=a;
						i++;
					}
				DefaultTableModel	tb =new DefaultTableModel();
					Object[] columnNames = {"id","fname","lname","salry"};
					for(Object ob:columnNames) {
						tb.addColumn(ob);
					}
					tb.addRow(data);
					table.setModel(tb);
					pw.close();
					br.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		idd = new JTextField();
		contentPane.add(idd, "cell 0 0,alignx left");
		idd.setColumns(10);
		contentPane.add(btnRead, "cell 1 0");
		
		panel = new JPanel();
		contentPane.add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		table = new JTable();
		panel.add(table, "cell 0 0,grow");
	}

}
