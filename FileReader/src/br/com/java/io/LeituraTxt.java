package br.com.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeituraTxt {
	public static void main(String[] args) {
		
		try {
			//Fluxo de entrada
			FileInputStream input = new FileInputStream("teste.txt");
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(reader);
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				String[] vec = linha.split(";");
				String[] cpfSplitado = vec[0].split("=");
				String cpf = cpfSplitado[1];
				String[] emailSplitado = vec[1].split(":");
				String email = emailSplitado[1];
				System.out.println(cpf);
				System.out.println(email);
				linha = buffer.readLine();
			}
			
			buffer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
