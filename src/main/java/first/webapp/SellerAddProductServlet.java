package first.webapp;

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SellerAddProductServlet
 */
@WebServlet("/SellerAddProductServlet")
public class SellerAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellerAddProductServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* response.setContentType("text/html"); */
		PrintWriter out = response.getWriter();
		String a = request.getParameter("productName");
		String b = request.getParameter("productDescription");
		String c = request.getParameter("productPrice");
		String d = request.getParameter("maskType");
		String e = request.getParameter("faceType");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdetails", "root",
					"password");

			/* String query = "insert into PRODUCTDETAILS values(?,?)"; */
			PreparedStatement ps = con.prepareStatement("insert into PRODUCTDETAILS values(?,?,?,?,?)");

			ps.setString(1, a);
			ps.setString(2, b);
			ps.setDouble(3, Double.parseDouble(c)); 
			ps.setString(4, d);
			ps.setString(5, e);

			int i = ps.executeUpdate();
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully added a new product!" + "</h1>");
				writer.close();
			}
		} catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		doGet(request, response);
	}

}
