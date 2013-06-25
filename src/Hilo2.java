import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Hilo2 extends Thread{
	//hilo de bomba
	private ventana v;
	private Nodo posicion;
	private ListaOrtogonal lista;
	private ImageIcon bomba;
	private int jugador;
	private int poder;
	
	public Hilo2(ventana v,Nodo posicion,ListaOrtogonal lista,int jugador){
		this.v=v;
		this.posicion=posicion;
		this.lista=lista;
		this.jugador=jugador;
	}
	
	public void run(){
		if(jugador==1){
			poder=v.poder;
		}else{
			poder=v.poder2;
		}
		bomba=new ImageIcon("img/bombapasto2.gif");
		Icon icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[posicion.dato2].getWidth(), v.btn[posicion.dato2].getHeight(), Image.SCALE_DEFAULT));
		v.btn[posicion.dato2].setIcon(icono);
		
		posicion.dato=29;
		try {
			this.sleep(5900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posicion.dato=10;
		
		
		
		
		Nodo aux=posicion;
		
		for(int i=0; i<poder; i++){
			if(aux!=null){
				aux=aux.nodoDer;
			}
			
			if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){

				bomba=new ImageIcon("img/fuegopasto2.gif");
				icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
				v.btn[aux.dato2].setIcon(icono);
			}else{
				break;
			}
			
			
		}
		
		 aux=posicion;
		for(int i=0; i<poder; i++){
			if(aux!=null){
			aux=aux.nodoIzq;
			}
			if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){

				bomba=new ImageIcon("img/fuegopasto2.gif");
				icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
				v.btn[aux.dato2].setIcon(icono);
			}else{
				break;
			}
			
			
		}
		
		 aux=posicion;
			for(int i=0; i<poder; i++){
				if(aux!=null){
				aux=aux.nodoarriba;
				}
				if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){

					bomba=new ImageIcon("img/fuegopasto.gif");
					icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
					v.btn[aux.dato2].setIcon(icono);
				}else{
					break;
				}
				
				
			}
			
			 aux=posicion;
				for(int i=0; i<poder; i++){
					if(aux!=null){
					aux=aux.nodoabajo;
					}
					if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){

						bomba=new ImageIcon("img/fuegopasto.gif");
						icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
						v.btn[aux.dato2].setIcon(icono);
					}else{
						break;
					}
					
					
				}
		try {
			this.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 aux=posicion;
			if(aux.dato==1){
				v.perder();
				System.out.println("holis");
			}
		for(int i=0; i<poder; i++){
			if(aux!=null){
			aux=aux.nodoDer;
			}
			if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){
				if(aux.dato==1){
					v.perder();
				}
				aux.dato=10;
				bomba=new ImageIcon("img/pasto.png");
				icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
				v.btn[aux.dato2].setIcon(icono);
			}else{
				break;
			}
			
			
		}
		
		 aux=posicion;
			for(int i=0; i<poder; i++){
				if(aux!=null){
				aux=aux.nodoIzq;
				}
				if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){
					if(aux.dato==1){
						
						v.perder();
					}
					aux.dato=10;
					bomba=new ImageIcon("img/pasto.png");
					icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
					v.btn[aux.dato2].setIcon(icono);
				}else{
					break;
				}
				
				
			}
			
			 aux=posicion;
				for(int i=0; i<poder; i++){
					if(aux!=null){
					aux=aux.nodoarriba;
					}
					if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){
						if(aux.dato==1){
							v.perder();
						}
						aux.dato=10;
						bomba=new ImageIcon("img/pasto.png");
						icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
						v.btn[aux.dato2].setIcon(icono);
					}else{
						break;
					}
					
					
				}
				
				 aux=posicion;
					for(int i=0; i<poder; i++){
						if(aux!=null){
						aux=aux.nodoabajo;
						}
						if(aux!=null && (aux.dato==10 || aux.dato==1 || aux.dato>=50)){
							if(aux.dato==1){
								v.perder();
							}
							aux.dato=10;
							bomba=new ImageIcon("img/pasto.png");
							icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[aux.dato2].getWidth(), v.btn[aux.dato2].getHeight(), Image.SCALE_DEFAULT));
							v.btn[aux.dato2].setIcon(icono);
						}else{
							break;
						}
						
						
					}
			
			 
			bomba=new ImageIcon("img/pasto.png");
			icono = new ImageIcon(bomba.getImage().getScaledInstance(v.btn[posicion.dato2].getWidth(), v.btn[posicion.dato2].getHeight(), Image.SCALE_DEFAULT));
			v.btn[posicion.dato2].setIcon(icono);
			if(jugador==1){
				v.contbombas--;
			}else{
				v.contbombas2--;
			}
			
	}
	
}
