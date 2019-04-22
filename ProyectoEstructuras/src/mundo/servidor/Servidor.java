package mundo.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import mundo.contenedora.Funcion;
import mundo.contenedora.Mensaje;
import mundo.contenedora.Nodo;
import mundo.db.Servicios;
import mundo.facade.Facade;

public class Servidor 
{
	
	public static final int PUERTO = 1425;
	public static final int NO_CONEXION = 20;
	private Servicios servicio;
	private ServerSocket server;
	
	public void escuchar() 
	{
		try
		{
			server = new ServerSocket(PUERTO, NO_CONEXION);
			servicio = new Servicios();

			while(true)
			{
				System.out.println("Esperando......");

				
				Socket cliente = server.accept();
				System.out.println("Hay un nuevo usuario");
				
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
				
				HiloServidor hilo = new HiloServidor(servicio.getCon(), ois, oos);
				hilo.start();
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		Servidor servidor =new Servidor(); 
		servidor.escuchar();
	}
	


}
