package com.pic.projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
 
public class Funcao {
	protected static char[][] maze;
	protected static int L;
	protected static int C;
	protected static int entL;
	protected static int entC;
	protected static int exitL;
	protected static int exitC;
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
	public static void writeSolucao(String filename) throws Exception {
		FileWriter fw = new FileWriter(filename, true);
		BufferedWriter bw = new BufferedWriter( fw );
		bw.newLine();
		bw.write("Solução: ");
		bw.newLine();
		if(!(maze==null)){
			 for (int q = 0; q < L; q++){
					for (int w = 0; w < C; w++){
						bw.write(maze[q][w]);
				}
					bw.newLine();
			 }
			}
			else{
				System.out.print("Nao existe matriz valida");
			}
		bw.close();
		fw.close();
	}
	public static char[][] fillM(String filename) throws Exception{
			 
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
		int i = 0;
		String[] position;
		
		i=((L*2)+(C*2));
		position = new String[i];
			i = 0;
			
		try{
			for (q = 0; q < L; q++){
				 
					if(maze[q][w]=='E'){
						//System.out.println("Existe entrada");
						entL = q;
						entC = w;
						position[i++] = q+","+w;
						e++;
					}
					
			 }
				q=q-1;	
			 for (w = 0; w < C; w++){
				 
						if(maze[q][w]=='E'){
							//System.out.println("Existe entrada");
							entL = q;
							entC = w;
							position[i++] = q+","+w;
							e++;
						}
					}
			 w=w-1;
			 for (; q > 0; q--){
					
					if(maze[q][w]=='E'){
						//System.out.println("Existe entrada");
						entL = q;
						entC = w;
						position[i++] = q+","+w;
						e++;
					}
				}
			 for (; w > 0; w--){
					
					if(maze[q][w]=='E'){
						//System.out.println("Existe entrada");
						entL = q;
						entC = w;
						position[i++] = q+","+w;
						e++;
					}
				}
		}
		catch(Exception ws){
			System.out.println("Erro na verificacao de entradas");
		}
			 if(e>1){
				 System.out.println("Existe "+e+" entradas \nL C");
				 i =0;
				 while(position[i]!= null){
					 System.out.println(position[i]);
					 i++;
				 }
				 status=0;
			 }
			 if(e<1){
				 System.out.println("Nao existe entrada");
				 status=1;
			 }
			 if(e==1){
				 System.out.println("Existe entrada \nL C");
				 System.out.println(position[0]);
				 status=0;
			 }
			
		}
	
		public static void existeS(String filename) throws Exception {
			Scanner scanner = new Scanner(new File(filename)); 
			String palavra = "Solução";
			String aux = ""; 
			while( true == scanner.hasNextLine()) {
				aux = scanner.nextLine();
				if (aux.contains(palavra)) {
					System.out.println("\nJá existe solução \n");
					status = 1;
					scanner.close();
					throw new Exception();
				}
			}
			scanner.close();
		}
		public static void searchS(){
		
		int q = 0;
		int w = 0;
		int s = 0;
		
		int i = 0;
		String[] position;
		
		i=((L*2)+(C*2));
		position = new String[i];
			i = 0;
			
		try{
			 for (q = 0; q < L; q++){
				 
					if(maze[q][w]=='S'){
						//System.out.println("Existe saida");
						exitL = q;
						exitC = w;
						position[i++] = q+","+w;
						s++;
					}
					
			 }
				q=q-1;	
			 for (w = 0; w < C; w++){
				 
						if(maze[q][w]=='S'){
							//System.out.println("Existe saida");
							exitL = q;
							exitC = w;
							position[i++] = q+","+w;
							s++;
						}
					}
			 w=w-1;
			 for (; q > 0; q--){
					
					if(maze[q][w]=='S'){
						//System.out.println("Existe saida");
						exitL = q;
						exitC = w;
						position[i++] = q+","+w;
						s++;
					}
				}
			 for (; w > 0; w--){
					
					if(maze[q][w]=='S'){
						//System.out.println("Existe saida");
						exitL = q;
						exitC = w;
						position[i++] = q+","+w;
						s++;
					}
				}
		}
		catch(Exception ws){
			System.out.println("Erro na verificacao de saidas");
		}
			 if(s>1){
				 System.out.println("Existe "+s+" saidas \nL C");
				 i =0;
				 while(position[i]!= null){
					 System.out.println(position[i]);
					 i++;
				 }
				 status=1;
			 }
			 if(s<1){
				 System.out.println("Nao existe saida");
				 status=1;
			 }
			 if(s==1){
				 System.out.println("Existe saida \nL C");
				 System.out.println(position[0]);
				 status=0;
			 }
			
			
			 }
		
		public static void searchB(){
			
			int q = 0;
			int w = 0;
			int b = 0;
			
			int i = 0;
			String[] position;
			
			i=((L*2)+(C*2));
			position = new String[i];
				i = 0;
				
			try{
				 for (q = 0; q < L; q++){
					 
						if(maze[q][w]==' '){
							//System.out.println("Existe buraco");
							position[i++] = q+","+w;
							b++;
						}
						
				 }
					q=q-1;	
				 for (w = 0; w < C; w++){
					 
							if(maze[q][w]==' '){
								//System.out.println("Existe buraco");
								
								position[i++] = q+","+w;
								b++;
							}
						}
				 w=w-1;
				 for (; q > 0; q--){
						
						if(maze[q][w]==' '){
							//System.out.println("Existe buraco");
						
							position[i++] = q+","+w;
							b++;
						}
					}
				 for (; w > 0; w--){
						
						if(maze[q][w]==' '){
							//System.out.println("Existe buraco");
							
							position[i++] = q+","+w;
							b++;
						}
					}
			}
			catch(Exception ws){
				System.out.println("Erro na verificacao de buracos");
			}
				 if(b>=1){
					 System.out.println("Existe "+b+" buracos \nL C");
					 i =0;
					 while(position[i]!= null){
						 System.out.println(position[i]);
						 i++;
					 }
					 status=1;
				 }
				 if(b<1){
					 System.out.println("Nao existe buracos");
					 status=0;
				 }
				
				
				 }
		
	public static void verifyESMiddle(){
			int e = 0;
			int s = 0;
			
			int i = 0;
			String[] position;
			
			i=(L*C);
			position = new String[i];
				i = 0;
		try{		
			for(int q = 1; q<L-1; q++){
				if(q!=0 && q!=L){
					for(int w = 1; w<C-1; w++){
						if(w!=0 && w!=C){
							if(maze[q][w]=='E'){
								position[i++] ="E "+ q+","+w;
								e++;
							}
							if(maze[q][w]=='S'){
								position[i++] ="S "+ q+","+w;
								s++;
							}
						}
					}
				}
			}
		}
		catch(Exception asd){
			System.out.println("Erro na verificacao");
		}
		
		if(e>=1){
			 System.out.println("Existe "+e+" entradas no meio \n  L C");
			 i =0;
			 while(position[i]!= null){
				 char f = position[i].charAt(0);
				 if(f == 'E'){
					 System.out.println(position[i]);
				 }
				 i++;
			 }
			 status=1;
		 }
		
		if(s>=1){
			 System.out.println("Existe "+e+" saidas no meio \n  L C");
			 i =0;
			 while(position[i]!= null){
				 char f = position[i].charAt(0);
				 if(f == 'S'){
					 System.out.println(position[i]);
				 }
				 i++;
			 }
			 status=1;
		 }
		if(s==0 && e==0){
			System.out.println("Nao existe entrada/saida no meio");
		}
	}
		
	 public static void verifyInvalidChar(){
		 
		 int i = 0;
		 String[] position;
		 
		 i=(L*C);
		position = new String[i];
		i = 0;
		 try{
		 for(int q = 0; q<L; q++){
			 for(int w = 0; w<C; w++){
				 if (maze[q][w]!= ' ' && maze[q][w]!= '#' && maze[q][w]!='S' && maze[q][w]!='E'){
					 position[i] =q+","+w+" I:"+ maze[q][w] ;
					 i++;
				 	}
			 	}
		 	}
		 }
		 catch(Exception wawd){
			 System.out.println("Erro na verificacao");
		 }
		 
		 i=0;
		 if(position[i]==null){
			 System.out.println("Nao existe caracteres invalidos");
		 }
		 
		 if(position[i]!=null){
			 System.out.println("Caracteres invalidos\nL C");
			 while(position[i]!=null){
					 System.out.println(position[i]);
					 i++;
			 	
			 }
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
		return entL;
	}
	
	public static int getEntC(){
		return entC;
	}
	
	public static int getLine(){
		return L;
	}
	
	public static int getColumn(){
		return C;
	}
}
