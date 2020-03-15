package AllServices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/AddRegularEmployee", "/add-regular-employee" })
public class AddRegularEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddRegularEmployee() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoreTest manager = new StoreTest();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
			manager.addRegularEmployee(request.getParameter("name"), Float.parseFloat(request.getParameter("salary")), Integer.parseInt(request.getParameter("bonus")));
		} catch(Exception e) {
			e.printStackTrace();
			out.append("sorry");
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
