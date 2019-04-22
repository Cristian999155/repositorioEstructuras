package mundo.dto;

import java.io.Serializable;

public class CancionesDTO implements IDTO, Serializable {
	
	private final static long serialVersionUID = 5063886785530634323L;

	private int idcancion;
	
	private String nombrecancion;
	
	private String nombreinterprete;
	
	private double duracion;
		
	private String genero;
	
	
	
	public CancionesDTO()
	{
		
	}
	
	public CancionesDTO(int pId, String pNombrecancion, String pNombreInterprete, double pDuracion, String pGenero )
	{
		super();

		idcancion = pId;
		nombrecancion = pNombrecancion;
		nombreinterprete = pNombreInterprete;
		duracion = pDuracion;
		genero = pGenero;	
	}
	
		
	public int getIdCancion() {
		return idcancion;
	}

	public void setIdCancion(int pIdCancion) {
		idcancion = pIdCancion;
	}

	public String getNombrecancion() {
		return nombrecancion;
	}

	public void setNombrecancion(String pNombrecancion) {
		nombrecancion = pNombrecancion;
	}

	public String getNombreInterprete() {
		return nombreinterprete;
	}

	public void setNombreInterprete(String pNombreInterprete) {
		nombreinterprete = pNombreInterprete;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double pDuracion) {
		duracion = pDuracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String pGenero) {
		genero = pGenero;
	}

	@Override
	public String insertar() {
		return "INSERT INTO  canciones (idcancion,nombrecancion,nombreinterprete,duracion, genero) VALUES ("+ idcancion+ ", '"+nombrecancion.trim()+"', '"+nombreinterprete.trim()+ "', "+ duracion+", '"+genero.trim()+"' )";
	}

	@Override
	public String eliminar() {
		return "DELETE FROM canciones WHERE IDCANCION = " +idcancion;
	}

	@Override
	public String actualizar() {
		return "UPDATE canciones SET IDCANCION = "+idcancion+",NOMBRE = '"+nombrecancion.trim()+"', NOMBREINTERPRETE = '"+nombreinterprete.trim()+"', DURACION = "+duracion+", GENERO = '"+genero.trim()+"' WHERE IDCANCION = "+idcancion;
	}

	@Override
	public String consultar() {
		return "Select IDCANCION, NOMBRECANCION, NOMBREINTERPRETE, DURACION, GENERO FROM CANCIONES WHERE IDCANCION = " +idcancion;
		
	}
	
	@Override
	public String consultarTodos() {
		return "select * from canciones";
	}

	public String toString() 
	{
		return "Canciones:" + "\n" + "ID = " + idcancion + "\nNombre = " + nombrecancion +"\nNombre Interprete = " + nombreinterprete + "\nDuracion = " + duracion + "\nGenero = "+genero +"\n " +"/---------------------------------------\\";
	}

}
