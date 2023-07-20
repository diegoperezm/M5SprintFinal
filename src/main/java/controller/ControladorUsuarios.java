package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Capacitaciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CapacitacionesDAO;
import dao.UsuariosDAO;
import java.util.ArrayList;
import model.Usuarios;

public class ControladorUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorUsuarios() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
        try {
			listaUsuarios  = UsuariosDAO.getList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("listaUsuarios", listaUsuarios);
        request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuarios usuarios = new Usuarios(); 
		usuarios.setNombre(request.getParameter("nombre"));
		usuarios.setTipo(request.getParameter("tipo"));
        CapacitacionesDAO d = new CapacitacionesDAO();	
	    try {
			d.addUsuarios(usuarios);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		

	    List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
        try {
			listaUsuarios  = UsuariosDAO.getList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("listaUsuarios", listaUsuarios);
        request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
	}

}
