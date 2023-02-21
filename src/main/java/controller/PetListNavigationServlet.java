package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webVetList.VetDetails;

/**
 * Servlet implementation class PetListNavigationServlet
 */
@WebServlet("/petListNavigationServlet")
public class PetListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetListNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VetDetailsHelper dao = new VetDetailsHelper();
		String act = request.getParameter("doThisToVetList");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
		}
		else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				VetDetails vetToDelete = dao.searchForVetListById(tempId);
				dao.deleteVetList(vetToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to click a button");
			}
			finally{
				getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
			}
		}
		else if(act.equals("edit")) {
			try {
				getServletContext().getRequestDispatcher("/edit-vet.jsp").forward(request, response);
			}
			catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
			}
		}
		else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-vetList.html").forward(request, response);
		}
	}

}
