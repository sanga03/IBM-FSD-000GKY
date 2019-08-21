package code.D_21_08.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

public class ResultSetLoad extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private 	Rs2xmlConfig config;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private final JButton btnLoadAll = new JButton("Load all");

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ResultSetLoad() throws SQLException {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		config = new Rs2xmlConfig();
		contentPane.setLayout(new MigLayout("", "[412px]", "[238px][]"));
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				ResultSet rset= config.getRset();
				table.setModel(DbUtils.resultSetToTableModel(rset));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		scrollPane.setRowHeaderView(btnLoad);
		
		btnNewButton = new JButton("New button");
		scrollPane.setColumnHeaderView(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		scrollPane.setColumnHeaderView(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		scrollPane.setColumnHeaderView(btnNewButton_2);
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rset= config.getRsetCart();
					table.setModel(DbUtils.resultSetToTableModel(rset));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnLoadAll, "cell 0 1");
		
		setVisible(true);
	}

}
