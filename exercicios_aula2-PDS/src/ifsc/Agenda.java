package ifsc;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Agenda {
	private static ArrayList<Contatinho> ListaContatos = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	
	public Agenda() {
		this.ListaContatos = new ArrayList<>();
	}
	
	public void addContatinho(Contatinho contatinho) {
		
		this.ListaContatos.add(contatinho);
		
	}
	
	public static void ordenar() {
		
		//ListaContatos.sort(null);
		
		Collections.sort(ListaContatos, Comparator.comparing(Contatinho::getNome));
		
	}
	
	public static void salvarLista(String nomeFile) {
		
		try (BufferedWriter wr = new BufferedWriter(new FileWriter(nomeFile))){
	
			for (Contatinho c : ListaContatos) {
				
				wr.write(c.toString());
				wr.newLine();
				
			}	
		}catch(Exception e) {
			System.out.println("Erro ao salvar arquivo"+ e.getMessage() );
			
		}
	}
	
	public Contatinho procurar(String nome, String nomeArq) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(nomeArq))){
		String linha;
		while((linha = reader.readLine()) != null) {
			String[] partes = linha.split("#");
			if(partes.length == 4 && partes[0].equals(nome)) {
				return new Contatinho(partes[0], partes[1], partes[2], partes[3]);
			}
		}
		}catch(IOException e)	{
			System.out.println("erro"+ e.getMessage());
		}
     return null;
	}
	
	
}
