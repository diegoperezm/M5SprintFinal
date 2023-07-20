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




public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuarios usuario = new Usuarios();

        usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setTipo(request.getParameter("tipo"));

		UsuariosDAO usuarioDAO = new UsuariosDAO();
		try {
			usuarioDAO.updateUsuarios(usuario, request.getParameter("id"));
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
