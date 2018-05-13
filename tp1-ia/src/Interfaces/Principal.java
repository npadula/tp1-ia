package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import domain.Nodo;

public class Principal extends JFrame implements ActionListener {

	JFrame ventana = new JFrame();
	PanelImagen imagen = new PanelImagen("/imagenes/Fondo.png");
	PanelFondo auto = new PanelFondo("/imagenes/autito.png");
	PanelFondo nene = new PanelFondo("/imagenes/nene.png");
	
	public Principal(Nodo nAuto, Nodo nNene){
		int autoPosix= nAuto.posX;
		int autoPosiy = nAuto.posY;
		//ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		auto.setBounds(autoPosix, autoPosiy, 25, 25);
		auto.setSize(25, 25);
		ventana.add(auto);
		auto.setVisible(true);
		int nenePosix= nNene.posX;
		int nenePosiy = nNene.posY;
		//ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nene.setBounds(nenePosix, nenePosiy, 25, 25);
		nene.setSize(25, 25);
		ventana.add(nene);
		nene.setVisible(true);
		ventana.add(imagen);
		ventana.setSize(700,830);
		ventana.setVisible(true);
		ventana.setResizable(false);
		
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarPosicionAuto(Nodo nodoActual){
		auto.setBounds(nodoActual.posX,nodoActual.posY, 25, 25);
		auto.revalidate();
	}
	
}
