import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet(urlPatterns = {"/Faltas"})
public class Faltas extends HttpServlet {
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Receber parametros do descarte de acervo
        String IdConteudo = request.getParameter("idconteudo"),
               Idmatriculas = request.getParameter("idmatriculas"),
              Idatividades = request.getParameter("idatividades"),
               faltas = request.getParameter("faltas");
             int  M=1;  
        try (PrintWriter out = response.getWriter()) {     
            try {
                  
               //String query =  "INSERT INTO `diario` (`idConteudos`, `idMatriculas`, `idAtividades`, `faltas`, `nota`) VALUES ("+IdConteudo+","+Idmatriculas+", "+Idatividades+", "+faltas+", "+faltas+");";
              String query = "SELECT matriculas.id FROM  matriculas ,alunos WHERE IdDisciplinas=0 AND alunos.id=matriculas.idAlunos;";
           //   String query ="DELETE FROM diario WHERE faltas =1";
               DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root",""); 
               PreparedStatement st = conexao.prepareStatement(query);
               ResultSet rs2 = st.executeQuery();
               st = conexao.prepareStatement("SELECT nome, alunos.id,diario.faltas FROM alunos, matriculas ,diario WHERE matriculas.idDisciplinas=0 AND alunos.id=matriculas.idAlunos AND diario.idMatriculas= matriculas.id"); 
               ResultSet rs = st.executeQuery();
    while ( rs.next() && rs2.next()) {
        String mat = rs2.getString("matriculas.id"); 
        String nome = rs.getString("alunos.nome");
        String QfaltasAnteriores = rs.getString("faltas");
        int Quantidadefaltas=  Integer.parseInt(QfaltasAnteriores);
        Quantidadefaltas++;
        faltas=Integer.toString(Quantidadefaltas);
        out.println("<h1>matricula: "+mat+"Nome "+nome+" faltas"+faltas+"  </h1>"); 
        query="UPDATE diario,alunos,matriculas SET faltas="+faltas+" WHERE matriculas.idDisciplinas=0 AND alunos.id=matriculas.idAlunos AND diario.idMatriculas= matriculas.id ;";
      //   query =  "INSERT INTO `diario` (`idConteudos`, `idMatriculas`, `idAtividades`, `faltas`, `nota`) VALUES (0,"+mat+",0,"+faltas+",0);";
         st=conexao.prepareStatement(query);
         st.executeUpdate(); 
    }
         

                
       }
          
            catch(SQLException e){
             out.println("ERRO  "+e.getMessage());
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
    }

}
