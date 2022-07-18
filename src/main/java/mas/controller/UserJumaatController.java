package mas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mas.dao.JumaatPrayerDAO;
//import mas.model.JumaatPrayer;

/**
 * Servlet implementation class UserJumaatController
 */
@WebServlet("/UserJumaatController")
public class UserJumaatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Jumaat Slot for admin
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserJumaatController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("jumaatPrayers",JumaatPrayerDAO.getAllJumaatPrayer());
		RequestDispatcher view = request.getRequestDispatcher("userViewJumaat.jsp");
		view.forward(request, response);
	}
}
