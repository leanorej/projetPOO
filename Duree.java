package projetpoo;

public class Duree{
	//attributs
	protected int min;
	protected int sec;
	protected int h;
	
	public Duree(int s, int m, int h){
		this.sec = s;
		this.min = m;
		this.h = h;
	}
	
	public void setS(int s){
		this.sec = s;
	}

	public void setM(int m){
		this.min = m;
	}
	
	public void setH(int h){
		this.h = h;
	}
	
	public int getS(){
		return this.sec;
	}
	
	public int getM(){
		return this.min;
	}
	
	public int getH(){
		return this.h;
	}
	
	//public String toString(){}

}