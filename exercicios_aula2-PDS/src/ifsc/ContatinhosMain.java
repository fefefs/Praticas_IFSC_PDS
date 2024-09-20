package ifsc;

import java.util.ArrayList;
import java.util.Scanner;

public class ContatinhosMain {

	public static void main(String[] args) {
		
		 ArrayList<Contatinho> ListaContatos = new ArrayList<>();
		 Scanner scan = new Scanner(System.in);
		 String nomeFile = "Contatinhos.txt";		 
		 Agenda agenda = new Agenda();
		
		int r = -1;
		while (r != 0) {

			System.out.println("********MENU******** \n\n 0-Sair \n 1- Novo contatinho \n 2- Ordenar Lista \n 3- Salvar lista \n 4- Procurar contatinho por nome \n\n********************");
			System.out.println("Digite uma das opcoes acima :");
			String op = scan.nextLine();
			r = Integer.valueOf(op);
			if ( r < 0 || r > 4) {
				while (r < 0 || r > 4  ) {
					System.out.println("Resposta invalida !!\nInsira novamente :");
					op = scan.nextLine();
					r = Integer.valueOf(op);
				}
			}
			
			switch (r) {

			case 1:
				
				
				System.out.println("Insira o nome do novo contatinho");
				String nome = scan.nextLine();
				
				System.out.println("Insira o email do novo contatinho");
				String email = scan.nextLine();
				
				System.out.println("Insira o telefone do novo contatinho");
				String telefone = scan.nextLine();
				
				System.out.println("Insira a categoria do novo contatinho");
				String categoria = scan.nextLine();
				
				Contatinho contato = new Contatinho(nome,email,telefone,categoria);
				
				 agenda.addContatinho(contato);
				
				
				break;
			case 2:
				
				agenda.ordenar();
				
				System.out.println("Lista ordenada com sucesso !!");
				
				break;
			
			case 3:
				
				agenda.salvarLista(nomeFile);
				
				System.out.println("Lista salva com sucesso !!");
				
				break;
				
			case 4 :
				
				System.out.print("\nInsira o nome que deseja procurar : ");
				String nomeP = scan.nextLine();
				Contatinho contatoP = agenda.procurar(nomeP, nomeFile);
				
				if(contatoP != null) {
					
					System.out.println("Contatinho achado !!");
					System.out.println("Nome : " + contatoP.getNome());
					System.out.println("Email : " + contatoP.getEmail());
					System.out.println("Telefone : " + contatoP.getTelefone());
					System.out.println("Categoria : " + contatoP.getCategoria());
					
				} else {
					System.out.println("Contatinho não encontrado :(");
				}
			
			}
		
		}
		
		System.out.println("Voce saiu do sistema!");
		
		

	}

}
