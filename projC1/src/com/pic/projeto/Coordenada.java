package com.pic.projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Coordenada {
	
	protected static int L;
	protected static int C;
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
