package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_Halli;
import model.Halli;


@WebServlet("/Servlet_MuokkaaHalli")
public class Servlet_MuokkaaHalli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_MuokkaaHalli() {
        super();
        System.out.println("Servlet_MuokkaaHalli.Servlet_MuokkaaHalli()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaHalli.doGet()");
		String id = request.getParameter("halli_id");
		id=id.replace("muokkaa_", "");
		Dao_Halli dao = new Dao_Halli();
		try {
			Halli halli = dao.haeHalli(Integer.parseInt(id));
			request.setAttribute("halli", halli);		
			String jsp = "/muokkaahalli.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaHalli.doPost()");
		Halli halli = new Halli();
		halli.setHalli_id(Integer.parseInt(request.getParameter("halli_id")));
		halli.setNimi(request.getParameter("nimi"));
		halli.setPuhelin(request.getParameter("puhelin"));
		halli.setSahkoposti(request.getParameter("sahkoposti"));
		halli.setOsoite(request.getParameter("osoite"));
		
		
		Dao_Halli dao = new Dao_Halli();
		dao.muutaHalli(halli);
		//Nimi pit‰‰ enkoodata, koska se kulkee urlissa ja siin‰ voi olla skandeja. URLEncoder.encode(request.getParameter()
		response.sendRedirect("Servlet_HaeHallit?hakusana=" + URLEncoder.encode(request.getParameter("nimi"), "UTF-8"));
	}

}
