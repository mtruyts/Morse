package aula;

import java.util.Scanner;

/**
 * Inicia o aplicativo que le uma frase em inglês e a codifica em codigo Morse e
 * o aplicativo que le uma frase em codigo Morse e a converte no equivalente em ingles. 
 * 
 * @author Matheus Truyts
 * @version 1.0
 * 
 */

public class Principal {

	public static Scanner scanner = new Scanner(System.in);

	/**
	 * Metodo principal da aplicacao responsavel por executar o aplicativo
	 * 
	 * @param args
	 * 
	 */

	public static void main(String[] args) {

		Morse morse = new Morse();
		String Ingles, Morse;
		int opcao;
		boolean continuar = true;
		
		while(continuar) {
			System.out.println("Escolha uma opcao:\n   1 - Traduzir frase em inglês para código morse\n   2 - Traduzir código morse para frase em inglês");
			opcao = scanner.nextInt(); scanner.nextLine();
			// validar a opcao
			while(opcao != 1 && opcao != 2) {
				System.out.println("Opcao invalida!!\nEscolha uma opcao:\n   1-Traduzir ingles para morse\n   2-Traduzir morse para ingles");
				opcao = scanner.nextInt(); scanner.hasNextLine();
			}

			if(opcao == 1) {
				System.out.println("Digite a sua frase em ingles: ");
				Ingles = scanner.nextLine().toUpperCase();
				for( int i = 0; i < Ingles.length(); i++ ) {
					char aux = Ingles.charAt(i);
					String letra = Character.toString(aux);
					// caso seja um espaco
					if(letra.equals(" ")) {
						System.out.print("   ");
						// caso seja um numero (tabela ascii 48-57)
					}else if(aux >= 48 && aux <= 57) {
						if(i != (Ingles.length()-1)) {
							if(Ingles.charAt(i+1) == ' ') {
								System.out.print(morse.getMorseNum(letra));
							}else {
								System.out.print(morse.getMorseNum(letra) + " ");
							}
						}else {
							System.out.println(morse.getMorseNum(letra));
						}

						// caso seja um alfabeto
					}else {
						if(i != (Ingles.length()-1)) {
							if(Ingles.charAt(i+1) == ' ') {
								System.out.print(morse.getMorseAlf(letra));
							}else {
								System.out.print(morse.getMorseAlf(letra) + " ");
							}
						}else {
							System.out.println(morse.getMorseAlf(letra));
						}

					}
				}
			}else {

				System.out.println("Digite a sua frase em morse: ");
				Morse = scanner.nextLine();
				String[] palavras = Morse.split("   ");				
				for( int i = 0; i < palavras.length; i++ ) {
					String palavra = palavras[i];							
					String[] letras = palavra.split(" ");					
					for( int j = 0; j < letras.length; j++ ) {
						String letra = letras[j];							
						// se a letra for um alfabeto
						if(letra.length() <= 4) {
							System.out.print(morse.getAlf(letra));
							// se a letra for um numero
						}else if(letra.length() == 5) {
							System.out.print(morse.getNum(letra));
						}
					}

					System.out.print(" ");
				}
				System.out.println();
			}

			System.out.println("\nVoce quer continuar? ( 1-S / 2-N )");
			opcao = scanner.nextInt(); scanner.nextLine();
			
			while(opcao != 1 && opcao != 2) {
				System.out.println("Opcao invalida.\nVoce quer continuar? ( 1-S / 2-N )");
				opcao = scanner.nextInt(); scanner.nextLine();
			}
			
			if(opcao == 2) {
				continuar = false; 
				System.out.println("Aplicativo finalizado");
			}
		}
		scanner.close();
	}

}