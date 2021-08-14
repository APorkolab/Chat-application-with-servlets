package hu.porkolab.chat.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.porkolab.chat.model.Message;
import hu.porkolab.chat.model.Human;

@WebServlet(urlPatterns = { "/WriteServlet" })
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String messageString = request.getParameter("messageString");
		if (messageString == null) {
			RequestDispatcher rdis = request.getRequestDispatcher("/DisplayServlet");
			rdis.forward(request, response);
		}

		Human human = (Human) request.getSession().getAttribute("human");

		Message message = new Message(human, messageString);

		ArrayList<Message> allMessage = (ArrayList<Message>) session.getAttribute("allMessage");

		if (allMessage == null) {
			allMessage = new ArrayList<>();
		}

		allMessage.add(message);
		session.setAttribute("allMessage", allMessage);

		RequestDispatcher rdis = request.getRequestDispatcher("/DisplayServlet");
		rdis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
