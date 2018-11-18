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
import model.Asiakas;
import model.Kentta;
import model.Tunti;
import model.Varaushalli;
import dao.Dao_Asiakas;
import dao.Dao_Tunti;
import dao.Dao_VarausHallit;




@WebServlet("/Servlet_HaeVaraushallit")
public class Servlet_HaeVaraushallit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_HaeVaraushallit() {
        super();
        System.out.println("Servlet_HaeVaraushallit.Servlet_HaeVaraushallit()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeVaraushallit.doGet()");
		
		if(request.getParameter("hakusana")!=null){
			String hakusana = request.getParameter("hakusana");	
			HttpSession session = request.getSession(true);
			session.setAttribute("hakusanaVaraushalli", hakusana);	
			System.out.println(hakusana);		
		Dao_VarausHallit dao = new Dao_VarausHallit();
		try {
			ArrayList<Varaushalli> varaushallit = dao.haeVaraushallit(hakusana);
			request.setAttribute("varaushallit", varaushallit);		
			String jsp = "/haevaraushallit.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_HaeVaraushallit.doPost()");
	}

}
