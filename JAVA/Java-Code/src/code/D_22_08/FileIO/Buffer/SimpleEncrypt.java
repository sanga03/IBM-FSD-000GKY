package code.D_22_08.FileIO.Buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleEncrypt {
	void encrypt(String fin, String fout, int pilot) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fin));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fout));
			int data;
			String line;
			int vowel = 0;
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					if (this.checkVowel(line.charAt(i)))
						vowel += 1;
					data = (int)line.charAt(i)+pilot;
					writer.write(data);
				}
				writer.write("--"+vowel+'\n');
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private boolean checkVowel(char charAt) {
		// TODO Auto-generated method stub
		String vow = "aeiouAEIOU";
		for (char ch : vow.toCharArray()) {
			if (charAt == ch)
				return true;
		}
		return false;
	}
}