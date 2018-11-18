package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao_Halli;
import model.Halli;


@WebServlet("/Servlet_HaeHallit")
public class Servlet_HaeHallit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_HaeHallit() {
        super();
        System.out.println("Servlet_HaeHallit.Servlet_HaeHallit()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeHallit.doGet()");
		String hakusana = request.getParameter("hakusana");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("hakusanaHalli", hakusana);	
				
		Dao_Halli dao = new Dao_Halli();
		try {
			ArrayList<Halli> hallit = dao.haeHallit(hakusana);
			request.setAttribute("hallit", hallit);		
			String jsp = "/hallihaku.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeHallit.doPost()");
		
	}

}
