package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webVetList.PetItem;
/**
 * Servlet implementation class AddPetServlet
 */
@WebServlet("/addPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String owner = request.getParameter("owner");
		String operation = request.getParameter("operation");
		
		PetItem pi = new PetItem(name, owner, operation);
		PetItemHelper dao = new PetItemHelper();
		dao.insertPet(pi);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}


/**
 * Owners name:<input type="text" name="owner">
Procedure:<input type="text" name="procedure">
 */
