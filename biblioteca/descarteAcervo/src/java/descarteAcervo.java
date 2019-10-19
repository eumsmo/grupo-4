
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns = {"/descarteAcervo"})
public class descarteAcervo extends HttpServlet {

    // Constantes de conexão ao MYSQL
    final String SERVIDOR_SQL = "jdbc:mysql://localhost:3307/biblioteca",
	    USUARIO_ADMIN_SQL = "root",
	    SENHA_ADMIN_SQL = "123456";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// Receber parametros do descarte de acervo
	String id_acervo_string = request.getParameter("acervo"),
		data = request.getParameter("data"),
		motivo = request.getParameter("motivacao"),
		id_funcionario = request.getParameter("funcionario");

	int id_acervo = Integer.parseInt(id_acervo_string);
	Date date = Date.valueOf(data);

	try (PrintWriter out = response.getWriter()) {

	    try {
		// Query SQL de inserção na tabela DESCARTES
		// id_acervo e id_funcionario não estão sendo tratados como string e por isso não possue aspas na query
		String query = "INSERT INTO descartes(idAcervo,dataDescarte , motivos, operador) VALUES (?,?,?,?)";

		// Conecta e executa Query SQL
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(SERVIDOR_SQL, USUARIO_ADMIN_SQL, SENHA_ADMIN_SQL);
		PreparedStatement st = conexao.prepareStatement(query);

		st.setInt(1, id_acervo); //id-acervo
		st.setDate(2, date); //data-descarte
		st.setString(3, motivo); // motivos
		st.setString(4, id_funcionario); //operador

		int res = st.executeUpdate();
		st.close();
		conexao.close();

		if (res == 1) {
		    out.println("Acervo " + id_acervo + " foi descartado!");
		}

	    } catch (SQLException e) {
		out.println("ERRO DE GRAVACAO/CONEXÃO NA TABELA 'DESCARTES' - " + e.getMessage());
		return;
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
