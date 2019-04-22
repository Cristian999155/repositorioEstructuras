package mundo.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import mundo.contenedora.Mensaje;
import mundo.contenedora.Nodo;

public class Usuario 
{

	public final static int PUERTO = 1425;
	
	private String host = "localhost";
	
	private Socket cliente;
	
	public Usuario()
	{
		
	}
	
	public Nodo envioMensaje(Mensaje messa) throws UnknownHostException, IOException, ClassNotFoundException 
	{
		
		cliente = new Socket(host, PUERTO);
		System.out.println("Usuario Conectado!!");
		
		ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
	
		oos.writeObject(messa);
		
		ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
		
		Nodo nodo = (Nodo) ois.readObject();
		
		return nodo;
		
	}
}
