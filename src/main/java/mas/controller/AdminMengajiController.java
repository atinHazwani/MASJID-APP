package mas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mas.dao.MengajiDAO;
import mas.model.Mengaji;

/**
 * Servlet implementation class AdminMengajiController
 */
@WebServlet("/AdminMengajiController")
public class AdminMengajiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MengajiDAO dao;
	private String slotID;
	private String forward;
    
	
	private static String MENGAJILIST = "adminListMengaji.jsp";
	//private static String VIEWJUMAAT = "viewJumaat.jsp";
	private static String UPDATEMENGAJI = "adminUpdateMengaji.jsp";
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMengajiController() {
        super();
        dao = new MengajiDAO();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		//Jumaat Slot for admin
		if(action.equalsIgnoreCase("adminListMengaji")) {
			forward = MENGAJILIST;
			request.setAttribute("mcslots", MengajiDAO.getAllMengaji());
		}
		if(action.equalsIgnoreCase("adminUpdateMengaji")) {
			forward = UPDATEMENGAJI;
			slotID = request.getParameter("slotID");
			request.setAttribute("mc", MengajiDAO.getMengajiById(slotID));
		}
		if(action.equalsIgnoreCase("deleteMengaji")) {
			forward = MENGAJILIST;
			slotID = request.getParameter("slotID");
			dao.deleteMengaji(slotID);
			request.setAttribute("mcslots", MengajiDAO.getAllMengaji());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mengaji mc = new Mengaji();
		
		mc.setSlotID(request.getParameter("slotID"));
		mc.setDate(request.getParameter("date"));
		mc.setTime(request.getParameter("time"));
		mc.setGuruname(request.getParameter("guruname"));
		mc.setVenue(request.getParameter("venue"));
		
		System.out.println("Read Mengaji");
		dao.addMengaji(mc);
		System.out.println("Read add Mengaji");
		
		//forward request
		request.setAttribute("mcslots", MengajiDAO.getAllMengaji());
		RequestDispatcher view = request.getRequestDispatcher("adminListMengaji.jsp");
		view.forward(request, response);
	}
}
