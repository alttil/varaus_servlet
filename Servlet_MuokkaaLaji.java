package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_Laji;
import model.Laji;


@WebServlet("/Servlet_MuokkaaLaji")
public class Servlet_MuokkaaLaji extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_MuokkaaLaji() {
        super();
        System.out.println("Servlet_MuokkaaLaji.Servlet_MuokkaaLaji()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaLaji.doGet()");
		String id = request.getParameter("laji_id");
		id=id.replace("muokkaa_", "");
		Dao_Laji dao = new Dao_Laji();
		try {
			Laji laji = dao.haeLaji(Integer.parseInt(id));
			request.setAttribute("laji", laji);		
			String jsp = "/muokkaalaji.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_MuokkaaLaji.doPost()");
		Laji laji = new Laji();
		laji.setLaji_id(Integer.parseInt(request.getParameter("laji_id")));
		laji.setNimi(request.getParameter("nimi"));
		laji.setHalli_id(Integer.parseInt(request.getParameter("halli_id")));
		
		Dao_Laji dao = new Dao_Laji();
		dao.muutaLaji(laji);
		//Nimi pit‰‰ enkoodata, koska se kulkee urlissa ja siin‰ voi olla skandeja. URLEncoder.encode(request.getParameter()
		response.sendRedirect("Servlet_HaeLajit?hakusana=" + URLEncoder.encode(request.getParameter("nimi"), "UTF-8"));
	}

}
