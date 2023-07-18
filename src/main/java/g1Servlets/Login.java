package g1Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getServletContext().getRequestDispatcher("/login.jsp").forward(request,
		// response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String user = request.getParameter("userN");
		String pass = request.getParameter("passW");

		if (user.equals("admin") && pass.equals("1234")) {

			session.setAttribute("user", user);
			session.setAttribute("pass", pass);
			response.sendRedirect("./contacto.jsp");

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Password incorrecta</font>");
			rd.include(request, response);

		}
	}

}
