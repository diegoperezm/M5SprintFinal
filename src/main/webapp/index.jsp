<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<link href="./styles/style.css" rel="stylesheet" />
<title>Empresa Prevención De Riesgos</title>
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<div>
		<div class="container" align="center">
			<div class="row">
				<div class="col">
					<div class="px-4 pt-5 my-5 text-center">
						<h1 class="fw-bold text-body-emphasis">Empresa Prevención De
							Riesgos</h1>
						<div class="col-lg-6 mx-auto ">
							<p class="about w-100 lead mt-5 mb-4 text-justify">Somos la compañía
								líder en Prevención de Riesgos Laborales y nuestro objetivo es
								garantizar la seguridad en tu compañía y cuidar de la salud de
								tus profesionales. 
						</div>
					</div>
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
