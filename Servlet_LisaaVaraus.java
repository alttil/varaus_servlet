package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_VarausHallit;
import model.Varaus;



@WebServlet("/Servlet_LisaaVaraus")
public class Servlet_LisaaVaraus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_LisaaVaraus() {
        super();
    System.out.println("Servlet_LisaaVaraus.Servlet_LisaaVaraus()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet_LisaaVaraus.doGet()");
	Varaus varaus = new Varaus ();
	varaus.setTunti_id(Integer.parseInt(request.getParameter("tunti_id")));
	varaus.setKentta_id(Integer.parseInt(request.getParameter("kentta_id")));
	Date Paiva=null;
    SimpleDateFormat paiva=new SimpleDateFormat("dd.MM.yyyy");	    	
	try {
		Paiva = paiva.parse(request.getParameter("paiva"));
	} catch (ParseException e) {			
		e.printStackTrace();
	}
	varaus.setPaiva(Paiva);
	
	Dao_VarausHallit dao = new Dao_VarausHallit();
	try {
		//kirjoitetaan ajaxille vastaus varauksen lis‰‰misen onnistumisesta
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html"); 	
	    if(dao.lisaaVaraus(varaus)){
	    	out.println(1);	
	    }else{
	    	out.println(0);	
	    }			
	} catch (Exception e) {			
		e.printStackTrace();
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet_LisaaVaraus.doPost()");
	}

}
