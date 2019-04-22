package mundo.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mundo.contenedora.Funcion;
import mundo.contenedora.Mensaje;
import mundo.contenedora.Nodo;
import mundo.db.Conexion;
import mundo.facade.Facade;

public class HiloServidor extends Thread
{
	/**
	 * atributo que representa la conexion
	 */
	private Conexion con;
	
	/**
	 * atributo que representa el flujo de entrada
	 */
	private ObjectInputStream ois;
	
	/**
	 * atributo que representa el flujo de salida
	 */
	private ObjectOutputStream oos;
	
	/**
	 * atributo que representa el facade
	 */
	private Facade facade;
	
	
	public HiloServidor(Conexion pConexion, ObjectInputStream pOis, ObjectOutputStream pOos )
	{
		con = pConexion;
		ois = pOis;
		oos = pOos;
		facade = new Facade();
	}
	
	private void procesaInstrucciones() throws ClassNotFoundException, IOException
	{
		System.out.println("Esperando..."); 

		while(true)
		{
			System.out.println("Se ha conectado un nuevo usuario.");
			
			Mensaje messa = (Mensaje) ois.readObject();
			Nodo nodo = new Nodo<>();
			
			if(messa.getFuncion().equals(Funcion.INSERT))
			{
				facade.insertar(con, messa);
				nodo = null;
			}
			else if(messa.getFuncion().equals(Funcion.DELETE))
			{
				facade.eliminar(con, messa);
				nodo = null;
			}
			else if(messa.getFuncion().equals(Funcion.UPDATE))
			{
				facade.actualizar(con, messa);
				nodo = null;
			}
			else if(messa.getFuncion().equals(Funcion.SELECT))
			{
				nodo = facade.consultarTodos(con, messa);
			}
			else if(messa.getFuncion().equals(Funcion.SELECT_ID))
			{
				nodo = facade.consultar(con, messa);
			}
			
			oos.writeObject(nodo);

		}
		
	}
	
	
	public void run()
	{
		try
		{
			procesaInstrucciones();
		}
		catch(Exception e )
		{
			
		}
		
	}
	
	
	

}
