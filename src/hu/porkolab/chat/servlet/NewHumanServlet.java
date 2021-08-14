package hu.porkolab.chat.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.porkolab.chat.model.Human;

@WebServlet(urlPatterns = { "/NewHumanServlet" })
public class NewHumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewHumanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		response.setContentType("text/plain;charset=UTF-8");
		
		String name = request.getParameter("name");
		if (name.equals(""))
			name = "N/A";
		
		Human human = new Human(name);
		
		HttpSession session = request.getSession();
		session.setAttribute("human", human);
		
		RequestDispatcher rdis = request.getRequestDispatcher("/DisplayServlet");
		rdis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
