package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_Varaus;
import model.Varaushalli;
import model.Varaus;


@WebServlet("/Servlet_UusiVaraus")
public class Servlet_UusiVaraus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Servlet_UusiVaraus() {
        super();
        System.out.println("Servlet_UusiVaraus.Servlet_UusiVaraus()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiVaraus.doGet()");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiVaraus.doPost()");
		
		Varaushalli varaushalli = new Varaushalli();
		varaushalli.setAlkuaika(request.getParameter("alkuaika"));
		//varaushalli.setLoppuaika(request.getParameter("loppuaika"));
		 Date Paiva=null;
		    SimpleDateFormat paiva=new SimpleDateFormat("dd.MM.yyyy");	    	
	    	try {
				Paiva = paiva.parse(request.getParameter("paiva"));
			} catch (ParseException e) {			
				e.printStackTrace();
			}
		

		Dao_Varaus dao = new Dao_Varaus();
		if(dao.lisaaVaraushalli(varaushalli)){
			response.sendRedirect("uusivaraus.jsp?ok=1");
		}else{
			response.sendRedirect("uusivaraus.jsp?ok=0");
		}
		
	}

}
