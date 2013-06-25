import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Hilo1 extends Thread{
	//hilo de bomber movimiemtos
	private JLabel lbl;
	private ImageIcon tierra;
	private Nodo origen;
	private Nodo destino;
	private int direccion;
	public ventana vent;
	public int jugador;

	public Hilo1(JLabel l,Nodo origen,Nodo destino,int direccion, ventana v,int jugador){
		lbl=l;
		this.origen=origen;
		this.destino=destino;
		this.direccion=direccion;
		vent=v;
		this.jugador=jugador;
	}
	
	public void run(){
		
		switch(direccion){
		case 1:
			if(jugador==1){
			tierra=new ImageIcon("img/der.gif");
			}else{
				tierra=new ImageIcon("img/derec.gif");
			}
			Icon icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			while(lbl.getX()<destino.getX()){
				lbl.setBounds(lbl.getX()+1, lbl.getY(), lbl.getWidth(), lbl.getHeight());
				try {
					this.sleep(vent.velocidad);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(jugador==1){
			tierra=new ImageIcon("img/bomberd.gif");
			}else{
				tierra=new ImageIcon("img/bomberman2_various_sheebgt.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			if(jugador==1){
				vent.bandera=true;
			}else{
				vent.bandera2=true;
			}
			
			break;
		case 2:
			if(jugador==1){
			tierra=new ImageIcon("img/izq.gif");
			}else{
				tierra=new ImageIcon("img/izqi.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			while(lbl.getX()>destino.getX()){
				lbl.setBounds(lbl.getX()-1, lbl.getY(), lbl.getWidth(), lbl.getHeight());
				try {
					this.sleep(vent.velocidad);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(jugador==1){
			tierra=new ImageIcon("img/1.gif");
			}else{
				tierra=new ImageIcon("img/bomberman2_various_she.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			if(jugador==1){
				vent.bandera=true;
			}else{
				vent.bandera2=true;
			}
			break;
		case 3:
			if(jugador==1){
			tierra=new ImageIcon("img/arriba2.gif");
			}else{
				tierra=new ImageIcon("img/arrib.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			while(lbl.getY()>destino.getY()){
				lbl.setBounds(lbl.getX(), lbl.getY()-1, lbl.getWidth(), lbl.getHeight());
				try {
					this.sleep(vent.velocidad);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(jugador==1){
			tierra=new ImageIcon("img/1a.gif");
			}else{
				tierra=new ImageIcon("img/fdsa.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			if(jugador==1){
				vent.bandera=true;
			}else{
				vent.bandera2=true;
			}
			break;
		case 4:
			if(jugador==1){
			tierra=new ImageIcon("img/abajo2.gif");
			}else{
				tierra=new ImageIcon("img/abaj.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			while(lbl.getY()<destino.getY()){
				lbl.setBounds(lbl.getX(), lbl.getY()+1, lbl.getWidth(), lbl.getHeight());
				try {
					this.sleep(vent.velocidad);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(jugador==1){
			tierra=new ImageIcon("img/3abajo.gif");
			}else{
				tierra=new ImageIcon("img/b.gif");
			}
			 icono = new ImageIcon(tierra.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
			lbl.setIcon(icono);
			if(jugador==1){
				vent.bandera=true;
			}else{
				vent.bandera2=true;
			}			
			break;
		}
		
		
	}
}
