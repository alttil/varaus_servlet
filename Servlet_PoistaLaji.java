package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao_Laji;


@WebServlet("/Servlet_PoistaLaji")
public class Servlet_PoistaLaji extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_PoistaLaji() {
        super();
        System.out.println("Servlet_PoistaLaji.Servlet_PoistaLaji()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaLaji.doGet()");
		String id = request.getParameter("laji_id");
		id=id.replace("poista_", "");
		Dao_Laji dao = new Dao_Laji();
		try {
			dao.poistaLaji(Integer.parseInt(id));
			HttpSession session = request.getSession(true);
			response.sendRedirect("Servlet_HaeLajit?hakusana=" + session.getAttribute("hakusanalaji"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet_PoistaLaji.doPost()");
	}

}
