package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBanner extends JPanel
{
	// -----------------------------------------------------
	// Atributos
	// -----------------------------------------------------
		
	/** Etiqueta para mostrar la imagen del banner.	 */
		private JLabel labImagen;
		
	// -----------------------------------------------------
	// Constructor
	// -----------------------------------------------------
		
    /** Crea el panel del banner. */
		
	public PanelBanner ( )
	{
		
		// Se crea el objeto del panel
		labImagen = new JLabel(new ImageIcon("data/disco.jpeg"));
			
		// Agregar el objeto al panel
		add( labImagen );
	}
	
}
