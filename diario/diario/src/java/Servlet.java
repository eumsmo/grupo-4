import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Julia
 */

@WebServlet(urlPatterns = {"/NotasServlet"})
public class Servlet extends HttpServlet {
    // Constantes de conexão ao MYSQL
    final String SERVIDOR_SQL = "jdbc:mysql://localhost:3307/diario",
            USUARIO_ADMIN_SQL = "root",
            SENHA_ADMIN_SQL = "123456";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recebe parametros do quadro atividades: id, id-disciplinas, nome, data, valor e depois INSERT INTO DIARIO
        //buscar os dados que foram enviados na requisição usando request
        
        String id_disciplinas = request.getParameter("id_disciplinas");
        String nome = request.getParameter("nome");
        String data_string = request.getParameter("data");
        String valor = request.getParameter("valor");
        Date data = Date.valueOf(data_string);
        
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection(SERVIDOR_SQL, USUARIO_ADMIN_SQL, SENHA_ADMIN_SQL);
            String query = "INSERT INTO  atividades (id_disciplinas, nome, data, valor) VALUES("+id_disciplinas+",\""+nome+"\", ?, "+valor+")"; //insere na tabela diario ou na tabela atividades?
            PreparedStatement stmt= con.prepareStatement(query);
            stmt.setDate(1, data);
            stmt.execute();    
            System.out.println("Os dados foram inseridos"); // NOTA: System.out não imprime na tela, e sim no log de saida o Glassfish!
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        /* TODO output your page here. You may use following sample code. */
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
