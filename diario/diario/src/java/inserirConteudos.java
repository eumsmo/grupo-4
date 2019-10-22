/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcus
 */
@WebServlet(urlPatterns = {"/inserirConteudos"})
public class inserirConteudos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        final String SERVIDOR_SQL = "jdbc:mysql://localhost:3307/biblioteca",
	    USUARIO_ADMIN_SQL = "root",
	    SENHA_ADMIN_SQL = "123456";
        
        String id_etapas_string = request.getParameter("etapas"),
                id_disciplinas = request.getParameter("disciplinas") ,
		conteudos = request.getParameter("conteudos"),
		datas = request.getParameter("datas");
            
                int id_etapas = Integer.parseInt(id_etapas_string);
                Date date = Date.valueOf(datas);
                
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
                
                // Query SQL de inserção na tabela DESCARTES
		String query = "INSERT INTO conteudos(idEtapas,idDisciplinas , conteudos , datas) VALUES (?,?,?,?)";

		// Conecta e executa Query SQL
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(SERVIDOR_SQL, USUARIO_ADMIN_SQL, SENHA_ADMIN_SQL);
		PreparedStatement st = conexao.prepareStatement(query);

		st.setInt(1, id_etapas); //id-etapas
		st.setString(2, id_disciplinas); //id-disciplinas
		st.setString(3, conteudos); // conteudos
		st.setDate(4, date); //datas

		int res = st.executeUpdate();
		st.close();
		conexao.close();


            /* TODO output your page here. You may use following sample code. */
           
        } catch (SQLException e) {
		out.println("ERRO DE GRAVACAO/CONEXÃO NA TABELA 'CONTEUDOS' - " + e.getMessage());
		return;
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
