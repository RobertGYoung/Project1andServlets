

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class collector
 */
public class collector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public collector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			this.processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String[] itemList = request.getParameterValues("items");
		session.setAttribute("name", name);
		session.setAttribute("items", itemList);
		out.print("<html><body><h2> Heyo "+name+"</h2> <br> <p>you have selected the following items</p>");
		for(int i = 0; i<itemList.length;i++) {
			out.print(itemList[i]+"<br>");
		}
		out.print("<br><br><br>");
		out.print("<form action='check'><input type=submit value='Check Out'/></form></body></html>");
	}
}
