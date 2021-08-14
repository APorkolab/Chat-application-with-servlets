package hu.porkolab.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.porkolab.chat.model.Human;
import hu.porkolab.chat.model.Message;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		Human human = (Human)request.getSession().getAttribute("human");
		if (human == null) {
			request.getRequestDispatcher("/StartServlet").forward(request, response);
			return;
		}
	

		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head><title>Chat applikáció</title></head>");
		writer.println("<body>");
		writer.println("<h1>Adatok</h1>");
		writer.printf("Usernév: %s <br>\n", human.getName());
		
		writer.println("<h2>Eddigi üzenetek</h2>");
		
		ArrayList<Message> allMessage = (ArrayList<Message>)session.getAttribute("allMessage");
		if (allMessage != null) {
        for (int i = 0; i < allMessage.size(); i++) {
        	writer.printf("%s <br>\n", allMessage.get(i).toString());
        }
		}else {
			writer.print("Nincs üzenet eltárolva.");
		}
		
		
		writer.println("<h2>Üzenet beküldése</h2>");
		writer.println("<form action=\""+getServletContext().getContextPath()+"/WriteServlet\" method=\"GET\">");
		writer.println("<label for=\"messageString\">Írja be az üzenetét:</label><br>");
		writer.println("<input type=\"text\" id=\"messageString\" name=\"messageString\"><br>");
		writer.println("<input type=\"submit\" value=\"Üzenet beküldése\"/><br>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	


}
