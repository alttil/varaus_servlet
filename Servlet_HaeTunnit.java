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
import dao.Dao_Tunti;
import model.Tunti;


@WebServlet("/Servlet_HaeTunnit")
public class Servlet_HaeTunnit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_HaeTunnit() {
        super();
        System.out.println("Servlet_HaeTunnit.Servlet_HaeTunnit()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeTunnit.doGet()");
		String hakusana = request.getParameter("hakusana");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("hakusanaTunti", hakusana);	
				
		Dao_Tunti dao = new Dao_Tunti();
		try {
			ArrayList<Tunti> tunnit = dao.haeTunnit(hakusana);
			request.setAttribute("tunnit", tunnit);		
			String jsp = "/haetunnit.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeTunnit.doPost()");
	}

}
