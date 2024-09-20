package ifsc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insira um numero inteiro : ");
		int n = scan.nextInt();
		
		File tab = new File("Tabuada_" + n + ".txt");
		
		try {
			
			FileWriter fw = new FileWriter(tab);
			fw.write("******** TABUADA DO "+ n + " ********\n");
			for(int i = 0;i<=10;i++) {
				fw.write("\n"+ i + " x " + n + " = "+ i*n);
			}
			
			System.out.println("Arquivo Modificado!");
			fw.close();
		}catch (IOException e) {
			System.out.println("algum erro aconteceu!");
		}
		
		

	}

}
