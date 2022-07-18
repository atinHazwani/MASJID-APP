package mas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mas.dao.JumaatPrayerDAO;
import mas.model.JumaatPrayer;

/**
 * Servlet implementation class AdminJumaatController
 */
@WebServlet("/AdminJumaatController")
public class AdminJumaatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static JumaatPrayerDAO dao;
	private String slotID;
	private String forward;
    
	
	//Jumaat Slot for admin
	private static String JUMAATLIST = "adminListJumaat.jsp";
	//private static String VIEWJUMAAT = "viewJumaat.jsp";
	private static String UPDATEJUMAAT = "adminUpdateJumaat.jsp";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminJumaatController() {
        super();
        dao = new JumaatPrayerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		//Jumaat Slot for admin
		if(action.equalsIgnoreCase("adminListJumaat")) {
			forward = JUMAATLIST;
			request.setAttribute("jumaatPrayers", JumaatPrayerDAO.getAllJumaatPrayer());
		}
		if(action.equalsIgnoreCase("adminUpdateJumaat")) {
			forward = UPDATEJUMAAT;
			slotID = request.getParameter("slotID");
			request.setAttribute("jumaatPrayer", JumaatPrayerDAO.getJumaatPrayerByID(slotID));
		}
		if(action.equalsIgnoreCase("deleteJumaat")) {
			forward = JUMAATLIST;
			slotID = request.getParameter("slotID");
			dao.deleteJumaatPrayer(slotID);
			request.setAttribute("jumaatPrayers", JumaatPrayerDAO.getAllJumaatPrayer());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JumaatPrayer jp = new JumaatPrayer();
		jp.setSlotID(request.getParameter("slotID"));
		jp.setDate(request.getParameter("date"));
		jp.setKhutbahTitle(request.getParameter("khutbahTitle"));
		
		dao.updateJumaatPrayer(jp);
		System.out.println("Update Jumaat");
		
		request.setAttribute("jumaatPrayers",JumaatPrayerDAO.getAllJumaatPrayer());
		RequestDispatcher view = request.getRequestDispatcher("adminListJumaat.jsp");
		view.forward(request, response);
	}

}
