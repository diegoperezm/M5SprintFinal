package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.CapacitacionesDAO;

import java.util.ArrayList;
import model.Capacitaciones;

public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearCapacitacion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Capacitaciones capacitacion = new Capacitaciones(); 
		capacitacion.setNombre(request.getParameter("nombre"));
		capacitacion.setDetalle(request.getParameter("detalle"));
        CapacitacionesDAO d = new CapacitacionesDAO();	
	    try {
			d.addCapacitacion(capacitacion);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		

		List<Capacitaciones> listaCapacitaciones = new ArrayList<Capacitaciones>();
        try {
			listaCapacitaciones  = CapacitacionesDAO.getList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        request.setAttribute("listaCapacitaciones", listaCapacitaciones);
        request.getRequestDispatcher("listarCapacitaciones.jsp").forward(request, response);

	}

}



