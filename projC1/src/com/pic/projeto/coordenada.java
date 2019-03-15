package com.pic.projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class coordenada {
	
	protected static char[][] maze;
	protected static int L;
	protected static int C;
	protected static int EntL;
	protected static int EntC;
	protected static int status = 0;

	public static void showFile(String filename){
		try{
			FileReader arq = new FileReader(filename);
			BufferedReader b = new BufferedReader(arq);
			String line;
			while((line = b.readLine()) != null) {
	            System.out.println(line);
		 	}		
	        b.close();  
	       
		}
		catch(Exception e){
			System.out.println("Conteudo nao pode ser mostrado");
			status=1;
		}
	}
	
	public static char[][] fillM(String filename) throws FileNotFoundException{
		
			 Scanner scanner = new Scanner(new File(filename)); 
			 String S;
			 int cont = 0;
			 
			 try{
			 S = scanner.nextLine();
			 System.out.println("Linhas="+S);
			 L = Integer.parseInt(S);
			 //System.out.println("L="+L);
			
			try{
			S = scanner.nextLine();
			 cont = S.length();
			 System.out.println("Colunas="+cont);
			 C = cont;
			 //System.out.println("C="+C);*/
			 maze = new char[L][C];
			 
			 char [] tokens = S.toCharArray();
			 
			 int i=0;
			 for (int j = 0; j < C ; j++){
					maze[i][j] = tokens[j];
					//System.out.println("j="+j+" i= "+i+" m= "+maze[i][j]);
					
				}
			 i++;
			 
			try{
				
				while(i < L){
					//System.out.println("i="+i);
					String line = scanner.nextLine();
					
					tokens = line.toCharArray();
					
					if(i==0) {
						cont = line.length();
						System.out.println("Colunas="+cont);
					}
					
					/*for (int t=0; t < C; t++){
					System.out.print(tokens[t]);
					}*/
					//System.out.println("\nlength="+tokens.length);
					
					if( cont != tokens.length){
						maze = null;
						status=1;
						throw new ArrayIndexOutOfBoundsException();
					}
					
					for (int j = 0; j < C ; j++){
						maze[i][j] = tokens[j];
						//System.out.println("j="+j+" i= "+i+" m= "+maze[i][j]);
						
					}
					
						

					i++;
					if(!scanner.hasNextLine()){
						break;
					}
				}
				
				if(i!=L || scanner.hasNextLine()){
					System.out.println("Numero de linhas esta errado");   
					maze = null;
					status=1;
					//throw new Exception();
				}
				
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Numeros de colunas esta errado");
				status=1;
			}
			
			 catch(Exception e){
				 
				 System.out.println("Matriz nao pode ser preenchida");
				 status=1;
			 }
			 }
			catch(Exception e){
				 System.out.println("Nao existe o numero de colunas");
				 status=1;
			 }
			 }
			 catch(Exception e){
				 System.out.println("Nao existe o numero de linhas");
				 status=1;
			 }
			 return maze;
	}		
	
	public static void showM(){
		if(!(maze==null)){
		 for (int q = 0; q < L; q++){
				for (int w = 0; w < C; w++){
				System.out.print(maze[q][w]);
			}
				System.out.println();
		 }
		}
		else{
			status=1;
			System.out.print("Nao existe matriz valida");
		}
	}
	
	public static void searchE(){
		
		
		int q = 0;
		int w = 0;
		int e = 0;
		try{
			 for (q = 0; q < L; q++){
				 
					if(maze[q][w]=='E'){
						System.out.println("Existe entrada");
						EntL = q;
						EntC = w;
						e++;
					}
					
			 }
				q=q-1;	
			 for (w = 0; w < C; w++){
				 
						if(maze[q][w]=='E'){
							System.out.println("Existe entrada");
							EntL = q;
							EntC = w;
							e++;
						}
					}
			 w=w-1;
			 for (; q > 0; q--){
					
					if(maze[q][w]=='E'){
						System.out.println("Existe entrada");
						EntL = q;
						EntC = w;
						e++;
					}
				}
			 for (; w > 0; w--){
					
					if(maze[q][w]=='E'){
						System.out.println("Existe entrada");
						EntL = q;
						EntC = w;
						e++;
					}
				}
		}
		catch(Exception ws){
			
		}
			 if(e>1){
				 System.out.println("Existe "+e+" entradas");
				 status=1;
			 }
			 if(e<1){
				 System.out.println("Nao existe entrada");
				 status=1;
			 }
			
			
			 }
	
	public static char [][] getMaze(){
		return maze;
	}
	
	public static int getStatus(){
		return status;
	}
	
	public static int getEntL(){
		return EntL;
	}
	
	public static int getEntC(){
		return EntC;
	}
}	//fim
