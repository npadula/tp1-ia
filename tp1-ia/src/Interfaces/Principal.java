package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

import domain.Nodo;

public class Principal extends JFrame implements ActionListener {

	public JFrame ventana = new JFrame();
	PanelImagen imagen = new PanelImagen("/imagenes/Fondo.jpg");
	PanelFondo auto = new PanelFondo("/imagenes/autito.png");
	PanelFondo nene = new PanelFondo("/imagenes/nene.png");
	PanelFondo aprox = new PanelFondo("/imagenes/sound.png");
	int columna = 0;
	int fila = 0;
	

	//grafica estado AGENTE
	public Principal(int columnaN, int filaN, Nodo nAuto,Nodo posAprox,Collection<Nodo> nodosObstaculos){//graficar el estado del agente inicial
		//nodos Agua, aqui se va rapido 
		//nodos lento, se va lento por ej: basura, etc 
		//nodos bloqueados, bloqueos o paredes
		//seteo imagen auto
		int autoPosix= nAuto.posX;
		int autoPosiy = nAuto.posY;
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		auto.setBounds(autoPosix, autoPosiy, 25, 25);
		auto.setSize(25, 25);
		ventana.add(auto);
		auto.setVisible(true);
		//seteo imagen aproximado 
		int aproxX= posAprox.posX;
		int aproxY= posAprox.posY;
		aprox.setBounds(aproxX, aproxY, 25, 25);
		aprox.setSize(25, 25);
		ventana.add(aprox);
		aprox.setVisible(true);
		
		for(Nodo n : nodosObstaculos){
			if(n.obstaculo){
				int bloqX = n.posX;
				int bloqY = n.posY;
				PanelFondo bloqueo = new PanelFondo("/imagenes/block.png");
				bloqueo.setBounds(bloqX, bloqY, 25, 25);
				bloqueo.setSize(25, 25);
				ventana.add(bloqueo);
				bloqueo.setVisible(true);
			}
		}

		ventana.add(imagen);
		columna = columnaN;
		fila = filaN;
		ventana.setSize((columna*25)+25,(fila*25)+25);
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.setLocation(300,0);	
		}
	
	//grafica estado AMBIENTE
	public Principal(int columnaN, int filaN, Nodo nAuto, Nodo nNene , Nodo posAprox,  Collection<Nodo> nodosObstaculos,ArrayList<Nodo> nodosAgua,ArrayList<Nodo> nodosLento){
		//nodos Agua, aqui se va rapido 
		//nodos lento, se va lento por ej: basura, etc 
		//nodos bloqueados, bloqueos o paredes
		
		//seteo imagen auto
		int autoPosix= nAuto.posX;
		int autoPosiy = nAuto.posY;
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		auto.setBounds(autoPosix, autoPosiy, 25, 25);
		auto.setSize(25, 25);
		ventana.add(auto);
		auto.setVisible(true);
		//seteo imagen nene
		int nenePosix= nNene.posX;
		int nenePosiy = nNene.posY;
		nene.setBounds(nenePosix, nenePosiy, 25, 25);
		nene.setSize(25, 25);
		ventana.add(nene);
		nene.setVisible(true);
		//seteo imagen aproximado 
		int aproxX= posAprox.posX;
		int aproxY= posAprox.posY;
		aprox.setBounds(aproxX, aproxY, 25, 25);
		aprox.setSize(25, 25);
		ventana.add(aprox);
		aprox.setVisible(true);
		
		//agrego agua a la imagen
		for(Nodo n : nodosAgua){
			int aguaX = n.posX;
			int aguaY = n.posY;
			PanelFondo agua = new PanelFondo("/imagenes/water.jpg");
			agua.setBounds(aguaX, aguaY, 25, 25);
			agua.setSize(25, 25);
			ventana.add(agua);
			agua.setVisible(true);
		}
		
		for(Nodo n : nodosLento){
			int lentoX = n.posX;
			int lentoY = n.posY;
			PanelFondo lento = new PanelFondo("/imagenes/basura.png");
			lento.setBounds(lentoX, lentoY, 25, 25);
			lento.setSize(25, 25);
			ventana.add(lento);
			lento.setVisible(true);
		}
		
		for(Nodo n : nodosObstaculos){
			if(n.obstaculo){
				int bloqX = n.posX;
				int bloqY = n.posY;
				PanelFondo bloqueo = new PanelFondo("/imagenes/block.png");
				bloqueo.setBounds(bloqX, bloqY, 25, 25);
				bloqueo.setSize(25, 25);
				ventana.add(bloqueo);
				bloqueo.setVisible(true);
			}
		}
		columna = columnaN;
		fila = filaN;
		ventana.add(imagen);
		ventana.setSize((columna*25)+25,(fila*25)+25);
		ventana.setVisible(true);
		ventana.setResizable(false);
		
		}
	
	public void actualizarPosicionAuto(Nodo nodoActual){
		auto.setBounds(nodoActual.posX,nodoActual.posY, 25, 25);
		auto.revalidate();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void graficarBloqueado(Nodo n){
		int bloqX = n.posX;
		int bloqY = n.posY;
		PanelFondo bloqueo = new PanelFondo("/imagenes/block.png");
		bloqueo.setBounds(bloqX, bloqY, 25, 25);
		bloqueo.setSize(25, 25);
		ventana.add(bloqueo);
		bloqueo.setVisible(true);
		ventana.add(imagen);
		ventana.setSize((columna*25)+25,(fila*25)+25);
		ventana.setVisible(true);
		ventana.setResizable(false);
		
	}
	public void graficarLento(Nodo n){
		int lentoX = n.posX;
		int lentoY = n.posY;
		PanelFondo lento = new PanelFondo("/imagenes/basura.png");
		lento.setBounds(lentoX, lentoY, 25, 25);
		lento.setSize(25, 25);
		ventana.add(lento);
		lento.setVisible(true);
		ventana.add(imagen);
		ventana.setSize((columna*25)+25,(fila*25)+25);
		ventana.setVisible(true);
		ventana.setResizable(false);
	}
	public void graficarRapido(Nodo n){
		int aguaX = n.posX;
		int aguaY = n.posY;
		PanelFondo agua = new PanelFondo("/imagenes/water.jpg");
		agua.setBounds(aguaX, aguaY, 25, 25);
		agua.setSize(25, 25);
		ventana.add(agua);
		agua.setVisible(true);
		ventana.add(imagen);
		ventana.setSize((columna*25)+25,(fila*25)+25);
		ventana.setVisible(true);
		ventana.setResizable(false);
	}
	public void graficarNinio(Nodo n){
		int neneX = n.posX;
		int neneY = n.posY;
		PanelFondo nene= new PanelFondo("/imagenes/nene.png");
		nene.setBounds(neneX, neneY, 25, 25);
		nene.setSize(25, 25);
		ventana.add(nene);
		nene.setVisible(true);
		ventana.add(imagen);
		ventana.setSize((columna*25)+25,(fila*25)+25);
		ventana.setVisible(true);
		ventana.setResizable(false);
	}
	public void agregarEscaleras(Collection<Nodo> values, ArrayList<String> escaleras) {
		for (Nodo nodoActual : values){
			if (escaleras.contains(nodoActual.Id)){
				PanelFondo escalera = new PanelFondo("/imagenes/escaleras.jpeg");
				escalera.setBounds(nodoActual.posX, nodoActual.posY, 25, 25);
				escalera.setSize(25, 25);
				ventana.add(escalera);
				escalera.setVisible(true);
				 
			}
		}
		ventana.add(imagen);
		ventana.setVisible(true);
		ventana.setResizable(false);
	}		
}
