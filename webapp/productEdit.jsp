<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Edit Product</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Product Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProductServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${product != null}">
Edit Product
</c:if>
						<c:if test="${product == null}">
Add New Product
</c:if>
					</h2>
				</caption>
				<c:if test="${product != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${product.product_name}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out
value='${product.product_name}' />"
						class="form-control" name="productName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out
value='${product.description}' />"
						class="form-control" name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Price</label> <input type="text"
						value="<c:out
value='${product.price}' />" class="form-control"
						name="price">
				</fieldset>

				<fieldset class="form-group">
					<label>Mask Type</label> <select name="maskType" required>
						value="
						<c:out value='${product.mask_type}' />"
						<option>Cream</option>
						<option>Clay</option>
						<option>Sheet</option>
						<option>Sleeping</option>
						<option>Peel-off</option>
						<option>Exfoliating</option>
					</select>
				</fieldset>

				<fieldset class="form-group">
					<label>Face Type</label> <select name="faceType" required>
						value="
						<c:out value='${product.face_type}' />"
						<option>Normal</option>
						<option>Dry</option>
						<option>Oily</option>
						<option>Sensitive</option>
					</select>
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>