package code.D_22_08.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainFileIO {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream(new File("source.txt"));
		FileOutputStream fout = new FileOutputStream(new File("out.txt"));
		int c;
		while((c=fin.read())!=-1) {
			fout.write(c);
		}
		fin.close();
		fout.close();
		FileReader freader = new FileReader(new File("source.txt"));
		FileWriter fwriter = new FileWriter(new File("out1.txt"));
		
		BufferedReader istream = new BufferedReader(freader);
		PrintWriter oStream = new PrintWriter(fwriter);
		String l;
		while(((l=istream.readLine())!=null)) {
			System.out.println(l);
			oStream.println(l);
		}
		char ch;
		while((c=freader.read())!=-1) {
			System.out.println(c);
			fwriter.write(c);
		}

		fwriter.close();
		
	}
	

}
