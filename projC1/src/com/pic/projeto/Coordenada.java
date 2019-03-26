package com.pic.projeto;

public class Coordenada {
	
	protected int L;
	protected int C;
	
	public Coordenada(int L, int C) {
		this.L = L;
		this.C = C;
	}
	
	public void setL(int L) {
		this.L = L;
	}
	public void setC(int C) {
		this.C = C;
	}
	public int getL() {
		return this.L;
	}
	public int getC() {
		return this.C;
	}
	public String toString() {
		return (Integer.toString(L)+','+Integer.toString(C));
	}
}	//fim
