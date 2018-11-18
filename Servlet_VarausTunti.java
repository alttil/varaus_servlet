package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_VarausHallit;
import model.Kentta;
import model.Varaushalli;



@WebServlet("/Servlet_VarausTunti")
public class Servlet_VarausTunti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Servlet_VarausTunti() {
        super();
        System.out.println("Servlet_VarausTunti.Servlet_VarausTunti()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VarausTunti.doGet()");
		String id = request.getParameter("varaus_id");
		id=id.replace("tarjoa_", "");
		Dao_VarausHallit dao = new Dao_VarausHallit();
		try {
			Varaushalli varaushalli = dao.haeVaraushalli(Integer.parseInt(id));			
			request.setAttribute("varaushalli", varaushalli);	
			Kentta kentta = dao.haeKentta(Integer.parseInt(id));				
			request.setAttribute("kentta", kentta);
			String jsp = "/uusivaraushalli.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_VarausTunti.doPost()");
	}

}
