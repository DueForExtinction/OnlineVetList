package controller;

import webVetList.PetItem;
import webVetList.VetDetails;
import webVetList.Veterinarian;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateNewVetListServlet
 */
@WebServlet("/createNewVetListServlet")
public class CreateNewVetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewVetListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PetItemHelper pih = new PetItemHelper();
		String vetBisName = request.getParameter("vetBisName");
		System.out.println("Bussiness name: " + vetBisName);
		
		String vetsName = request.getParameter("vetName");
		System.out.println(vetsName);
		String[] selectedPets = request.getParameterValues("allPetsToAdd");
		
		List<PetItem> selectedPetsInList = new ArrayList<PetItem>();
		
		if(selectedPets != null && selectedPets.length > 0) {
			for(int i = 0; i<selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				PetItem p = pih.searchForPetById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(p);
			}
		}
		
		Veterinarian vet = new Veterinarian(vetsName);
		VetDetails vd = new VetDetails(vetBisName, vet);
		
		vd.setPetInfo(selectedPetsInList);
		VetDetailsHelper vdh = new VetDetailsHelper();
		vdh.insertNewVetDetails(vd);
		
		System.out.println("Success!");
		System.out.println(vdh.toString());
		
		getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
