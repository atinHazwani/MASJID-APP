package mas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mas.dao.UserAccDAO;
import mas.model.UserAcc;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserAccDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao = new UserAccDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
	    String password = request.getParameter("password");
	 
	    UserAcc user = new UserAcc();
	 
	    user.setUserID(userID);
	    user.setPassword(password);
	 
	    
	    try
	    {
	        String userValidate = dao.authenticateUser(user);
	 
	        if(userValidate.equals("Admin_Role"))
	        {
	            HttpSession session = request.getSession(); //Creating a session
	            session.setAttribute("admin", userID); //setting session attribute
	            request.setAttribute("userID", userID);
	 
	            request.getRequestDispatcher("addJumaatForm.jsp").forward(request, response);
	        }
	        else if(userValidate.equals("User_Role"))
	        {
	            HttpSession session = request.getSession();
	            session.setMaxInactiveInterval(10*60);
	            session.setAttribute("user", userID);
	            request.setAttribute("userID", userID);
	 
	            request.getRequestDispatcher("userHome.jsp").forward(request, response);
	        }
	        else
	        {
	            System.out.println("Error message = "+userValidate);
	            request.setAttribute("errMessage", userValidate);
	 
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    }
	    catch (IOException e1)
	    {
	        e1.printStackTrace();
	    }
	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }
	} //End of doPost()
}
