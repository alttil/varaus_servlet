package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;


@WebServlet("/Servlet_VarauksetAjax")
public class Servlet_VarauksetAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet_VarauksetAjax() {
        super();
    System.out.println("Servlet_VarauksetAjax.Servlet_VarauksetAjax()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet_VarauksetAjax.doGet()");
	String paiva=request.getParameter("paiva");
	Dao dao = new Dao();
	try {
		String[] sarakkeet={"kentta_id", "tunti_id"};
		String strJSON = dao.haeTiedotJSON(sarakkeet,"VJ_varaus_hallit","paiva",paiva,2);
		PrintWriter out = response.getWriter(  );
	    response.setContentType("text/html"); 
	    out.println(strJSON);			
	} catch (Exception e) {
		e.printStackTrace();
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Servlet_VarauksetAjax.doPost()");
	}

}
