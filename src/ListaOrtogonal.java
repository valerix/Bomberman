


public class ListaOrtogonal {
	
		public Nodo primero;
		public Nodo ultimoRen;
		public Nodo ultimoColum;
		public Nodo renglonAnt;
		public Nodo arriba;
		private int tamanoRen;
		//private int tamanoColum; 
		public int contador=0;
		private int contador2=0;
		public int incremento=30;
		

		public int contador3=-1;
	
		public ListaOrtogonal()
		{
			this.primero=null;
			this.ultimoColum=null;
			this.ultimoRen=null;
			this.renglonAnt=null;
			 //this.tamanoColum=8;
			
			
		}
		
		

		//Metodo si la lista esta vacia
		public boolean siVacio()
		{
			return(this.primero==null);
		}
		
		
		//Metodo para agredar al final de la lista
		
		public  ListaOrtogonal addLast(int dato, int dato2)
		{
			//int contColumna=0;
			contador3++;
			if(siVacio())
			{
				arriba=null;
				Nodo nuevo=new Nodo(dato,dato2);
				primero=nuevo;
				ultimoRen=nuevo;
				ultimoColum=nuevo;
				contador++;
				nuevo.numero=contador3;
				//renglonAnt.nodoDer=nuevo;
			}
			else
			{
				if (contador<tamanoRen)
				{
					
					if(arriba!=null)
					{
						arriba=arriba.nodoDer;
					}
					Nodo nuevo=new Nodo(dato,dato2);
					nuevo.nodoarriba=arriba;
					nuevo.numero=contador3;
					if(arriba!=null)
					{
						arriba.nodoabajo=nuevo;
					}
					ultimoRen.nodoDer=nuevo;
					nuevo.nodoIzq=ultimoRen;
					ultimoRen=nuevo;
					nuevo.x=nuevo.nodoIzq.x+incremento;//agreda cordenada
					nuevo.y=nuevo.nodoIzq.y;
					
					contador++;
					
				}
				else			
				{
					contador=0;
					contador2++;
					Nodo nuevo=new Nodo(dato,dato2);
					nuevo.numero=contador3;
					ultimoRen=nuevo;
					arriba=ultimoColum;
					ultimoColum=nuevo;
					arriba.nodoabajo=nuevo;
					nuevo.nodoarriba=arriba;
					nuevo.x=nuevo.nodoarriba.x;
					nuevo.y=nuevo.nodoarriba.y+incremento;
					contador++;
				}
			//contColumna++;
			//return this;
			
		 }
			return this;
		
		
		}
		
		//regresa el nodo del numero que le digas
		public Nodo dameNodo(int i)
		{
			Nodo nodito=this.primero;
			Nodo inicio=this.primero;
			Nodo nodo=this.primero;
			int cont=0;
			while(nodito!=null)
			{
				while(nodito.nodoDer!=null)
				{
					
					if(cont==i)
					{
						nodo=nodito;
					}
					nodito=nodito.nodoDer;
					cont++;
							
				}
				
				nodito=inicio.nodoabajo;
				inicio=nodito;
				
			}
			return nodo;
		}
		
		public int getIncremento() {
			return incremento;
		}
		
		public int getTamanoRen() {
			return tamanoRen;
		}

		public void setTamanoRen(int tamanoRen) {
			this.tamanoRen = tamanoRen;
		}
		
}
