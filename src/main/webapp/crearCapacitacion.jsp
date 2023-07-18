<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
HttpSession s = request.getSession();
 
if( null == s.getAttribute("user")){
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
<title>Empresa Prevención De Riesgos</title>
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<div>
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<form action="./CrearCapacitacion" method="post">
						<div class="form-group">
							<label for="nombre">Nombre:</label> <input type="text"
								class="form-control" id="nombre" placeholder="nombre"> <label
								for="apellido">Apellido:</label> <input type="text"
								class="form-control" id="apellido" placeholder="apellido">

							<label for="capacitacion">Nombre Capacitación:</label> <input
								type="text" class="form-control" id="capacitacion"
								placeholder="capacitación"> <label for="correo">Correo:</label>
							<input type="email" class="form-control" id="correo"
								placeholder="nombre@correo.com">
						</div>
						<input type="submit" value="Crear capacitación">
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


