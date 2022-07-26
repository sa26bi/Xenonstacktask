package xenonstack_ass;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class ReiceveServlets
 */
@WebServlet("/ReiceveServlets")
public class ReiceveServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReiceveServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con = dbConnection.createConnect();
		String msg="falied";
		try {
			try {
			String UserName=request.getParameter("UserName");
			String password=request.getParameter("Passwords");
			String query = "SELECT UserName=?,Passwords=? from tbl";
			PreparedStatement st = con.prepareStatement(query);
			 st.setString(1,UserName);  
			 st.setString(2,password);  
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				//result found, means valid inputs
				msg="success";
			}
			}catch (SQLException ex) {
				System.out.println("Login error -->" + ex.getMessage());
				msg="falied";
			} 
			Gson gson = new GsonBuilder().serializeNulls().create();
			String invoices  = gson.toJson(msg);
			response.setContentType("application/json");
			try {
				response.getWriter().write(invoices);//getWriter() returns a PrintWriter object that can send character text to the client. 
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
