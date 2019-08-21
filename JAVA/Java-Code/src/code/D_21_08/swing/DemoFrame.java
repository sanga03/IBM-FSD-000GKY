package code.D_21_08.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import code.D_20_08.EmployeSql.model.Employee;
import code.D_20_08.EmployeSql.services.EmployeeServiceImplementation;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DemoFrame extends JFrame {
	
	private EmployeeServiceImplementation empService;
	private JPanel contentPane;
	private JTextField eid;
	private JTextField fName;
	private JTextField lName;
	private JTextField salary;
	private JButton btnSave;
	private JButton btnFindById;
	private JButton btnUpdate;
	private JButton btnReset;
	private JButton btnLoad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame();
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
	public DemoFrame() {
		empService = new EmployeeServiceImplementation();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(12, 17, 83, 14);
		contentPane.add(lblEmployeeId);
		
		eid = new JTextField();
		eid.setBounds(104, 17, 162, 20);
		contentPane.add(eid);
		eid.setColumns(10);
		
		fName = new JTextField();
		fName.setBounds(104, 41, 162, 20);
		contentPane.add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.setBounds(104, 65, 162, 20);
		contentPane.add(lName);
		lName.setColumns(10);
		
		salary = new JTextField();
		salary.setBounds(104, 89, 162, 20);
		contentPane.add(salary);
		salary.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 113, 1, 22);
		contentPane.add(separator);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(12, 41, 83, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(12, 65, 83, 14);
		contentPane.add(lblLastName);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(12, 89, 30, 14);
		contentPane.add(lblSalary);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(104, 120, 75, 23);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Hello");
				int id=Integer.parseInt(eid.getText().toString());
				String fname=fName.getText().toString();
				String lname=lName.getText().toString();
				int sal=Integer.parseInt(salary.getText().toString());
				System.out.println(id+fname+lname+sal);
				try {
				empService.createEmployee(new Employee(
						id,
						fname,
						lname,
						sal));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(eid.getText().toString());
				if(empService.deleteEmployee(id)) {
					JOptionPane.showMessageDialog(contentPane, "Delete Success");
				}else {
					JOptionPane.showMessageDialog(contentPane, "Employee Doesnt exists");
				}
			}
		});
		btnDelete.setBounds(189, 120, 77, 23);
		contentPane.add(btnDelete);
		
		btnFindById = new JButton("find by Id");
		btnFindById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(eid.getText().toString());
				Employee emp = empService.getEmployeeById(id);
				fName.setText(emp.getFirstName());
				lName.setText(emp.getLastName());
				Integer sal = new Integer(emp.getSalary());
				salary.setText(sal.toString());
			}
		});
		btnFindById.setBounds(297, 16, 89, 23);
		contentPane.add(btnFindById);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(eid.getText().toString());
				String fname=fName.getText().toString();
				String lname=lName.getText().toString();
				int sal=Integer.parseInt(salary.getText().toString());
				Employee emp=new Employee(
						id,
						fname,
						lname,
						sal);
				if(empService.updateEmployee(emp)) {
					JOptionPane.showMessageDialog(contentPane, "Delete Success");
				}else {
					JOptionPane.showMessageDialog(contentPane, "Employee Doesnt exists");
				}
			}
		});
		btnUpdate.setBounds(297, 64, 89, 23);
		contentPane.add(btnUpdate);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fName.setText("");
				lName.setText("");
				eid.setText("");
				salary.setText("");
			}
		});
		btnReset.setBounds(297, 120, 89, 23);
		contentPane.add(btnReset);
		
		btnLoad = new JButton("load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ResultSetLoad();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoad.setBounds(189, 184, 89, 23);
		contentPane.add(btnLoad);
	}
}
