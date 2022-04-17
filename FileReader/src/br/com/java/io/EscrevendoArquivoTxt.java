package br.com.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class EscrevendoArquivoTxt {
	public static void main(String[] args) {
		
		try {
			
			FileInputStream input = new FileInputStream("teste.txt");
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(reader);
			
			OutputStream output = new FileOutputStream("arquivoProcessado.txt");
			Writer write = new OutputStreamWriter(output);
			BufferedWriter bufferWrite = new BufferedWriter(write);
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				String[] vec = linha.split(";");
				
				String[] cpfSplitado = vec[0].split("=");
				String cpf = cpfSplitado[1];
				
				String[] emailSplitado = vec[1].split(":");
				String email = emailSplitado[1];
				
				String newLineScore = "cpf:"+cpf+";email:"+email;

				bufferWrite.write(newLineScore);
				bufferWrite.newLine();
				
				linha = buffer.readLine();
			}
			
			bufferWrite.close();
			buffer.close();
		} catch (Exception e) {
		}

	}

}
