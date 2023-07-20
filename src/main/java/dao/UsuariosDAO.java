package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import conexion.Dbconn;
import model.Usuarios;

public class UsuariosDAO {
	public static List<Usuarios> getList() throws ClassNotFoundException, SQLException {
		List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
		try {
			Connection conn = Dbconn.getConnection();
			PreparedStatement st = conn.prepareStatement("select * from Usuarios");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuarios usuario = new Usuarios();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setTipo(rs.getString("tipo"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public void addUsuarios(Usuarios usuario) throws ClassNotFoundException, SQLException {
		try {
			Connection conn = Dbconn.getConnection();
			System.out.println("Conexion exitosa");
			PreparedStatement st = conn.prepareStatement("insert into Usuarios(nombre, tipo) values (?,?)");
			st.setString(1, usuario.getNombre());
			st.setString(2, usuario.getTipo());
			st.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void updateUsuarios(Usuarios usuario, String id) throws ClassNotFoundException, SQLException {
		try {
			Connection conn = Dbconn.getConnection();
			System.out.println("Conexion exitosa");
			PreparedStatement st = conn.prepareStatement("update Usuarios set nombre=?, tipo=? where  id=?");
			st.setString(1, usuario.getNombre());
			st.setString(2, usuario.getTipo());
			st.setInt(3, Integer.valueOf(id));
			st.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
