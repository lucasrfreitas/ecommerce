package br.freitas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.freitas.dao.DaoPessoa;
import br.freitas.model.Pessoa;

/**
 * Servlet implementation class Cadastrar
 */
@WebServlet("/Cadastrar")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected Cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
        Pessoa UmaPessoa = new Pessoa();
        UmaPessoa.setNome(request.getParameter("Nome"));
        UmaPessoa.setCpf(request.getParameter("Cpf"));
        UmaPessoa.setCpf(request.getParameter("Senha"));
        DaoPessoa UmaPessoaDao = new DaoPessoa();
        UmaPessoaDao.InserePessoa(UmaPessoa);
        saida.println("Cadastrado!!!");
		
	}
	}

	
}
