package com.pic.projeto;

public class Progressao {
	
	protected static char[][] maze;
	protected static int L;
	protected static int C;
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
	
	
	
	public static int progress(Pilha<Coordenada> caminho){
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
		
		Pilha<Coordenada> adjacente = null;
		
		try {
			adjacente = new Pilha <Coordenada>(3);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Coordenada coordenada = new Coordenada(-1,-1);
		
		try {
			if (maze[L][C+1] == ' '){
				coordenada.setL(L);
				coordenada.setC(C+1);
				adjacente.guarde(coordenada);
			}
				} catch (Exception e) {
					
					
				}
		
		try {
		if (maze[L+1][C] == ' '){
				coordenada.setL(L+1);
				coordenada.setC(C);
				adjacente.guarde(coordenada);
		}
				} catch (Exception e) {
					
				}
		
		
		try {
				if (maze[L][C-1] == ' '){
					coordenada.setL(L);
					coordenada.setC(C-1);
					adjacente.guarde(coordenada);
				}
					} catch (Exception e) {
						
						
					}
		
		try {
		if (maze[L-1][C] == ' '){
			coordenada.setL(L-1);
			coordenada.setC(C);
			adjacente.guarde(coordenada);
		}
			} catch (Exception e) {
				
			}
		
		
		
	
		
	}//verify
	
	
	public static void showPosition(Pilha<Coordenada> caminho) {
		Coordenada posicao = null;
		try {
			posicao = caminho.getValor();
			System.out.println(posicao.getL()+","+posicao.getC());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		public static void positionPlusOne(Pilha<Coordenada> caminho){
			
			try {
				Coordenada entrada = new Coordenada(5,5);
				caminho.guarde(entrada);
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
			
			//caminho.guarde());
		}
		
	
	
}//fim
