package mas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mas.dao.BookedSlotDAO;
import mas.model.BookedSlot;

/**
 * Servlet implementation class UserBookJumaatController
 */
@WebServlet("/UserBookJumaatController")
public class UserBookJumaatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookedSlotDAO dao;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBookJumaatController() {
        super();
        dao = new BookedSlotDAO();
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
		BookedSlot bookedSlot = new BookedSlot();
		bookedSlot.setSlotID(request.getParameter("slotID"));
		bookedSlot.setUserID(request.getParameter("userID"));
		bookedSlot.setBookDate(request.getParameter("bookDate"));
		
		dao.addBookedSlot(bookedSlot);
		System.out.println("read!");
		
		request.setAttribute("bookedSlots", BookedSlotDAO.getAllBookedSlot());
		RequestDispatcher view = request.getRequestDispatcher("bookedSlotList.jsp");
		view.forward(request, response);
	}

}
