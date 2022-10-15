package com.sddevops.CWF_maven.eclipse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private String jdbcURL = "jdbc:mysql://localhost:3306/productdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private static final long serialVersionUID = 1L;

	private static final String INSERT_USERS_SQL = "INSERT INTO productdetails"
			+ " (product_name, description, price, mask_type, face_type) VALUES " + " ( ?, ?, ?, ?);";
	private static final String SELECT_PRODUCTS_BY_NAME = "select product_name, description, price, mask_type, face_type from productdetails where product_name =?";
	private static final String SELECT_ALL_PRODUCTS = "select * from productdetails";
	private static final String DELETE_PRODUCTS_SQL = "delete from productdetails where product_name = ?;";
	private static final String UPDATE_PRODUCTS_SQL = "update productdetails set product_name = ?,description= ?, price =?,mask_type =?, face_type =? where product_name =?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ProductServlet/delete":
				deleteProduct(request, response);
				break;
			case "/ProductServlet/edit":
				showEditForm(request, response);
				break;
			case "/ProductServlet/update":
				updateUser(request, response);
				break;
			case "/ProductServlet/dashboard":
				listProducts(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	private void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> products = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String productName = rs.getString("product_name");
				String description = rs.getString("description");
				Double price = rs.getDouble("price");
				String maskType = rs.getString("mask_type");
				String faceType = rs.getString("face_type");
				products.add(new Product(productName, description, price, maskType, faceType));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// productManagement.jsp
		request.setAttribute("listProducts", products);
		request.getRequestDispatcher("/productManagement.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String productName = request.getParameter("product_name");
		Product existingProduct = new Product("", "", 0, "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_NAME);) {
			preparedStatement.setString(1, productName);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				productName = rs.getString("product_name");
				String description = rs.getString("description");
				Double price = rs.getDouble("price");
				String maskType = rs.getString("mask_type");
				String faceType = rs.getString("face_type");
				existingProduct = new Product(productName, description, price, maskType, faceType);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("product", existingProduct);
		request.getRequestDispatcher("/productEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriName = request.getParameter("oriName");
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String maskType = request.getParameter("maskType");
		String faceType = request.getParameter("faceType");
		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
			statement.setString(1, productName);
			statement.setString(2, description);
			statement.setString(3, price);
			statement.setString(4, maskType);
			statement.setString(5, faceType);
			statement.setString(6, oriName);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to
		// your project name)
		// The sample uses project name as HelloWorldJaveEE. Use your own proj name if
		// its not the same.
		response.sendRedirect("http://localhost:8090/BeautyMasks/ProductServlet/dashboard");
	}

	//method to delete user
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	String productName = request.getParameter("product_name");
	//Step 2: Attempt connection with database and execute delete user SQL query
	try (Connection connection = getConnection(); PreparedStatement statement =
	connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
	statement.setString(1, productName);
	int i = statement.executeUpdate();
	}
	//Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
	response.sendRedirect("http://localhost:8090/BeautyMasks/ProductServlet/dashboard");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
