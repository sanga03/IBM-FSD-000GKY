package code.D_23_08.Networking.EmployeeDB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import code.D_20_08.EmployeSql.model.Employee;
import code.D_20_08.EmployeSql.services.EmployeeServiceImplementation;

public class ServerEmployee {
	private static Employee emp;
	private static ServerSocket server;
	private static Socket client;
	private static final int port = 54321;
	private static EmployeeServiceImplementation service;

	public static void main(String[] args) {
		service = new EmployeeServiceImplementation();
		try {
			server = new ServerSocket(port);
			System.out.println("server started" + server);
			while (true) {

				try {
					client = server.accept();
					System.out.println("Client connected" + client);
					InputStream is = client.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					int id = Integer.parseInt(br.readLine());
					System.out.println(id);
					emp = service.getEmployeeById(id);
//					service.deleteEmployee(id);
			
					System.out.println(emp);
					OutputStream os = client.getOutputStream();
					PrintWriter pw =new PrintWriter(os,true);
					pw.println(emp);
					pw.close();
					br.close();
					client.close();
//					BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(os));
					
			} catch (IOException e) {

				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
}
