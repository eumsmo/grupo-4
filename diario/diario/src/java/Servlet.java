import static com.oracle.wls.shaded.org.apache.xpath.XPath.SELECT;
import static com.sun.mail.imap.SortTerm.FROM;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
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
    Connection con;
    Statement stmt;
    String dbstring="jdbc:sqlserver://DevCode:;database=;user=root;password=123456"; //problema no bd preencher depois
    // Constantes de conexão ao MYSQL
    final String SERVIDOR_SQL = "jdbc:mysql://localhost:3307/biblioteca",
            USUARIO_ADMIN_SQL = "root",
            SENHA_ADMIN_SQL = "123456";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recebe parametros do quadro atividades: id, id-disciplinas, nome, data, valor e depois INSERT INTO DIARIO
        //buscar os dados que foram enviados na requisição usando request
        
        String id = request.getParameter("id"); //pra que serve esse id??
        String id_disciplinas = request.getParameter("id_disciplinas");
        String nome = request.getParameter("nome");
        String data = request.getParameter("data");
        String valor = request.getParameter("valor");
        Calendar Data = null;

        // fazendo a conversão da data
        try {
            Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(data);
            Data = Calendar.getInstance();
            Data.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão na data");
            return; //para a execução do método
        }
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriveManager.getConnection(dbstring);
            stmt=con.createStatement();
            String query = "INSERT INTO  atividades (id_disciplinas,nome,data, valor) + VALUES(1 +""+ "Geografia" + "20/02/2017" + 0)"; //insere na tabela diario ou na tabela atividades?
            stmt.execute(query);    
            System.out.println("Os dados foram inseridos");
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        /* TODO output your page here. You may use following sample code. */
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
