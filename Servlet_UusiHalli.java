package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_Halli;
import model.Halli;


@WebServlet("/Servlet_UusiHalli")
public class Servlet_UusiHalli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_UusiHalli() {
        super();
       System.out.println("Servlet_UusiHalli.Servlet_UusiHalli()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiHalli.doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiHalli.doPost()");
		
		Halli halli = new Halli();
		halli.setNimi(request.getParameter("hnimi"));
		halli.setPuhelin(request.getParameter("hpuhelin"));
		halli.setSahkoposti(request.getParameter("hsahkoposti"));
		halli.setOsoite(request.getParameter("hosoite"));

		Dao_Halli dao = new Dao_Halli();
		if(dao.lisaaHalli(halli)){
			response.sendRedirect("uusihalli.jsp?ok=1");
		}else{
			response.sendRedirect("uusihalli.jsp?ok=0");
		}
	}

}
