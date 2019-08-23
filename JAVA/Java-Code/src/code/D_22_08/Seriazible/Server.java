package code.D_22_08.Seriazible;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static ServerSocket server;
	private static Socket client;

	public static void  main(String[] args) {
		try {
			server = new ServerSocket(4400);
					
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("server created"+server);
		while(true) {
//			
			try {
				client = server.accept();
				System.out.println("waiting for request");
				System.out.println("Connectoin accepted from client"+client);
				InputStream inputStream = client.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				int no = Integer.parseInt(bufferedReader.readLine());
				System.out.println(no);
				no = calcFact(no);
				System.out.println(no);
			
				OutputStream os = client.getOutputStream();
				PrintWriter pw =new PrintWriter(os,true);
				pw.println(new Integer(no).toString());
				pw.close();
				bufferedReader.close();
				System.out.println("closing client");
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
			
		}
	}

	private static int calcFact(int no) {
			if(no<2)
				return no;
		return (calcFact(no-1)*no);
	}
}
