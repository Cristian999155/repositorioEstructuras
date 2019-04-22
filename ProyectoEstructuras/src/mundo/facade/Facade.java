package mundo.facade;

import mundo.contenedora.Nodo;
import mundo.contenedora.Tabla;
import mundo.dao.CancionesDAO;
import mundo.db.Conexion;
import mundo.contenedora.Mensaje;

public class Facade implements IFacade
{
	private CancionesDAO cancionesDao;
	
	public Facade()
	{
		cancionesDao = new CancionesDAO();
	}

	@Override
	public void insertar(Conexion con, Mensaje message) 
	{
		if(message.getTabla().equals(Tabla.canciones))
		{
			cancionesDao.insertar(con, message);
		}
	}



	@Override
	public void eliminar(Conexion con, Mensaje message) 
	{
		if(message.getTabla().equals(Tabla.canciones))
		{
			cancionesDao.eliminar(con, message);
		}
	}
	
	
	@Override
	public void actualizar(Conexion con, Mensaje message) 
	{	
		if(message.getTabla().equals(Tabla.canciones))
		{
			cancionesDao.actualizar(con, message);
		}
	}

	
	@Override
	public Nodo consultarTodos(Conexion con, Mensaje message) {

		Nodo nvo = new Nodo<>();
		{
			if(message.getTabla().equals(Tabla.canciones))
			{
				nvo = cancionesDao.consultarTodos(con, message);
			}
		}
		return nvo;
	}

	
	@Override
	public Nodo consultar(Conexion con, Mensaje message) 
	{
		Nodo nvo = new Nodo<>();
		{
			if(message.getTabla().equals(Tabla.canciones))
			{
				nvo = cancionesDao.consultar(con, message);
			}
		}
		return nvo;
	}

}
