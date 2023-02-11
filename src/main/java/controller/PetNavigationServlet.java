package controller;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webVetList.PetItem;

/**
 * Servlet implementation class PetNavigationServlet
 */
@WebServlet("/petNavigationServlet")
public class PetNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PetItemHelper dao = new PetItemHelper();
		String path = "/viewAllPetsServlet";
		String act = request.getParameter("ChangePet");
		
		
		if(act.equals("delete")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PetItem petToDelete = dao.searchForPetById(tempId);
			dao.deletePet(petToDelete);
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an item.");
			}
		}
		else if(act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PetItem petToEdit = dao.searchForPetById(tempId);
			request.setAttribute("petToEdit", petToEdit);
			path="/edit-pet.jsp";
			}
			catch(NumberFormatException e){
				System.out.println("Forgot to select a pet.");
			}
		}
		else if(act.equals("add")) {
			path ="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

//${ListPets}