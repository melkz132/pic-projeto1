package com.pic.projeto;

import java.io.File;
import java.util.Scanner;

public class Index {

	private static Scanner input;
	private static int status;
	
	public static void main(String[] args) throws Exception {
		
		char [][] maze;
		Scanner scanner = null;
		String filename ;
		
		//procura o arquivo
		System.out.println("Nome do arquivo:");
		input = new Scanner(System.in);
		filename = input.nextLine();
		
		if(!filename.contains(".txt")){
			filename = filename+".txt";
		}
		
		try{
			File arq1 = new File(filename);
		
			if (arq1.exists()){
				System.out.println("Existe = "+filename);
			}
			else{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			System.out.println("Nao existe o arquivo "+filename);
		}
	
		status = Coordenada.getStatus();
		if(status == 0){
			//imprime tudo do arquivo
			System.out.println("Conteudo do arquivo "+filename);
			Coordenada.showFile(filename);
		}
			
		status = Coordenada.getStatus();
		if(status == 0){
		//coloca conteudo na matriz
			System.out.println("");
			maze = Coordenada.fillM(filename);
		}
			
			status = Coordenada.getStatus();
			if(status == 0){
			//mostra matriz
			System.out.println("");
			Coordenada.showM();
			}
			
			status = Coordenada.getStatus();
			if(status == 0){
			//procura entrada
			System.out.println("");
			Coordenada.searchE();
			}
			
			status = Coordenada.getStatus();
			if(status == 0){
			//procura saida
			System.out.println("");
			Coordenada.searchS();
			}
			
			status = Coordenada.getStatus();
			if(status == 0){
			//procura buracos
			System.out.println("");
			Coordenada.searchB();
			}
			
			status = Coordenada.getStatus();
			if(status == 0){
			//procura buracos
			System.out.println("");
			Coordenada.verifyESMiddle();
			}
			
			status = Coordenada.getStatus();
			if(status == 0){
			//verifica caracteres invalidos
			System.out.println("");
			Coordenada.verifyInvalidChar();
			}

	}

}
