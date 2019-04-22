package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import mundo.contenedora.Tabla;


public class MenuInterfazSoundLife extends JMenuBar implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 46378926473L;

	public final static String CANCION = "Cancion";
	
	public final static String SALIR = "Salir"; 
	
    /**
     * El menu Archivo.
     */
    private JMenu menuArchivo;
    
    /**
     * La opcion para abrir el menu cancion.
     */
    private JMenuItem itemCancion;
    
    private InterfazSoundLife principal;
    
    private JMenuItem itemSalir;
    
    private Tabla tabla = null;
    
    
    public MenuInterfazSoundLife(InterfazSoundLife ia)
    {
    	principal = ia;
    	
    	menuArchivo = new JMenu( "Archivo" );
        menuArchivo.setMnemonic( KeyEvent.VK_A );
        add( menuArchivo );
        
        itemCancion = new JMenuItem("Consultar por cancion");
        itemCancion.setActionCommand(CANCION);
        itemCancion.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK ) );
        itemCancion.setMnemonic( KeyEvent.VK_A );
        itemCancion.addActionListener( (ActionListener) this );
        menuArchivo.add(itemCancion);
        
        menuArchivo.addSeparator();
        
        itemSalir = new JMenuItem( "Salir" );
        itemSalir.setActionCommand( SALIR );
        itemSalir.addActionListener( this );
        menuArchivo.add( itemSalir );
        
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		String comando = e.getActionCommand( );
		if(CANCION.equals(comando))
		{
			tabla = Tabla.canciones;
			DiagoloCancion cancion = new DiagoloCancion();
			cancion.setVisible(true);
		}
		if(SALIR.equals(comando))
		{
			principal.dispose();
		}
		
	}
    
}
