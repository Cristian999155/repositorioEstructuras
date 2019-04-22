package mundo.contenedora;

import java.io.Serializable;

public class Mensaje implements Serializable
{
	public final static long serialVersionUID = 518405140372484957L;
	private Funcion funcion;
	private Tabla tabla;
	
	
	private int idcancion;
	private String nombrecancion;
	private String nombreinterprete;
	private double duracion;
	private String genero;
	
	public Mensaje()
	{
		
	}
	
	public void funcionCanciones(Funcion pFuncion, int pIdCancion, String pNombreCancion, String pNombreInterprete, double pDuracion, String pGenero)
	{
		tabla = Tabla.canciones;
		funcion = pFuncion;
		idcancion = pIdCancion;
		nombrecancion = pNombreCancion;
		nombreinterprete = pNombreInterprete;
		duracion = pDuracion;
		genero = pGenero;
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	public int getIdCancion() {
		return idcancion;
	}

	public void setIdCancion(int idCancion) {
		this.idcancion = idCancion;
	}

	public String getNombreCancion() {
		return nombrecancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombrecancion = nombreCancion;
	}

	public String getNombreInterprete() {
		return nombreinterprete;
	}

	public void setNombreInterprete(String nombreInterprete) {
		this.nombreinterprete = nombreInterprete;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
