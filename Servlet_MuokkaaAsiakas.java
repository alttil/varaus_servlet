package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_Asiakas;
import model.Asiakas;


@WebServlet("/Servlet_MuokkaaAsiakas")
public class Servlet_MuokkaaAsiakas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_MuokkaaAsiakas() {
        super();
        System.out.println("Servlet_MuokkaaAsiakas.Servlet_MuokkaaAsiakas()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaAsiakas.doGet()");
		String id = request.getParameter("asiakas_id");
		id=id.replace("muokkaa_", "");
		Dao_Asiakas dao = new Dao_Asiakas();
		try {
			Asiakas asiakas = dao.haeAsiakas(Integer.parseInt(id));
			request.setAttribute("asiakas", asiakas);		
			String jsp = "/muokkaaasiakas.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaAsiakas.doPost()");
		Asiakas asiakas = new Asiakas();
		asiakas.setAsiakas_id(Integer.parseInt(request.getParameter("asiakas_id")));
		asiakas.setEtunimi(request.getParameter("etunimi"));
		asiakas.setSukunimi(request.getParameter("sukunimi"));
		asiakas.setNimimerkki(request.getParameter("nimimerkki"));
		asiakas.setPuhelin(request.getParameter("puhelin"));
		asiakas.setOsoite(request.getParameter("osoite"));
		asiakas.setSalasana(request.getParameter("salasana"));
		asiakas.setSahkoposti(request.getParameter("sahkoposti"));
		
		
		Dao_Asiakas dao = new Dao_Asiakas();
		dao.muutaAsiakas(asiakas);
		//Sukunimi pit�� enkoodata, koska se kulkee urlissa ja siin� voi olla skandeja. URLEncoder.encode(request.getParameter()
		response.sendRedirect("Servlet_HaeAsiakkaat?hakusana=" + URLEncoder.encode(request.getParameter("sukunimi"), "UTF-8"));
	}

}
