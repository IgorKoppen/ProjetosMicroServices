package servlets;


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
		double altura = 0;
		double base = 0;
		try {
			 altura = formatarInput(request.getParameter("altura"));
			 base = formatarInput(request.getParameter("base"));
		} catch (Exception e) {
			request.setAttribute("erro", "inputs invalidos!");
			e.printStackTrace();
		}
		if(base != 0 && altura != 0) {
			request.setAttribute("area", calcularArea(base, altura));
			request.setAttribute("perimetro",calcularPerimetro(base, altura));
			request.getRequestDispatcher("resultado.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
	private double calcularArea(double base,double altura) {
		return base * altura;
	}
	private double calcularPerimetro(double base,double altura) {
		return (2*(base + altura));
	}
	private double formatarInput(String input) throws Exception {
		if(input == null || input == "") {
			throw new Exception("Input inválido");
		}
		String inputNew = input.replaceAll(",", ".");
		return Double.parseDouble(inputNew);
	}

}
