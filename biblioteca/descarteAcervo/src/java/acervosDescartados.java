/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juanr
 */
@WebServlet(urlPatterns = {"/acervosDescartados"})
public class acervosDescartados extends HttpServlet {

    // Constantes de conexão ao MYSQL
    final String SERVIDOR_SQL = "jdbc:mysql://localhost:3307/biblioteca",
	    USUARIO_ADMIN_SQL = "root",
	    SENHA_ADMIN_SQL = "123456";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String id_acervo = request.getParameter("acervo");

	Boolean pesquisa_especifica = !(id_acervo == null || id_acervo == "");

	try (PrintWriter out = response.getWriter()) {
            
	    try {
		// Query SQL de seleção de todos valores da tabela DESCARTES
		String query;

		if (pesquisa_especifica) {
		    query = "SELECT * FROM descartes WHERE `id-acervo`=" + id_acervo;
		} else {
		    query = "SELECT * FROM descartes";
		}

		// Conecta e executa Query SQL
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(SERVIDOR_SQL, USUARIO_ADMIN_SQL, SENHA_ADMIN_SQL);
		PreparedStatement st = conexao.prepareStatement(query);

		ResultSet resultado = st.executeQuery();

                String xml = RespostaXML.retornaSet(resultado, "id-acervo","data-descarte","motivos","operador");
                
                out.print(xml);
                
		st.close();
		conexao.close();

	    } catch (SQLException e) {
                out.print(RespostaXML.erro("Erro no banco de dados!", e.getMessage()));
                e.printStackTrace();
	    }
            
	}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
