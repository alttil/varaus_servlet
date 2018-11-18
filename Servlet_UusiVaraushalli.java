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
import dao.Dao_VarausHallit;
import model.Varaushalli;


@WebServlet("/Servlet_UusiVaraushalli")
public class Servlet_UusiVaraushalli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_UusiVaraushalli() {
        super();
        System.out.println("Servlet_UusiVaraushalli.Servlet_UusiVaraushalli()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiVaraushalli.doGet()");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiVaraushalli.doPost()");
		
		
		
		Varaushalli varaushalli = new Varaushalli();
		varaushalli.setTunti_id(Integer.parseInt(request.getParameter("tunti_id")));
		varaushalli.setAsiakas_id(Integer.parseInt(request.getParameter("asiakas_id")));
		varaushalli.setKentta_id(Integer.parseInt(request.getParameter("kentta_id")));
		varaushalli.setPaiva_id(Integer.parseInt(request.getParameter("paiva_id")));
		varaushalli.setKuukausi_id(Integer.parseInt(request.getParameter("kuukausi_id")));
		varaushalli.setVuosi_id(Integer.parseInt(request.getParameter("vuosi_id")));
		Date Paiva=null;
	    SimpleDateFormat paiva=new SimpleDateFormat("dd.MM.yyyy");	    	
    	try {
			Paiva = paiva.parse(request.getParameter("paiva"));
			//split paiva
			//split kuukausi
			//split vuosi
		} catch (ParseException e) {			
			e.printStackTrace();
		}
    	varaushalli.setPaiva(Paiva);
    	//set paiva_id
    	//set kuukausi_id
    	//set vuosi_id
		
		
		Dao_VarausHallit dao = new Dao_VarausHallit();
		if(dao.lisaaVaraushalli(varaushalli)){
			response.sendRedirect("uusivaraushalli.jsp?ok=1");
		}else{
			response.sendRedirect("uusivaraushalli.jsp?ok=0");
		}
	}

}
