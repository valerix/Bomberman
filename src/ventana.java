import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ventana extends JFrame implements KeyListener{
	
	public JLabel [] btn;
	private int cont=0;
	private ImageIcon tierra;
	private JLabel btnBoomber;
	private JLabel btnBoomber2;
	private Nodo bomber2;
	private Nodo bomber;
	public boolean bandera=true;
	public boolean bandera2=true;
	private ListaOrtogonal l;
	public int contbombas=0;
	public int bombasmax=1; 
	public int contbombas2=0;
	public int bombasmax2=1; 
	public int poder=2;
	public int velocidad=30;
	public int poder2=2;
	public int velocidad2=30;
	private int nivel;
	
	public ventana(int nivel){
		this.setSize(650, 658);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		addKeyListener(this);
		this.nivel=nivel;
		
		int matriz[][]= new int [20][20];

		int matriz0[][]={{20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,10},
						{20,10,10,10,50,50,50,50,50,50,50,50,50,50,10,50,10,10,20,10},
						{20,10,20,20,20,50,20,20,20,13,20,20,20,10,20,20,20,10,20,10},
						{20,50,20,20,20,10,20,20,20,10,20,20,20,10,20,20,20,10,20,10},
						{20,50,20,20,20,10,20,20,20,10,20,20,20,10,20,20,20,50,20,10},
						{20,50,50,50,10,50,10,50,50,50,10,50,50,50,11,50,50,50,20,10},
						{20,10,20,20,20,10,20,20,20,12,20,20,20,10,20,20,20,10,20,10},
						{20,10,20,20,20,10,20,20,20,10,20,20,20,10,20,20,20,50,20,10},
						{20,50,20,20,20,10,20,20,20,50,20,20,20,50,20,20,20,50,20,10},
						{20,50,10,10,12,10,10,10,10,50,10,13,10,50,10,10,10,50,20,10},
						{20,50,20,20,20,10,20,20,20,50,20,20,20,50,20,20,20,10,20,10},
						{20,10,20,20,20,50,20,20,20,50,20,20,20,50,20,20,20,50,20,10},
						{20,50,20,20,20,50,20,20,20,50,20,20,20,10,20,20,20,50,20,10},
						{20,50,50,50,50,10,50,50,50,10,50,50,50,11,10,50,50,50,20,10},
						{20,50,20,20,20,10,20,20,20,11,20,20,20,10,20,20,20,10,20,10},
						{20,10,20,20,20,10,20,20,20,10,20,20,20,13,20,20,20,50,20,10},
						{20,10,20,20,20,12,20,20,20,10,20,20,20,10,20,20,20,10,20,10},
						{20,10,10,50,50,50,50,50,50,50,50,50,50,50,50,50,10,10,20,10},
						{20,10,20,20,20,50,20,20,20,50,20,20,20,50,20,20,20,50,20,10},
						{20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,10}};
		
		int matriz1[][]={{22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,10},
				{22,10,10,10,51,51,51,51,51,51,51,51,51,51,51,10,10,10,22,10},
				{22,22,10,22,51,22,51,22,51,22,51,22,51,22,51,22,12,22,22,10},
				{22,10,51,51,51,51,51,51,51,51,51,51,51,51,51,51,10,10,22,10},
				{22,10,22,10,22,13,22,10,22,10,22,10,22,10,22,10,22,10,22,10},
				{22,10,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,22,10},
				{22,22,10,22,10,22,10,22,10,22,10,22,10,22,10,22,10,22,22,10},
				{22,10,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,10,22,10},
				{22,10,22,10,22,10,22,10,22,11,22,10,22,10,22,10,22,10,22,10},
				{22,51,10,10,51,11,13,10,10,51,51,51,51,10,10,10,10,10,22,10},
				{22,22,10,22,51,22,10,22,10,22,10,22,51,22,51,22,13,22,22,10},
				{22,51,10,10,51,10,10,10,10,51,10,10,10,10,51,10,10,10,22,10},
				{22,10,22,10,22,10,22,10,22,51,22,10,22,10,22,10,22,51,22,10},
				{22,51,51,51,10,51,10,51,10,151,10,10,10,10,51,10,51,10,22,10},
				{22,22,10,22,10,22,10,22,10,22,10,22,10,22,51,22,51,22,22,10},
				{22,51,10,51,12,10,10,10,10,10,10,10,10,11,10,10,51,10,22,10},
				{22,10,22,51,22,10,22,10,22,10,22,10,22,10,22,10,22,10,22,10},
				{22,10,10,51,51,51,51,51,51,51,10,51,10,51,10,10,10,10,22,10},
				{22,22,10,22,10,22,10,22,12,22,10,22,10,22,10,22,10,22,22,10},
				{22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,10}};
		
		int matriz2[][]={{21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,52},
				{21,10,10,10,52,52,52,52,52,52,52,52,52,52,52,52,10,10,21,52},
				{21,10,10,52,52,52,52,52,52,52,52,52,52,52,52,52,52,13,21,52},
				{21,11,21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,10,21,52},
				{21,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,21,52},
				{21,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,21,52},
				{21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,52},
				{21,52,52,52,10,10,52,52,52,10,52,52,52,52,52,52,52,52,21,52},
				{21,52,52,52,10,10,52,52,52,11,52,52,52,52,52,52,52,52,21,52},
				{21,52,21,52,21,10,21,52,21,12,21,52,21,52,21,52,21,52,21,52},
				{21,52,52,52,52,52,52,52,52,10,10,10,52,52,52,52,52,52,21,52},
				{21,52,52,52,52,13,52,52,52,52,52,10,10,12,52,52,52,52,21,52},
				{21,52,21,52,21,10,21,52,21,52,21,52,21,10,21,52,21,52,21,52},
				{21,52,52,52,52,52,52,52,52,52,52,52,52,10,52,52,52,52,21,52},
				{21,52,52,52,52,52,52,52,52,52,52,52,52,13,52,52,52,52,21,52},
				{21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,52,21,52},
				{21,10,12,52,52,52,52,52,52,52,52,52,52,10,11,52,10,52,21,52},
				{21,10,10,52,52,52,52,52,52,52,52,52,52,52,52,52,10,10,21,52},
				{21,10,21,10,21,52,21,52,21,52,21,52,21,52,21,52,21,10,21,52},
				{21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,52}};
		
		for(int i=0; i<20; i++){
			for(int j=0; j<20; j++){
				
				switch(nivel){
				case 1:
					matriz[i][j]=matriz0[i][j];
					break;
				case 2:
					matriz[i][j]=matriz1[i][j];
					break;
				case 3:
					matriz[i][j]=matriz2[i][j];
					break;
				}
			}
		}
		
		l=new ListaOrtogonal();
		l.setTamanoRen(20);
		
		btn=new JLabel[400];
		int contMatriz=0;
		int contMatriz2=0;
		//System.out.println(matriz[1][1]);
		for(int i=0; i<400; i++){
			l.addLast(matriz[contMatriz2][contMatriz], i);
			contMatriz++;
			if(contMatriz>=20){
				contMatriz2++;
				contMatriz=0;
			}
		}
		/*for(int i=0; i<400; i++){
			l.addLast(matriz1[contMatriz2][contMatriz], 1);
			contMatriz++;
			if(contMatriz>=20){
				contMatriz2++;
				contMatriz=0;
			}
		}*/
		
		
		
		Nodo n=l.primero;
		Nodo inicio=l.primero;

		btnBoomber=new JLabel();
		btnBoomber.setBounds(50, 50, 30, 30);
		this.add(btnBoomber);
		btnBoomber.repaint();
		tierra=new ImageIcon("img/bderecha.gif");
		Icon icono = new ImageIcon(tierra.getImage().getScaledInstance(btnBoomber.getWidth(), btnBoomber.getHeight(), Image.SCALE_DEFAULT));
		btnBoomber.setIcon(icono);
		
		bomber2=l.primero;
		for(int i=0; i<17; i++){
			bomber2=bomber2.nodoDer.nodoabajo;
		}
		btnBoomber2=new JLabel();
		btnBoomber2.setBounds(bomber2.x,bomber2.y, 30, 30);
		this.add(btnBoomber2);
		btnBoomber2.repaint();
		tierra=new ImageIcon("img/bomberman2_various_she.gif");
		icono = new ImageIcon(tierra.getImage().getScaledInstance(btnBoomber2.getWidth(), btnBoomber2.getHeight(), Image.SCALE_DEFAULT));
		btnBoomber2.setIcon(icono);
		
		while(n!=null)
		{
			while(n.nodoDer!=null)
			{
				btn[cont]=new JLabel();
				n.dato2=cont;
				btn[cont].setBounds(n.x, n.y, l.incremento, l.incremento);
				//btn[cont].setText(Integer.toString(n.dato));
				switch(n.dato){
				case 10:
					tierra=new ImageIcon("img/pasto.png");
					break;
				case 11:
					tierra=new ImageIcon("img/poderfuego.png");
					break;
				case 12:
					tierra=new ImageIcon("img/podercorrer.png");
					break;
				case 13:
					tierra=new ImageIcon("img/poderbomba.png");
					break;
				case 20:
					tierra=new ImageIcon("img/roca.png");
					break;
				case 21:
					tierra=new ImageIcon("img/pastocono.gif");
					break;
				case 22:
					tierra=new ImageIcon("img/pisogris.png");
					break;
				case 50:
					tierra=new ImageIcon("img/arbolito.png");
					break;
				case 51:
					tierra=new ImageIcon("img/ladrillogris.png");
					break;
				case 52:
					tierra=new ImageIcon("img/llantapasto.gif");
					break;
				case 1:
					tierra=new ImageIcon("img/derr.gif");
					break;
				}

				 icono = new ImageIcon(tierra.getImage().getScaledInstance(btn[cont].getWidth(), btn[cont].getHeight(), Image.SCALE_DEFAULT));
				btn[cont].setIcon(icono);
				btn[cont].setLayout(null);
				
				n=n.nodoDer;
				this.add(btn[cont]);
				cont++;
			}
			n=inicio.nodoabajo;
			inicio=n;
		}
		
		
	
		this.repaint();
		
		bomber=l.primero.nodoDer.nodoabajo;
		
	
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("se oprimio una tecla yupi "+e.getKeyCode());
		switch(e.getKeyCode()){
			case 39:
				if(bomber.nodoDer.dato<20 && bandera){
					bandera=false;
					Hilo1 h=new Hilo1(btnBoomber,bomber,bomber.nodoDer,1,this,1);
					
					Thread t=new Thread(h);
					t.start();
					bomber.dato=10;
					bomber=bomber.nodoDer;
					
					if(bomber.dato==11){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						poder++;
					}else if(bomber.dato==12){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						velocidad-=5;
					}else if(bomber.dato==13){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						bombasmax++;
					}
					bomber.dato=1;
				}
				break;
			case 37:
				if(bomber.nodoIzq.dato<20 && bandera){
					bandera=false;
					Hilo1 h2=new Hilo1(btnBoomber,bomber,bomber.nodoIzq,2,this,1);
					
					Thread t2=new Thread(h2);
					t2.start();
					bomber.dato=10;
					bomber=bomber.nodoIzq;
				
					if(bomber.dato==11){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						poder++;
					}else if(bomber.dato==12){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						velocidad-=5;
					}else if(bomber.dato==13){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						bombasmax++;
					}
					bomber.dato=1;
				}
				break;
			case 38:
				if(bomber.nodoarriba.dato<20 && bandera){
					bandera=false;
					Hilo1 h3=new Hilo1(btnBoomber,bomber,bomber.nodoarriba,3,this,1);
					
					Thread t3=new Thread(h3);
					t3.start();
					bomber.dato=10;
					bomber=bomber.nodoarriba;
					
					if(bomber.dato==11){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						poder++;
					}else if(bomber.dato==12){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						velocidad-=5;
					}else if(bomber.dato==13){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						bombasmax++;
					}
					bomber.dato=1;
				}
				break;
			case 40:
				if(bomber.nodoabajo.dato<20 && bandera){
					bandera=false;
					Hilo1 h4=new Hilo1(btnBoomber,bomber,bomber.nodoabajo,4,this,1);
					
					Thread t4=new Thread(h4);
					t4.start();
					bomber.dato=10;
					bomber=bomber.nodoabajo;
					
					if(bomber.dato==11){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						poder++;
					}else if(bomber.dato==12){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						velocidad-=5;
					}else if(bomber.dato==13){
						bomber.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber.dato2].getWidth(), btn[bomber.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber.dato2].setIcon(icono);
						bombasmax++;
					}
					bomber.dato=1;
				}
				break;
			case 32:
				if(contbombas2<bombasmax2){
					contbombas2++;
				
				Hilo2 hilo2=new Hilo2(this,bomber2,l,2);
				Thread bomba=new Thread(hilo2);
				bomba.start();
				}
				
				break;
			case 17:
				if(contbombas<bombasmax){
					contbombas++;
				
				Hilo2 hilo2=new Hilo2(this,bomber,l,1);
				Thread bomba=new Thread(hilo2);
				bomba.start();
				}
				
				break;
			case 87:

				if(bomber2.nodoarriba.dato<20 && bandera2){
					bandera2=false;
					Hilo1 h3=new Hilo1(btnBoomber2,bomber2,bomber2.nodoarriba,3,this,2);
					
					Thread t3=new Thread(h3);
					t3.start();
					bomber2.dato=10;
					bomber2=bomber2.nodoarriba;
					
					if(bomber2.dato==11){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						poder2++;
					}else if(bomber2.dato==12){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						velocidad2-=5;
					}else if(bomber2.dato==13){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						bombasmax2++;
					}
					bomber2.dato=1;
				}
				
				break;
			case 83:

		if(bomber2.nodoabajo.dato<20 && bandera2){
			bandera2=false;
			Hilo1 h4=new Hilo1(btnBoomber2,bomber2,bomber2.nodoabajo,4,this,2);

				Thread t4=new Thread(h4);
				t4.start();
				bomber2.dato=10;
				bomber2=bomber2.nodoabajo;
				
				if(bomber2.dato==11){
					bomber2.dato=10;
					ImageIcon bomba=new ImageIcon("img/pasto.png");
					Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
					btn[bomber2.dato2].setIcon(icono);
					poder2++;
				}else if(bomber2.dato==12){
					bomber2.dato=10;
					ImageIcon bomba=new ImageIcon("img/pasto.png");
					Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
					btn[bomber2.dato2].setIcon(icono);
					velocidad2-=5;
				}else if(bomber2.dato==13){
					bomber2.dato=10;
					ImageIcon bomba=new ImageIcon("img/pasto.png");
					Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
					btn[bomber2.dato2].setIcon(icono);
					bombasmax2++;
				}
				bomber2.dato=1;
			}
		break;
			case 68:
				if(bomber2.nodoDer.dato<20 && bandera2){
					bandera2=false;
					Hilo1 h=new Hilo1(btnBoomber2,bomber2,bomber2.nodoDer,1,this,2);
					
					Thread t=new Thread(h);
					t.start();
					bomber2.dato=10;
					bomber2=bomber2.nodoDer;
					
					if(bomber2.dato==11){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						poder2++;
					}else if(bomber2.dato==12){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						velocidad2-=5;
					}else if(bomber2.dato==13){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						bombasmax2++;
					}
					bomber2.dato=1;
				}
				break;
			case 65:
				if(bomber2.nodoIzq.dato<20 && bandera2){
					bandera2=false;
					Hilo1 h2=new Hilo1(btnBoomber2,bomber2,bomber2.nodoIzq,2,this,2);
					
					Thread t2=new Thread(h2);
					t2.start();
					bomber2.dato=10;
					bomber2=bomber2.nodoIzq;
				
					if(bomber2.dato==11){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						poder2++;
					}else if(bomber2.dato==12){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						velocidad2-=5;
					}else if(bomber2.dato==13){
						bomber2.dato=10;
						ImageIcon bomba=new ImageIcon("img/pasto.png");
						Icon icono= new ImageIcon(bomba.getImage().getScaledInstance(btn[bomber2.dato2].getWidth(), btn[bomber2.dato2].getHeight(), Image.SCALE_DEFAULT));
						btn[bomber2.dato2].setIcon(icono);
						bombasmax2++;
					}
					bomber2.dato=1;
				}
				break;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void perder(){
		System.out.println("Perdiste");
		tierra=new ImageIcon("img/XD.gif");
		Icon icono = new ImageIcon(tierra.getImage().getScaledInstance(btnBoomber.getWidth(), btnBoomber.getHeight(), Image.SCALE_DEFAULT));
		btnBoomber.setIcon(icono);
		if(nivel<3){
		ventana v=new ventana(nivel+1);
		}else{
			ventanaInicio ven=new ventanaInicio();
		}
		
		ventana.this.dispose();
		
	}


}

