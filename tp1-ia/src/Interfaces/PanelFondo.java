package Interfaces;

	import java.awt.Dimension;
	import java.awt.Graphics;
	import javax.swing.ImageIcon;
	/**
	 * Permite abrir una imagen para usar en alguna de las ventantas.
	 * @author CAROLINA developers.
	 *
	 */
	public class PanelFondo extends javax.swing.JPanel {
		String url;
		public PanelFondo(String newUrl){
				this.setSize(25,25);
				this.url = newUrl;
		}
		@Override
		public void paintComponent (Graphics g){
			Dimension tamanio = getSize();
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource(url));
			g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}

