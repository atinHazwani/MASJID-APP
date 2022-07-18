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
 * Servlet implementation class AdminUmrahController
 */
@WebServlet("/AdminUmrahController")
public class AdminUmrahController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UmrahDAO dao;
	private String slotID;
	private String forward;
	
	private static String UMRAHLIST = "adminListUmrah.jsp";
	private static String UPDATEUMRAH = "adminUpdateUmrah.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUmrahController() {
        super();
        dao = new UmrahDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
		
		//Jumaat Slot for admin
		if(action.equalsIgnoreCase("adminListUmrah")) {
			forward = UMRAHLIST;
			request.setAttribute("umslots", UmrahDAO.getAllUmrah());
		}
		if(action.equalsIgnoreCase("adminUpdateUmrah")) {
			forward = UPDATEUMRAH;
			slotID = request.getParameter("slotID");
			request.setAttribute("um", UmrahDAO.getUmrahById(slotID));
		}
		if(action.equalsIgnoreCase("deleteUmrah")) {
			forward = UMRAHLIST;
			slotID = request.getParameter("slotID");
			dao.deleteUmrah(slotID);
			request.setAttribute("umslots", UmrahDAO.getAllUmrah());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Umrah um = new Umrah();
		
		um.setSlotID(request.getParameter("slotID"));
		um.setDate(request.getParameter("date"));
		um.setTime(request.getParameter("time"));
		um.setChapter(request.getParameter("chapter"));
		um.setVenue(request.getParameter("venue"));
		
		System.out.println("Read Umrah");
		dao.addUmrah(um);
		System.out.println("Read add umrah");
		
		//forward request
		request.setAttribute("umslots", UmrahDAO.getAllUmrah());
		RequestDispatcher view = request.getRequestDispatcher("adminListUmrah.jsp");
		view.forward(request, response);
	}

}
