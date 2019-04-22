package mundo.dao;

import mundo.contenedora.Nodo;
import mundo.db.Conexion;
import mundo.dto.CancionesDTO;

import java.sql.ResultSet;

import mundo.contenedora.Contenedora;
import mundo.contenedora.Mensaje;

public class CancionesDAO implements IDAO
{

	@Override
	public void insertar(Conexion con, Mensaje message) 
	{
	
		int idcancion = message.getIdCancion();
		String nombrecancion = message.getNombreCancion();
		String nombreinterprete = message.getNombreInterprete();
		double duracion = message.getDuracion();
		String genero = message.getGenero();
		
		CancionesDTO nva = new CancionesDTO(idcancion, nombrecancion, nombreinterprete, duracion, genero);
		
		con.ejecutaActualizacion(nva.insertar());
	}

	@Override
	public void eliminar(Conexion con, Mensaje message) 
	{
		CancionesDTO cancion = new CancionesDTO();
		cancion.setIdCancion(message.getIdCancion());
		
		con.ejecutaActualizacion(cancion.eliminar());
	}

	@Override
	public void actualizar(Conexion con, Mensaje message) 
	{
		int idcancion = message.getIdCancion();
		String nombrecancion = message.getNombreCancion();
		String nombreinterprete = message.getNombreInterprete();
		double duracion = message.getDuracion();
		String genero = message.getGenero();
		
		CancionesDTO nva = new CancionesDTO(idcancion, nombrecancion, nombreinterprete, duracion, genero);
		
		con.ejecutaActualizacion(nva.actualizar());
		
	}

	@Override
	public Nodo consultarTodos(Conexion con, Mensaje message) 
	{
		CancionesDTO cancion = new CancionesDTO();
		
		ResultSet rs = con.ejecutaConsulta(cancion.consultarTodos());
		
		Nodo consultado = new Contenedora<>().dato(rs, CancionesDTO.class.getName());
		
		return consultado;
	}

	@Override
	public Nodo consultar(Conexion con, Mensaje message) 
	{
		CancionesDTO cancion = new CancionesDTO();
		cancion.setIdCancion(message.getIdCancion());
		
		ResultSet rs = con.ejecutaConsulta(cancion.consultar());
		
		Nodo consultado = new Contenedora<>().dato(rs, CancionesDTO.class.getName());
		
		return consultado;
	}

}
