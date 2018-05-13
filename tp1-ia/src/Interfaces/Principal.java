package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Principal extends JFrame implements ActionListener {

	JFrame ventana = new JFrame();
	PanelImagen imagen = new PanelImagen("/imagenes/Fondo.png");
	PanelFondo auto = new PanelFondo();
	
	public Principal(){
		int posix= 0;
		int posiy = 0;
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		auto.setBounds(posix, posiy, 25, 25);
		auto.setSize(25, 25);
		ventana.add(auto);
		auto.setVisible(true);
		ventana.add(imagen);
		ventana.setSize(830,700);
		ventana.setVisible(true);
		ventana.setResizable(false);
		System. out. println("Posicion del auto: [" + posix + ", " + posiy + "]");
		while(posix>=0 && posix<800){
			while(posiy<650){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				posiy+= 25;
				auto.setBounds(posix,posiy, 25, 25);
				auto.revalidate();
				System. out. println("Posicion del auto: [" + posix + ", " + posiy + "]");
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			posiy = 0;
			posix += 25;
			auto.setBounds(posix,posiy, 25, 25);
			auto.revalidate();
			System. out. println("Posicion del auto: [" + posix + ", " + posiy + "]");
			}
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
