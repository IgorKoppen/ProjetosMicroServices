package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String nome = (String) request.getParameter("nome");
	   String senha = (String) request.getParameter("senha");
		request.setAttribute("error", true);
		if(nome.equals("igor") && senha.equals("123")) {
			request.setAttribute("nome", nome);
			request.getRequestDispatcher("home.jsp").forward(request,response);
		}else {
		request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}

}
