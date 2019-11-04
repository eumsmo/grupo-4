package diario.departamentos.repository;

import diario.departamentos.model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import utils.ConnectionFactory;

public class DepartamentoRepository {

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

    public static void insere(int idCampi, String nome) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("INSERT INTO `departamentos` (`id-campi`, `nome`) VALUES (?, ?)");
            prst.setInt(1, idCampi);
	    prst.setString(2, nome);
            prst.executeUpdate();
            prst.close();
            con.close();
        }
        else{
            throw new SQLException();
        }
    }

    public static void insere(Departamento depto) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("INSERT INTO `departamentos` (`id-campi`, `nome`) VALUES (?, ?)");
			prst.setInt(1, depto.getIdCampi());
			prst.setString(2, depto.getNome());
            prst.executeUpdate();
            prst.close();
            con.close();
        }
        else{
            throw new SQLException();
        }
    }

    public static void atualiza(int id, int idCampi) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("UPDATE `departamentos` SET `id-campi` = ? WHERE `id` = ?");
			prst.setInt(1, idCampi);
			prst.setInt(2, id);
			prst.executeUpdate();
			prst.close();
			con.close();
        }
        else{
           throw new SQLException();
        }
    }

    public static void atualiza(int id, String nome) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("UPDATE `departamentos` SET `nome` = ? WHERE `id` = ?");
			prst.setString(1, nome);
			prst.setInt(2, id);
			prst.executeUpdate();
			prst.close();
			con.close();
        }
        else{
            throw new SQLException();
        }
    }

    public static void atualiza(int id, int idCampi, String nome) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("UPDATE `departamentos` SET `id-campi` = ?, `nome` = ? WHERE `id` = ?");
			prst.setInt(1, idCampi);
			prst.setString(2, nome);
			prst.setInt(3, id);
            prst.executeUpdate();
			prst.close();
			con.close();
        }
        else{
            throw new SQLException();
        }
    }

    public static void atualiza(Departamento depto) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("UPDATE `departamentos` SET `id-campi` = ?, `nome` = ? WHERE `id` = ?");
			prst.setInt(1, depto.getIdCampi());
			prst.setString(2, depto.getNome());
			prst.setInt(3, depto.getId());
			prst.executeUpdate();
			prst.close();
			con.close();
        }
        else{
            throw new SQLException();
        }
    }

    public static void remove(int id) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("DELETE FROM `departamentos` WHERE `id` = ?");
			prst.setInt(1, id);
            prst.executeUpdate();
			prst.close();
			con.close();     
        }
        else{
            throw new SQLException();
        }
    }

    public static void remove(Departamento depto) throws SQLException{
        Connection con = ConnectionFactory.getDiario();
        if(con != null){
            PreparedStatement prst = con.prepareStatement("DELETE FROM `departamentos` WHERE `id` = ?");
			prst.setInt(1, depto.getId());
			prst.executeUpdate();
			prst.close();
			con.close();
        }
        else{
            throw new SQLException();
        }
    }
}
