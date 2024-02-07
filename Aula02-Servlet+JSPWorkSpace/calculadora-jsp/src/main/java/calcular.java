

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcular
 */
@WebServlet("/calcular")
public class calcular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcular() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double base = formateInput(request.getParameter("base"));
		double altura = formateInput(request.getParameter("altura"));
		if(base != 0 && altura != 0) {
			String area = String.valueOf((base * altura));
			String perimetro = String.valueOf(2*(base + altura));
		
			request.setAttribute("area", area);
			request.setAttribute("perimetro", perimetro);
			request.getRequestDispatcher("resultado.jsp").forward(request,response);
		}

	}
	
	private double formateInput(String input) {
		if(input == null || input == "") {
			return 0;
		}
		String inputNew = input.replaceAll(",", ".");
		return Double.parseDouble(inputNew);
	}

}
