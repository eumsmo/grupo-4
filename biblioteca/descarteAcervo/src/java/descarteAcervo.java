
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
        
        int id_acervo;
        Date date;
        
	try (PrintWriter out = response.getWriter()) {
            
            try{
                id_acervo = Integer.parseInt(id_acervo_string);
                date = Date.valueOf(data);
            } catch(NumberFormatException | NullPointerException e){
                out.print(RespostaXML.erro("Input errado!",e.getMessage()));
                return;
            }
            
	    try {
		// Query SQL de inserção na tabela DESCARTES
		String query = "INSERT INTO descartes(`id-acervo`,`data-descarte`, motivos, operador) VALUES (?,?,?,?)";
                String queryDelete = "DELETE FROM acervo WHERE id="+id_acervo;
		// Conecta e executa Query SQL
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(SERVIDOR_SQL, USUARIO_ADMIN_SQL, SENHA_ADMIN_SQL);
                conexao.createStatement().executeUpdate(queryDelete);
                PreparedStatement st = conexao.prepareStatement(query);

		st.setInt(1, id_acervo); //id-acervo
		st.setDate(2, date); //data-descarte
		st.setString(3, motivo); // motivos
		st.setString(4, id_funcionario); //operador

		int res = st.executeUpdate();
		st.close();
		conexao.close();

		String xml = RespostaXML.sucesso("Acervo " + id_acervo + " foi descartado!");
		out.print(xml);
		

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
