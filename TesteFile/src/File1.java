import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File1 {

	public static void main(String[] args) {
		File f1 = new File("teste1.txt");
		
		//Tenta criar um arquivo se não existe
		//Caso existir, verifica-se o objeto for diretorio ou pasta.*******************
		
		try {
		if(!f1.exists()) {
			f1.createNewFile();
			
		} else if (f1.exists() && f1.isDirectory()) {
			System.out.println("objeto existe e é um directório");
			
		} else if (f1.exists() && f1.isFile()) {
			System.out.println("objeto existe e é um arquivo " + f1.getName());
		}
		
		//A partir do diretório atual lista as pastas de arquivos*********************
		
		File f2 = new File("./");
		if(f2.exists() && f2.isDirectory()) {
			File[] lista = f2.listFiles();
			for(File file: lista) {
				if (file.isDirectory()) {
					System.out.println("Diretório : "+ file.getName());
				} else {
					System.out.println("Arquivo : " + file.getName());
				}
			}
			
		}
		// abrir um arquivo criado e escrever nele************************************
		
		File f3 = new File ("teste3.txt");
		try {
			FileWriter fw = new FileWriter(f3 , true);
			fw.write("\npipipopo!");
			System.out.println("Arquivo Modificado!");
			fw.close();
		}catch (IOException e) {
			System.out.println("algum erro aconteceu!");
		}
		
		// Abrir um arquivo e ler o seu conteúdo
		try {
		String caminhoDoArquivo = "C:\\Users\\ferna\\eclipse-workspace\\TesteFile\\teste3.txt";
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
		
		
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
	}	
	//	System.out.println("Apagando o arquivo!");
	//	f1.delete();
    //	f3.delete();
		
		
}
}

