/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.diario;

import diario.diario.views.ExcecaoPadrao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author juanr
 */
public class DiarioRepository {

	protected Connection conexao;

	public DiarioRepository(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean insere(DiarioModel modelo) throws SQLException {
		String query = "INSERT INTO diario(`id-conteudos`,`id-matriculas`, faltas, nota) VALUES (?, ?, ?, COALESCE(?,0.0))";
		PreparedStatement st = conexao.prepareStatement(query);
		st.setInt(1, modelo.getIdConteudo());
		st.setInt(2, modelo.getIdMatricula());
		st.setInt(3, modelo.getFalta());
		st.setDouble(4, modelo.getNota());
		int r = st.executeUpdate();

		st.close();
		conexao.close();

		return r != 0;
	}

	public boolean atualizar(DiarioModel modelo, DiarioModel filtro) throws SQLException, ExcecaoPadrao {
		String query = "UPDATE diario SET `id-conteudos=?`,`id-matriculas`=?, faltas=?, nota=? WHERE `id-conteudos=?` AND `id-matriculas`=?";
		PreparedStatement st;

		if (filtro.getIdConteudo() != null && filtro.getIdMatricula() != null) {
			query += " WHERE `id-conteudos`=? AND `id-matriculas`=?";
			st = conexao.prepareStatement(query);
			st.setInt(5, filtro.getIdConteudo());
			st.setInt(6, filtro.getIdMatricula());
		} else if (filtro.getIdConteudo() != null) {
			query += " WHERE `id-conteudos`=?";
			st = conexao.prepareStatement(query);
			st.setInt(5, filtro.getIdConteudo());
		} else if (filtro.getIdMatricula() != null) {
			query += " WHERE `id-matriculas`=?";
			st = conexao.prepareStatement(query);
			st.setInt(5, filtro.getIdMatricula());
		} else {
			throw new ExcecaoPadrao("Nenhuma alteração efetuada!");
		}

		st.setInt(1, modelo.getIdConteudo());
		st.setInt(2, modelo.getIdMatricula());
		st.setInt(3, modelo.getFalta());
		st.setDouble(4, modelo.getNota());
		int r = st.executeUpdate();

		st.close();
		conexao.close();

		return r != 0;
	}

	/* Deletar */
	public boolean remover(DiarioModel filtro) throws SQLException, ExcecaoPadrao {
		String query = "DELETE FROM diario";
		PreparedStatement st;

		int r = 0;

		if (filtro.getIdConteudo() != null && filtro.getIdMatricula() != null) {
			query += " WHERE `id-conteudos`=? AND `id-matriculas`=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getIdConteudo());
			st.setInt(2, filtro.getIdMatricula());
			r = st.executeUpdate();

		} else if (filtro.getIdConteudo() != null) {
			query += " WHERE `id-conteudos`=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getIdConteudo());
			r = st.executeUpdate();
			st.close();
		} else if (filtro.getIdMatricula() != null) {
			query += " WHERE `id-matriculas`=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getIdMatricula());
			r = st.executeUpdate();
			st.close();
		} else {
			throw new ExcecaoPadrao("A ação de deletar toda tabela não é permitida!");
		}
		return r != 0;
	}

	/* Consulta */
	public ArrayList consulta(DiarioModel filtro) throws SQLException {
		String query = "SELECT * FROM diario";
		PreparedStatement st;

		if (filtro.getIdConteudo() != null && filtro.getIdMatricula() != null) {
			query += " WHERE `id-conteudos`=? AND `id-matriculas`=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getIdConteudo());
			st.setInt(2, filtro.getIdMatricula());
		} else if (filtro.getIdConteudo() != null) {
			query += " WHERE `id-conteudos`=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getIdConteudo());
		} else if (filtro.getIdMatricula() != null) {
			query += " WHERE `id-matriculas`=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getIdMatricula());
		} else {
			st = conexao.prepareStatement(query);
			//throw new ExcecaoPadrao("Operação Inválida: Não pode mostrar tudo.");
		}

		ResultSet resultado = st.executeQuery();
		ArrayList<DiarioModel> lista = new ArrayList<>();
		while (resultado.next()) {
			DiarioModel modelo = new DiarioModel(resultado.getInt("id-conteudos"), resultado.getInt("id-matriculas"), resultado.getInt("faltas"), resultado.getDouble("nota"));
			lista.add(modelo);
		}

		st.close();
		return lista;
	}

}
