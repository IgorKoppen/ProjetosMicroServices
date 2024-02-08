package br.com.fiap.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.model.Pessoa;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    private void processarRequisicao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String nome = req.getParameter("nome");
    	String sobrenome = req.getParameter("sobrenome");
    	String email = req.getParameter("email");
    	Pessoa pessoa = new Pessoa(nome, sobrenome, email);   	
    	req.setAttribute("Pessoa", pessoa);
    	RequestDispatcher view = req.getRequestDispatcher("saudacao.jsp");
    	view.forward(req, res);
    }
}
