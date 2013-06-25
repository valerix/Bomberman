import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ventanaInicio extends JFrame{
	
	private JButton btnjugar;
	private Icon fondo;
	private JLabel img2;
	ImageIcon tierra;
	public ventanaInicio(){
		
		this.setSize(650, 658);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		btnjugar=new JButton("JUGAR");
		btnjugar.setBounds(250, 250, 100, 30);
		btnjugar.setVisible(true);
		this.add(btnjugar);
		this.repaint();
		
		img2=new JLabel();
		img2.setBounds(0, 0, 650, 658);
		this.add(img2);
		img2.repaint();
		tierra=new ImageIcon("img/fondo.jpg");
		Icon icono = new ImageIcon(tierra.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		img2.setIcon(icono);
		
		
		
		
		btnjugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ventana v=new ventana(1);
				ventanaInicio.this.dispose();
				
			}
		});
	}

}
