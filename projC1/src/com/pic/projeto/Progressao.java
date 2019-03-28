package com.pic.projeto;

public class Progressao {
	
	protected static char[][] maze;
	protected static int entL;
	protected static int entC;
	protected static int status = 0;
	
	public static void positionEntrance(Pilha<Coordenada> caminho){
		entL=Funcao.getEntL();
		entC=Funcao.getEntC();
		try {

			Coordenada entrada = new Coordenada(entL,entC);
			caminho.guarde(entrada);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//caminho.guarde());
	}
	
	
	
	public static int progress(Pilha<Coordenada> caminho,Pilha<Pilha<Coordenada>> possibilidades) throws Exception{
		//verifica posicao em volta, guarda atual,guarda possibilidade,vai pra adjacente, repeat
		//condicao: acha fim do lab, acha sem saida
		int L;
		int C;
		
		Coordenada coordenada = null;//atual
		
		maze = Funcao.getMaze();
		
		try {
			coordenada = caminho.getValor();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		L = coordenada.getL();
		C = coordenada.getC();
		int qwe = 3;
		
		Pilha<Coordenada> adjacente = new Pilha <Coordenada>(qwe);
		
		/*try {
			adjacente = new Pilha <Coordenada>(3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		boolean sucess;
		sucess = verifyAdjacentExit(L,C);
		
		if(sucess == true){
			return status = 4;
		}
		
		verifyAdjacent(L,C,adjacente);
		
		try {
			
			coordenada = adjacente.getValor();
			
			
			
			if(coordenada.getL() == -1 || coordenada.getC() == -1){
				
				return status = 1;
			}
			else if(adjacente.isVazia()){
				
				return status = 1;
			}
			else{
			
			
			maze[coordenada.getL()][coordenada.getC()]='*';
			caminho.guarde(coordenada);
			
			
			adjacente.jogueForaValor();
			possibilidades.guarde(adjacente);
			//showStack(adjacente);
			//System.out.println("a:"+adjacente.getQuantos());
			//showPosition(adjacente);
			
			}
		} catch (Exception e) {
			
			return status = 1;
		}
		

		return status = 0;
		
	}//progress
	
	public static void verifyAdjacent(int L, int C,Pilha<Coordenada> adjacente){
		//1,0
		//S +1L
		//N -1L
		//E -1C
		//D +1C
		
		//Coordenada coordenada = new Coordenada(-1,-1);
		
		
		
		try{
			if (maze[L+1][C] == ' '){
				//coordenada.setL(L+1);
				//coordenada.setC(C);
				Coordenada coordenada1 = new Coordenada(L+1,C);
				adjacente.guarde(coordenada1);
				
				
			}
		} catch (Exception e) {
			
		}
		
			try{
			if (maze[L][C-1] == ' '){
				//coordenada.setL(L);
				//coordenada.setC(C-1);
				Coordenada coordenada2 = new Coordenada(L,C-1);
				adjacente.guarde(coordenada2);
				
				
			}
			} catch (Exception e) {
				
			}
			
			try{
			if (maze[L-1][C] == ' '){
				//coordenada.setL(L-1);
				//coordenada.setC(C);
				Coordenada coordenada3 = new Coordenada(L-1,C);
				adjacente.guarde(coordenada3);
				
				
							}
			} catch (Exception e) {
				
			}
		
			try {
				if (maze[L][C+1] == ' '){
					//coordenada.setL(L);
					//coordenada.setC(C+1);
					Coordenada coordenada4 = new Coordenada(L,C+1);
					adjacente.guarde(coordenada4);
					
				}
					} catch (Exception e) {
			
					}
	}//verify
	
	public static boolean verifyAdjacentExit(int L, int C){
		//1,0
		//S +1L
		//N -1L
		//E -1C
		//D +1C
	try{
			if (maze[L+1][C] == 'S'){
				return true;
			}
			
			if (maze[L][C-1] == 'S'){
				return true;
			}
			
			if (maze[L-1][C] == 'S'){
				return true;
			}
			
			if (maze[L][C+1] == 'S'){
				return true;
			}
	}
	catch(Exception e){
		return false;
	}
			return false;
	}//verify exit
	
	public static void showPosition(Pilha<Coordenada> caminho) {
		Coordenada posicao = null;
		try {
			posicao = caminho.getValor();
			System.out.println(posicao.getL()+","+posicao.getC());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showStack(Pilha<Coordenada> caminho) {
		Coordenada posicao = null;
		try {
			while(!caminho.isVazia()){
			posicao = caminho.getValor();
			System.out.println(posicao.getL()+","+posicao.getC());
			caminho.jogueForaValor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

		
	
	
}//fim
