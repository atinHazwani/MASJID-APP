package mas.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mas.dao.UmrahDAO;
import mas.model.Umrah;

/**
 * Servlet implementation class addJumaatCont
 */
@WebServlet("/AddUmrahController")
public class AddUmrahController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UmrahDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUmrahController() {
        super();
        dao = new UmrahDAO();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Umrah um = new Umrah();
		
		um.setSlotID(request.getParameter("slotID"));
		um.setDate(request.getParameter("date"));
		um.setTime(request.getParameter("time"));
		um.setChapter(request.getParameter("chapter"));
		um.setVenue(request.getParameter("venue"));
		
		System.out.println("read set!");
		dao.addUmrah(um);
		System.out.println("read add 2!");
		
		//forward request
		request.setAttribute("umslots", UmrahDAO.getAllUmrah());
		RequestDispatcher view = request.getRequestDispatcher("adminAddUmrah.jsp");
		view.forward(request, response);
				
	}

}