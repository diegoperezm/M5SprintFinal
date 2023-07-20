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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.Dbconn;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dbName = "";
		String dbPass = "";
		String user = request.getParameter("userN");
		String pass = request.getParameter("passW");

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		try {
			Connection conn = Dbconn.getConnection(); 
			System.out.println("Conexion exitosa");
			PreparedStatement st = conn.prepareStatement("select * from login");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				dbName = rs.getString(1);
				dbPass = rs.getString(2);
			}
			rs.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user.equals(dbName) && pass.equals(dbPass)) {
			session.setAttribute("user", user);
			session.setAttribute("pass", pass);
			response.sendRedirect("./index.jsp");

		} else {
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Password incorrecta</font>");
			rd.include(request, response);

		}
	}
}
