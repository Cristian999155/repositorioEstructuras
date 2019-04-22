package mundo.facade;

import mundo.contenedora.Nodo;
import mundo.db.Conexion;
import mundo.contenedora.Mensaje;

public interface IFacade 
{
	public void insertar(Conexion con, Mensaje messa);
	public void eliminar(Conexion con, Mensaje messa);
	public void actualizar(Conexion con, Mensaje messa);
	public Nodo consultarTodos(Conexion con, Mensaje messa);
	public Nodo consultar(Conexion con, Mensaje messa);
}
