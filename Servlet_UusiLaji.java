package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_Laji;
import model.Laji;



@WebServlet("/Servlet_UusiLaji")
public class Servlet_UusiLaji extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_UusiLaji() {
        super();
        System.out.println("Servlet_UusiLaji.Servlet_UusiLaji()");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiLaji.doGet()");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_UusiLaji.doPost()");
		
		Laji laji = new Laji();
		laji.setNimi(request.getParameter("nimi").trim());
		laji.setHalli_id(Integer.parseInt(request.getParameter("halli_id")));

		Dao_Laji dao = new Dao_Laji();
		if(dao.lisaaLaji(laji)){
			response.sendRedirect("uusilaji.jsp?ok=1");
		}else{
			response.sendRedirect("uusilaji.jsp?ok=0");
		}
	}

}
