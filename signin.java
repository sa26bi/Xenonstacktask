package xenonstack_ass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			//String BusinessCode =  request.getParameter("businessCode");
			//JsonObject data = new Gson().fromJson(request.getReader(), JsonObject.class);
			//String baselineCreateDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(request.getParameter("baselineCreateDate")));
			String custnumber=request.getParameter("UserName");
			String businessCode=request.getParameter("Passwords");
			
			
			Connection con = dbConnection.createConnect();
			String query = "INSERT INTO tbl (UserName,Passwords) VALUES (?,?)";
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1,custnumber);
			st.setString(2,businessCode);
			
			
			
			st.executeUpdate();
			con.close();
			

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

