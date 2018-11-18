package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao_Halli;


@WebServlet("/Servlet_PoistaHalli")
public class Servlet_PoistaHalli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_PoistaHalli() {
        super();
        System.out.println("Servlet_PoistaHalli.Servlet_PoistaHalli()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaHalli.doGet()");
		String id = request.getParameter("halli_id");
		id=id.replace("poista_", "");
		Dao_Halli dao = new Dao_Halli();
		try {
			dao.poistaHalli(Integer.parseInt(id));
			HttpSession session = request.getSession(true);
			response.sendRedirect("Servlet_HaeHallit?hakusana=" + session.getAttribute("hakusanaHalli"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaHalli.doPost()");
	}

}
