package Interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 * Permite abrir una imagen para usar en alguna de las ventantas.
 * @author .
 *
 */
public class PanelImagen extends javax.swing.JPanel {
	private String ubicacionImagen = "";
	public PanelImagen(String nuevaUbicacion){
			this.setSize(825,675);
			ubicacionImagen = nuevaUbicacion;
	}
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource(ubicacionImagen));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}