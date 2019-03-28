package com.pic.projeto;

public class Regressao {
	
	protected static char[][] maze;
	protected static int status = 1;
	
	public static int regress(Pilha<Coordenada> caminho,Pilha<Pilha<Coordenada>> possibilidades){
		//verifica posibliidade, verifica atual, volta, repeat
		//condicao: acha na posibilidade, acha fim do atual.
		
		maze = Funcao.getMaze();
		
		if(possibilidades.isVazia()){
			return status = 5;
		}
		Pilha<Coordenada> aux;
		try {
			aux = new Pilha <Coordenada>(Funcao.getLine()*Funcao.getColumn());
			aux = possibilidades.getValor();
			
			if(aux.isVazia()){
				Coordenada posicao = null;
				posicao = caminho.getValor();
				maze[posicao.getL()][posicao.getC()] = ' ';
				caminho.jogueForaValor();
				possibilidades.jogueForaValor();
				return status = 1;
			}
			
			if(!aux.isVazia()){
			Coordenada posicao = null;
			posicao = caminho.getValor();
			maze[posicao.getL()][posicao.getC()] = ' ';
			caminho.jogueForaValor();
			posicao = aux.getValor();
			maze[posicao.getL()][posicao.getC()] = '*';
			caminho.guarde(posicao);
			aux.jogueForaValor();
			return status = 0;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status = 1;
	}
}
