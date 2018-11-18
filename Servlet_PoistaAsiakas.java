package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao_Asiakas;


@WebServlet("/Servlet_PoistaAsiakas")
public class Servlet_PoistaAsiakas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet_PoistaAsiakas() {
        super();
        System.out.println("Servlet_PoistaAsiakas.Servlet_PoistaAsiakas()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaAsiakas.doGet()");
		String id = request.getParameter("asiakas_id");
		id=id.replace("poista_", "");
		Dao_Asiakas dao = new Dao_Asiakas();
		try {
			dao.poistaAsiakas(Integer.parseInt(id));
			HttpSession session = request.getSession(true);
			response.sendRedirect("Servlet_HaeAsiakkaat?hakusana=" + session.getAttribute("hakusanaAsiakas"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaAsiakas.doPost()");
	}

}
