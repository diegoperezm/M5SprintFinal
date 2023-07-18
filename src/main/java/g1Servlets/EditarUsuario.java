package g1Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import conexion.Dbconn;

public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Validar que existe la base de datos
		try {
			Class.forName(Dbconn.driver);
		} catch (ClassNotFoundException e) {
			System.out.println("No se encontro la BD" + e);
		}

		// Llamamos a la base de datos
		try {

			Connection conn = DriverManager.getConnection(Dbconn.url, Dbconn.user, Dbconn.password);
			System.out.println("Conexion exitosa");

			PreparedStatement st = conn.prepareStatement("update Usuarios set nombre=?, tipo=? where id=?");

			// definir tipos de la tabla
			st.setString(1, request.getParameter("nombre"));
			st.setString(2, request.getParameter("tipo"));
			st.setInt(3, Integer.valueOf(request.getParameter("id")));
			

			// ejecutar query
			st.executeUpdate();
			st.close();
			conn.close();

			response.sendRedirect("listarUsuario.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
