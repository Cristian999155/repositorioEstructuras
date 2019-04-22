package mundo.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Servicios {
	private Conexion con;

	
	public Servicios() {
		con = new Conexion("jdbc:postgresql://localhost/dbSound", "postgres", "barcelona99");
	}

	public Conexion getCon() {
		return con;
	}

	public void setCon(Conexion con) {
		this.con = con;
	}

	
}
