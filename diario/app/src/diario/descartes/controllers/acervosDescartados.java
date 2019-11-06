/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diario.descartes.controllers;
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
import utils.ConnectionFactory;


/**
 *
 * @author juanr
 */

public class acervosDescartados {


    protected void processRequest(int id_acervo)throws SQLException {

	

	Boolean pesquisa_especifica = !(id_acervo == null || id_acervo == "");

	    
	    try {
		// Query SQL de seleção de todos valores da tabela DESCARTES
		String query;

		if (pesquisa_especifica) {
		    query = "SELECT * FROM descartes WHERE `id-acervo`=" + id_acervo;
		} else {
		    query = "SELECT * FROM descartes";
		}

		// Conecta e executa Query SQL
		
                Connection conexao = ConnectionFactory.getConnection("biblioteca");
		PreparedStatement st = conexao.prepareStatement(query);

		ResultSet resultado = st.executeQuery();

                String xml = RespostaXML.retornaSet(resultado, "id-acervo","data-descarte","motivos","operador");
                
           //     out.print(xml);
                
		st.close();
		conexao.close();

	    } catch (SQLException e) {
                
                e.printStackTrace();
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
