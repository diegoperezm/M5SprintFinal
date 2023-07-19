<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="conexion.Dbconn"%>
<%
HttpSession s = request.getSession();

if (null == s.getAttribute("user")) {
	response.sendRedirect("./login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="styles/style.css" rel="stylesheet" />
<title>Editar usuario</title>
</head>
<body>
	<%
	Class.forName(Dbconn.driver);
	Connection conn = DriverManager.getConnection(Dbconn.url, Dbconn.user, Dbconn.password);
	System.out.println("Conexion exitosa");

	int id = Integer.parseInt(request.getParameter("id"));
	PreparedStatement st = conn.prepareStatement("select * from Usuarios where id=" + id);
	ResultSet rs = st.executeQuery();

	while (rs.next()) {
	%>
	<jsp:include page="/menu.jsp" />

	<div>
		<div class="container">
			<div class="row">
				<div class="col">
					<form action="./EditarUsuario" method="post">
						<div class="form-group">
							<label for="id">ID:</label>
								<input type="text" class="form-control" name="id" readonly="readonly" value="<%=rs.getInt("id")%>">
							<label for="nombre">Nombre:</label>
								<input type="text" class="form-control" name="nombre" value="<%=rs.getString("nombre")%>">
							<label class="mt-2" for="tipo">Seleccione un tipo:</label>
							<select class="custom-select" name="tipo" required>
								<option value="Cliente">Cliente</option>
								<option value="Administrativo">Administrativo</option>
								<option value="Profesional">Profesional</option>
							</select>
						</div>
						<input class="btn btn-warning btn-editarUsuario" type="submit"
							value="Editar usuario">
					</form>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>