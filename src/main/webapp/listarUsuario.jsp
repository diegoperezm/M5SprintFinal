<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous" />

<link rel="stylesheet" href="css/style.css">

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
	<div class="container mt-5 w-75 justify-content-center">
		<div class="est">

			<h2>Estadisticas</h2>
			<br>

			<table id="dataTable" class="table display responsive nowrap"
				style="width: 100%">
				<thead class="table">
					<tr>
						<th>ID</th>
						<th>Nombre Cliente</th>
						<th>Edad</th>
						<th>Genero</th>
						<th>Correo Electrónico</th>
						<th>Teléfono</th>
						<th>Producto</th>
						<th>Marca</th>
						<th>Precio</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Felipe Maza</td>
						<td>21</td>
						<td>Hombre</td>
						<td>felipe@algo.cl</td>
						<td>952364125</td>
						<td>iPhone 14</td>
						<td>Apple</td>
						<td>$799</td>
						<td><input type="submit" class="btn btn-info" value="Editar"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>