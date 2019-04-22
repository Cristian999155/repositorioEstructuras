package interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class InterfazSoundLife extends JFrame
{

	
	//-----------------------------------------------------------
	// Atributos de la interfaz
	//-----------------------------------------------------------

	/** Panel del banner */
	private PanelBanner panelBanner;
	
	private MenuInterfazSoundLife barraMenu;
	
	public InterfazSoundLife ( ) 
	{

		this.setTitle( "SoundLife" );
        this.setSize( 400, 250 );
        this.setResizable( false );
        

        
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    
        // Creacion de los paneles
        panelBanner = new PanelBanner( );
        
        barraMenu = new MenuInterfazSoundLife(this);
        this.setJMenuBar(barraMenu);
        
        
        // Distribuidor grafico en los bordes
        this.setLayout( new BorderLayout( ) );
        
        // Agrega los paneles a la interfaz
        this.add( panelBanner, BorderLayout.NORTH );
        setVisible(true);
        
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
        try
        {
            InterfazSoundLife interfaz = new InterfazSoundLife( );
            interfaz.setVisible( true );

        }
        catch( Exception e )
        {
        	e.printStackTrace();
        }
	}

}
