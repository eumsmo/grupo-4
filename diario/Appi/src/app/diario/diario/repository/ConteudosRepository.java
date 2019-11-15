/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.diario.diario.repository;

import app.diario.diario.model.ConteudosModel;
import app.diario.diario.model.Departamento;
import app.utils.ConnectionFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author juanr
 */
public class ConteudosRepository {

	protected Connection conexao;

	public ConteudosRepository(Connection conexao) {
		this.conexao = conexao;
	}

	    public static List<ConteudosModel> consulta() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        if (con != null) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `conteudos`");
            List<ConteudosModel> Conteudos = new LinkedList();

            while (rs.next()) {
              ConteudosModel Cont = new ConteudosModel( rs.getString("id-etapas"), rs.getString("conteudos"), rs.getString("data"));
              System.out.println("\nEtapas"+Cont.getIdEtapa());  
              Conteudos.add(Cont);
                //System.out.println("\nEtapas"+rs.getString("idEtapas"));
            }

            stmt.close();
            con.close();
            return Conteudos;
        } else {
            throw new SQLException();
        }
    }
}
