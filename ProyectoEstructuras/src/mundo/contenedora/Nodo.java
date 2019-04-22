package mundo.contenedora;

import java.io.Serializable;

public class Nodo<T> implements Serializable 
{
	private final static long serialVersionUID = -7310107063289711815L;
	
	private Nodo<T> siguiente;
	
	private T informacion;

	
	public Nodo() 
	{
		siguiente = null;
	}

	public T getInformacion() {
		return informacion;
	}

	public void setInformacion(T informacion) {
		this.informacion = informacion;
	}

	public Nodo<T> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
	
}
