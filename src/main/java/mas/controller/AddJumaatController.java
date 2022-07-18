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
 * Servlet implementation class AddJumaatController
 */
@WebServlet("/AddJumaatController")
public class AddJumaatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static JumaatPrayerDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJumaatController() {
        super();
        dao = new JumaatPrayerDAO();
        // TODO Auto-generated constructor stub
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
		
		dao.addJumaatPrayer(jp);
		System.out.println("Read Jumaat Slot");
		
		request.setAttribute("jumaatPrayers",JumaatPrayerDAO.getAllJumaatPrayer());
		RequestDispatcher view = request.getRequestDispatcher("adminAddJumaat.jsp");
		view.forward(request, response);
	}

}
