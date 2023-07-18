package g1Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Contacto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   	
		   HttpSession session = request.getSession();
		// if(session != null) {
		// } else {
//		   getServletContext().getRequestDispatcher("./login.jsp").forward(request, response);
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String correo = request.getParameter("correo");
	//	String comentarios = request.getParameter("comentarios");
	//	getServletContext().getRequestDispatcher("./contacto.jsp").forward(request, response);
		doGet(request,response);
	}

}
