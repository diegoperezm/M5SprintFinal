<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Usuarios"%>
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
	<jsp:include page="/menu.jsp" />
	<div>
		<div class="container">
			<div class="row">
				<div class="col">
					<form action="./EditarUsuario" method="post">
						<div class="form-group">
							<label for="id">ID:</label> <input type="text"
								class="form-control" name="id" readonly="readonly"
								value="<%=request.getParameter("id")%>"> <label for="nombre">Nombre:</label>
							<input type="text" class="form-control" name="nombre"
								value="<%=request.getParameter("nombre")%>"> <label class="mt-2"
								for="tipo">Seleccione un tipo:</label> <select
								class="custom-select" name="tipo" required>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>