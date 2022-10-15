<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Listing</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand">Add Product Listing</a>
		</div>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<form action="SellerAddProductServlet" method="post">
					<fieldset class="form-group">
						Product Name: <input type="text" name="productName" size="20"
							autocomplete="off" required>
					</fieldset>
					<fieldset class="form-group">
						Product Description:
						<textarea rows="5" cols="60" name="productDescription"
							placeholder="Enter product description" autocomplete="off"
							required> </textarea>
					</fieldset>
					<fieldset class="form-group">
						Price: <input type="text" name="productPrice"
							size="20" autocomplete="off" required>
					</fieldset>
					<fieldset class="form-group">
						Mask Type: <select name="maskType" required>
							<option>Cream</option>
							<option>Clay</option>
							<option>Sheet</option>
							<option>Sleeping</option>
							<option>Peel-off</option>
							<option>Exfoliating</option>
						</select>
					</fieldset>

					<fieldset class="form-group">
						Face Type: <select name="faceType" required>
							<option>Normal</option>
							<option>Dry</option>
							<option>Oily</option>
							<option>Sensitive</option>
						</select>
					</fieldset>

					<!-- Implement submit button with type = submit to perform the request when clicked -->
					<input type="submit" class="btn btn-success" value="Add Product" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>