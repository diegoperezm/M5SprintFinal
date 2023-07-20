<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous" />

<link href="./styles/style.css" rel="stylesheet" />

<!-- -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/responsive/2.2.6/js/dataTables.responsive.min.js"></script>
<script src="datatables.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/responsive/2.2.6/css/responsive.dataTables.min.css">
<title>Listado de usuarios</title>
</head>
<body>
	<jsp:include page="/menu.jsp" />

	<div class="container mt-5 w-75 justify-content-center">
		<div class="est">

			<h2>Listar Usuarios</h2>
			<br>
			<table id="dataTable" class="table display responsive nowrap"
				style="width: 100%">
				<thead class="table">
					<tr>
						<th>ID</th>
						<th>Nombre Usuario</th>
						<th>Tipo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
					for (Usuarios u : lista) {
					%>
					<tr>
						<td><%=u.getId()%></td>
						<td><%=u.getNombre()%></td>
						<td><%=u.getTipo()%></td>
						<td><a href="editarUsuario.jsp?id=<%=u.getId()%>&nombre=<%=u.getNombre() %>"
							class="btn btn-info">Editar</a></td>
					</tr>
				</tbody>
				<%}%>

			</table>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>