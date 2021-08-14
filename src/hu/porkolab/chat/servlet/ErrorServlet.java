package hu.porkolab.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setStatus(200);
		Integer errorCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
		Class<?> exceptionType = (Class<?>)request.getAttribute("javax.servlet.error.exception_type");
		Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
		String message = (String)request.getAttribute("javax.servlet.error.message");
		String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
		String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>Hiba történt!</title></head>");
		writer.printf("<body>Hiba történt a Chat webalkalmazásban.<br>Hibakód: %d<br>Hiba szövege: %s<br>Kivétel típusa: %s<br>Kivétel: %s<br>URL: %s<br>Servlet neve: %s<br></body></html>\n",
				errorCode, message, exceptionType.toString(), throwable.toString(), requestUri, servletName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
