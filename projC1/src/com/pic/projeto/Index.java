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
		
		status = Funcao.existeSolucao(filename);
		
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
			
			status = Funcao.getStatus();
			if(status == 0){
				
			Pilha<Coordenada> caminho = new Pilha <Coordenada>(Funcao.getLine()*Funcao.getColumn());
			Pilha<Pilha<Coordenada>> possibilidades = new Pilha<Pilha <Coordenada>>(Funcao.getLine()*Funcao.getColumn());
			
			Progressao.positionEntrance(caminho);
			//Progressao.showPosition(caminho);
			 
			
			int cont=0;
			
			while(status<3){
				while (status == 0){
					status = Progressao.progress(caminho,possibilidades);
					if(status==0){
						//Progressao.showPosition(caminho);
						
					}
					
				}
			//Progressao.showStack(caminho);
				cont++;
			System.out.println("\nCaminho:"+cont+"\n");
			Funcao.showM();
			
				while (status == 1){
					status = Regressao.regress(caminho, possibilidades);
					//System.out.println(status);
					//System.out.println("PQ:"+possibilidades.getQuantos());
				}
				if(status == 1){
				Funcao.showM();
				}
			}
			} 
			if(status == 4) {
				System.out.println("\nSolução : \n");
				Funcao.showM();
				Funcao.writeSolucao(filename);
			}
			if(status == 5 ){
				System.out.println("\nNao existe caminho\n");
				Funcao.showM();
			}
			
			/*
			System.out.println(status);
			System.out.println("PQ:"+possibilidades.getQuantos());
			
			Pilha<Coordenada> qwe = new Pilha <Coordenada>(Funcao.getLine()*Funcao.getColumn());
			while(!possibilidades.isVazia()){
			qwe = possibilidades.getValor();
			if(qwe.isVazia()){
				System.out.println("vazio");
			}
			if(!qwe.isVazia()){
				Coordenada posicao = null;
				posicao = qwe.getValor();
				System.out.println("P:"+posicao.getL()+","+posicao.getC());
			}
			possibilidades.jogueForaValor();
			System.out.println("PQ:"+possibilidades.getQuantos());
			}
			System.out.println(status);
			*/
			//teste
			
	}

}

