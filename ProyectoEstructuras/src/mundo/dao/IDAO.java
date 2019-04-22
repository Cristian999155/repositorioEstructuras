package mundo.dao;

import mundo.db.Conexion;
import mundo.contenedora.Mensaje;
import mundo.contenedora.Nodo;

public interface IDAO 
{
	public void insertar(Conexion con, Mensaje message);
	public void eliminar(Conexion con, Mensaje message);
	public void actualizar(Conexion con, Mensaje message);
	public Nodo consultarTodos(Conexion con, Mensaje message);
	public Nodo consultar(Conexion con, Mensaje message);
}
