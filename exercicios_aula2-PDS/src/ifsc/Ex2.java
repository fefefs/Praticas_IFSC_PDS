package ifsc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insira um numero inteiro : ");
		int n = scan.nextInt();
		
		try {
			String caminhoDoArquivo = "C:\\Users\\ferna\\eclipse-workspace\\exercicios_aula2-PDS\\Tabuada_" + n + ".txt";
			BufferedReader leitor = new BufferedReader(new FileReader(caminhoDoArquivo));
			System.out.println("\nLendo arquivo ...");
			String linha;
			System.out.println("\n");
			while((linha = leitor.readLine()) != null) {
				
				System.out.println(linha);
			}
			
			
			}
			catch (IOException e) {
				System.out.println("Arquivo não encontrado");
			}
			
		
		
		
	}

}
