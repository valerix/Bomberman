
public class Nodo {
	
	Nodo nodoIzq=null;
	Nodo nodoDer=null;
	Nodo nodoarriba=null;
	Nodo nodoabajo=null;
	int dato;//color del boton
	int dato2;//tipo de ficha
	int numero;//numero del nodo
	int x;
	int y;
	int primerMov;
	
	public Nodo(int dato,int dato2)
	{
		this.dato=dato;
		this.dato2=dato2;
		this.nodoabajo=null;
		this.nodoarriba=null;
		this.nodoDer=null;
		this.nodoIzq=null;
		this.numero=0;
		this.x=20;
		this.y=20;
		this.primerMov=0;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

}
