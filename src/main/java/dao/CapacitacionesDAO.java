package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import conexion.Dbconn;
import model.Capacitaciones;

public class CapacitacionesDAO {
	
	public static  List<Capacitaciones> getList() throws ClassNotFoundException,SQLException {
		List<Capacitaciones> listaCapacitaciones = new ArrayList<Capacitaciones>();
		try {
            Connection conn = Dbconn.getConnection(); 
			PreparedStatement st = conn.prepareStatement("select * from Capacitaciones");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Capacitaciones capacitacion = new Capacitaciones();
				capacitacion.setId(rs.getInt(1));
				capacitacion.setNombre(rs.getString("nombre"));
				capacitacion.setDetalle(rs.getString("detalle"));
				listaCapacitaciones.add(capacitacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCapacitaciones;
	}

    public void  addCapacitacion(Capacitaciones capacitacion) throws ClassNotFoundException, SQLException {
      try {
            Connection conn = Dbconn.getConnection(); 
			System.out.println("Conexion exitosa");
			PreparedStatement st = conn.prepareStatement("insert into Capacitaciones(nombre, detalle) values (?,?)");
			st.setString(1, capacitacion.getNombre());
			st.setString(2, capacitacion.getDetalle());
            st.executeUpdate();

      } catch(SQLException ex) {
    	 ex.printStackTrace();   
      }   
    } 
}
