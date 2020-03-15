package AllServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeAdd.Regular_Employee;

@WebServlet({ "/ShowAllRegularEmployees", "/showAllRegularEmployees" })
public class ShowAllRegularEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowAllRegularEmployees() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		FetchTest ft = new FetchTest();
		List<Regular_Employee> list = ft.showAllRegularEmployees();
		Iterator<Regular_Employee> iterator = list.iterator();
		while(iterator.hasNext()) {
			Regular_Employee e = iterator.next();
			out.print(e.getName()+" "+e.getSalary()+"<br><br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
