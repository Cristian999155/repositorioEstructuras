
package mundo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author crisVargas
 *
 */
public class Conexion {
	private Connection  con;
	private Statement st;
	private ResultSet rs;

	public Conexion(String url, String user, String password){
		try {
			con= DriverManager.getConnection(url, user, password);
			System.out.println("Conexion Exitosa");
		} catch (SQLException e) {
			System.out.println("Error al conectar: "+e.getMessage());
		}
	}
	
	public ResultSet ejecutaConsulta(String instruccionSql){
		rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(instruccionSql);
			System.out.println("Consulta Exitosa");
		} catch (SQLException e) {
			System.out.println("Error en la Consulta: "+e.getMessage());
		}
		return rs;
	}
	
	public boolean ejecutaActualizacion(String instruccionSql){
		int filas=0;
		try {
			st = con.createStatement();
			filas = st.executeUpdate(instruccionSql);
			System.out.println("Consulta Exitosa");
			return true;
		} catch (SQLException e) {
			System.out.println("Error en la Consulta: "+e.getMessage());
			return false;
		}
	}

    public Map<String ,Integer> creaMap(String consulta){
    	Map<String ,Integer> lk = new LinkedHashMap<String ,Integer>();
    	ResultSet rs = ejecutaConsulta(consulta);
    	try {
			while(rs.next()){
				lk.put(rs.getString(1).trim(), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return lk;
    }
    public boolean estaCerrada() {
        try {
            return con.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
