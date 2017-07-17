package aula;

/**
 * A classe Morse é utilizada para gerar um objeto do tipo Morse com 
 * as listas de alfabetos e numeros com seus respectivos codigos morse correspondentes
 * e metodos para obter alfabetos, numeros e codigos morse. 
 * 
 * @author Matheus Truyts
 * @version 1.0
 *
 */

public class Morse {
	String alfabeto[][] = new String[26][2];
	String numeros[][] 	= new String[10][2];

	/**
	 * Contructor responsavel por armazenar as listas de alfabetos e 
	 * numeros com seus respectivos codigos morse correspondentes
	 * 
	 */

	public Morse() {
		String[] alf = {
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		String[] morse = {
				".-"  , "-...", "-.-.", "-.." , "."   , "..-.",
				"--." , "....", ".."  , ".---", "-.-" , ".-..",
				"--"  , "-."  , "---" , ".--.", "--.-", ".-." ,
				"..." , "-"   , "..-" , "...-", ".-- ", "-..-",
				"-.--", "--.." };

		for(int i = 0; i < alf.length; i++) {
			for(int j = 0; j < 2; j++) {
				if(j == 0){ // inserindo alfabeto
					alfabeto[i][j] = alf[i];
				}else { // inserindo morse correspondente
					alfabeto[i][j] = morse[i];
				}
			}
		}

		String [] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		String[] morseN = {
				".----", "..---", "...--", "....-", ".....",
				"-....", "--...", "---..", "----.", "-----" };

		for(int i = 0; i < numeros.length; i++) {
			for(int j = 0; j < 2; j++) {
				if(j == 0) 	numeros[i][j] = num[i];
				else 		numeros[i][j] = morseN[i];
			}
		}
	}

	/**
	 * Método responsavel por receber o codigo morse equivalente aos numeros
	 * 
	 */
	public String getNum(String morse) {
		for(int i = 0; i < numeros.length; i++) {
			if(morse.equals(numeros[i][1]))
				return numeros[i][0];
		}
		return null;
	}


	/**
	 * Método responsavel por receber os numeros equivalentes ao codigo morse
	 * 
	 */
	public String getMorseNum(String num) {
		for(int i = 0; i < numeros.length; i++) {
			if(num.equals(numeros[i][0]))
				return numeros[i][1];
		}
		return null;
	}

	/**
	 * Método responsavel por receber o codigo morse equivalente as palavras
	 * 
	 */
	public String getAlf(String morse) {
		for(int i = 0; i < alfabeto.length; i++) {
			if(morse.equals(alfabeto[i][1]))
				return alfabeto[i][0];
		}
		return null;
	}

	/**
	 * Método responsavel por receber os plavaras equivalentes ao codigo morse
	 * 
	 */
	public String getMorseAlf(String letra) {
		for(int i = 0; i < alfabeto.length; i++) {
			if(letra.equals(alfabeto[i][0]))
				return alfabeto[i][1];
		}
		return null;
	}

}

