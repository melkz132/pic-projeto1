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
	
		status = Funcao.getStatus();
		if(status == 0){
			//imprime tudo do arquivo
			System.out.println("\nConteudo do arquivo "+filename);
			Funcao.showFile(filename);
		}
			
		status = Funcao.getStatus();
		if(status == 0){
		//coloca conteudo na matriz
			System.out.println("\nMatriz:");
			maze = Funcao.fillM(filename);
		}
			
			status = Funcao.getStatus();
			if(status == 0){
			//mostra matriz
			System.out.println("");
			Funcao.showM();
			}
			
			status = Funcao.getStatus();
			if(status == 0){
			//procura entrada
			System.out.println("");
			Funcao.searchE();
			}
			
			status = Funcao.getStatus();
			if(status == 0){
			//procura saida
			System.out.println("");
			Funcao.searchS();
			}
			
			status = Funcao.getStatus();
			if(status == 0){
			//procura buracos
			System.out.println("");
			Funcao.searchB();
			}
			
			status = Funcao.getStatus();
			if(status == 0){
			//procura buracos
			System.out.println("");
			Funcao.verifyESMiddle();
			}
			
			status = Funcao.getStatus();
			if(status == 0){
			//verifica caracteres invalidos
			System.out.println("");
			Funcao.verifyInvalidChar();
			}

			Pilha<Coordenada> caminho = new Pilha <Coordenada>(Funcao.getLine()*Funcao.getColumn());
			Pilha<Pilha<Coordenada>> possibilidades = new Pilha<Pilha <Coordenada>>(Funcao.getLine()*Funcao.getColumn());
			
			Progressao.positionEntrance(caminho);
			Progressao.showPosition(caminho);
			 
			
			int cont=0;
			while (status == 0){
				status = Progressao.progress(caminho);
				if(status==0){
				Progressao.showPosition(caminho);
				}
				cont++;
			}
			
			
			Funcao.showM();
			
			/*
			Progressao.positionPlusOne(caminho);
			Progressao.showPosition(caminho);
			
			caminho.jogueForaValor();
			
			Progressao.showPosition(caminho);*/
			//teste
			
	}

}
