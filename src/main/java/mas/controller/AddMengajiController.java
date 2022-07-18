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
 * Servlet implementation class AddMengajiController
 */
@WebServlet("/AddMengajiController")
public class AddMengajiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MengajiDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMengajiController() {
        super();
        dao = new MengajiDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher view = request.getRequestDispatcher("adminAddMengaji.jsp");
		view.forward(request, response);

	}

}
