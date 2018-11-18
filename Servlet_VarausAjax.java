package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;


@WebServlet("/Servlet_VarausAjax")
public class Servlet_VarausAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet_VarausAjax() {
        super();
     System.out.println("Servlet_VarausAjax.Servlet_VarausAjax()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet_VarausAjax.doGet()");
	String merkki_id=request.getParameter("tunti_id");
	Dao dao = new Dao();
	try {
		String[] sarakkeet={"tunti_id", "paiva"};
		String strJSON = dao.haeTiedotJSON(sarakkeet,"VJ_varaus_hallit","kentta_id",kentta_id,2);
		PrintWriter out = response.getWriter(  );
	    response.setContentType("text/html"); 
	    out.println(strJSON);			
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet_VarausAjax.doPost()");
	}

}
