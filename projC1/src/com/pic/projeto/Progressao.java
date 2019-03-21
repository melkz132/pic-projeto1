package com.pic.projeto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Progressao {
	
	protected static char[][] maze;
	protected static int L;
	protected static int C;
	protected static int entL;
	protected static int entC;
	protected static int status = 0;
	
	public static void progress(){
		maze=Funcao.getMaze();
		entL=Funcao.getEntL();
		entC=Funcao.getEntC();
	
		Queue<String> fila = new LinkedList<>();
	
		fila.add(entL+","+entC);
	
		Stack<String> caminho = new Stack<>();
		caminho.push(fila.peek());
	
	
	}
	
}//fim
