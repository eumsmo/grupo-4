/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diario.descartes.repository;

import diario.descartes.model.Departamento;
import diario.descartes.controllers.RespostaXML;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import utils.ConnectionFactory;

/**
 *
 * @author User
 */
public interface DescartesRep {
    
    public static void insereDescartesEremoveAcervo(String motivo,String idFuncionario,int idAcervo,Date data) throws SQLException{
        Connection con = ConnectionFactory.getBiblioteca();
        if(con != null){
            String queryDelete = "DELETE FROM acervo WHERE id="+idAcervo;
            con.createStatement().executeUpdate(queryDelete);
            PreparedStatement prst = con.prepareStatement("INSERT INTO descartes(`id-acervo`,`data-descarte`, motivos, operador) VALUES (?,?,?,?)");
            
            prst.executeUpdate();
            prst.close();
            con.close();
            prst.setInt(1, idAcervo); //id-acervo
	    prst.setDate(2, data); //data-descarte
            prst.setString(3, motivo); // motivos
	    prst.setString(4, idFuncionario); //operador
            prst.executeUpdate();
            prst.close();
            con.close();
		
	String xml = RespostaXML.sucesso("Acervo " + idAcervo + " foi descartado!");
		//out.print(xml);
        }
        else{
            throw new SQLException();
        }
    }
      public static List<Departamento> consulta() throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){    
            Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `departamentos`");

		List<Departamento> deptos = new LinkedList();

            while(rs.next()) {
                deptos.add(new Departamento(rs.getInt("id"), rs.getInt("id-campi"), rs.getString("nome")));
            }
                
            stmt.close();
            con.close();
            return deptos;
        }
        else{
            throw new SQLException();
        }
    }

    public static Departamento consulta(int id) throws SQLException {
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("SELECT * FROM `departamentos` WHERE `id` = ?");
            prst.setInt(1, id);
			ResultSet rs = prst.executeQuery();
            
            Departamento depto = new Departamento(rs.getInt("id"), rs.getInt("idCampi"), rs.getString("nome"));
            
			prst.close();
			con.close();

            return depto;
        }
        else{
            throw new SQLException();
        }
    }

   
}
