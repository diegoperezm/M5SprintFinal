package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuariosDAO;
import model.Usuarios;

public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearUsuario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuarios usuario = new Usuarios();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setTipo(request.getParameter("tipo"));
		UsuariosDAO usuarioDAO = new UsuariosDAO();
		try {
			usuarioDAO.addUsuarios(usuario);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
		try {
			listaUsuarios = UsuariosDAO.getList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaUsuarios", listaUsuarios);
		request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
	}

}
