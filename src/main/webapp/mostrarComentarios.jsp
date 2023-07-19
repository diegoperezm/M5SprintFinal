<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comentarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="./styles/style.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<div>
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header text-success">Comentarios</div>
						<div class="card-body text-dark">
							<blockquote class="blockquote mb-0">
								<p class="mb-5">
									<%=request.getParameter("comentarios")%>
								</p>
								<footer class="blockquote-footer">
									<%=request.getParameter("correo")%></footer>
							</blockquote>
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