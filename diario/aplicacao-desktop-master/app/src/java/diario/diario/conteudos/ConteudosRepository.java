/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario.diario.conteudos;

import diario.diario.diario.DiarioModel;
import diario.diario.diario.DiarioRepository;
import diario.diario.views.ExcecaoPadrao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author juanr
 */
public class ConteudosRepository {

	protected Connection conexao;

	public ConteudosRepository(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean insere(ConteudosModel modelo) throws SQLException {
		String query = "INSERT INTO conteudos(`id-etapas`,`id-disciplinas`, conteudos , data, valor) VALUES (?,?,?,?,?)";
		PreparedStatement st = conexao.prepareStatement(query);

		st.setInt(1, modelo.getIdEtapa());
		st.setInt(2, modelo.getIdDisciplina());
		st.setString(3, modelo.getConteudo());
		st.setDate(4, modelo.getData());
		if (modelo.getValor() != null) {
			st.setDouble(5, modelo.getValor());
		} else {
			st.setDouble(5, 0.0);
		}

		int r = st.executeUpdate();
		st.close();
		return r != 0;
	}

	public boolean atualizar(ConteudosModel modelo) throws SQLException {
		String query = "UPDATE conteudos SET "
			+ "`id-etapas`= COALESCE(?, conteudos.`id-etapas`),"
			+ "`id-disciplinas`= COALESCE(?, conteudos.`id-disciplinas`),"
			+ "`conteudos`= COALESCE(?, conteudos.`conteudos`),"
			+ "`data`= COALESCE(?, conteudos.`data`),"
			+ "`valor`= COALESCE(?, conteudos.`valor`)"
			+ " WHERE id=?";

		PreparedStatement st = conexao.prepareStatement(query);

		if (modelo.getIdEtapa() != null) {
			st.setInt(1, modelo.getIdEtapa());
		} else {
			st.setNull(1, Types.INTEGER);
		}

		if (modelo.getIdDisciplina() != null) {
			st.setInt(2, modelo.getIdDisciplina());
		} else {
			st.setNull(2, Types.INTEGER);
		}

		if (modelo.getConteudo() != null) {
			st.setString(3, modelo.getConteudo());
		} else {
			st.setNull(3, Types.OTHER);
		}

		if (modelo.getData() != null) {
			st.setDate(4, modelo.getData());
		} else {
			st.setNull(4, Types.DATE);
		}

		if (modelo.getValor() != null) {
			st.setDouble(5, modelo.getValor());
		} else {
			st.setNull(5, Types.DECIMAL);
		}

		st.setInt(6, modelo.getId());

		int r = st.executeUpdate();
		st.close();
		return r != 0;
	}

	public boolean remover(ConteudosModel filtro) throws SQLException, ExcecaoPadrao {
		String query;
		PreparedStatement st;

		if (filtro.getId() != null) {
			query = "DELETE FROM conteudos WHERE id=?";
			st = conexao.prepareStatement(query);
			st.setInt(1, filtro.getId());

			int r = st.executeUpdate();
			if (r != 0) {
				DiarioRepository repositorioDiario = new DiarioRepository(conexao);
				DiarioModel filtroDiario = new DiarioModel();
				filtroDiario.setIdConteudo(filtro.getId());
				repositorioDiario.remover(filtroDiario);
			}
			return r != 0;
		} else {
			query = "SELECT id FROM conteudos";
			ArrayList<ConteudosModel> resultado = consulta(filtro);

			int pos = 1;
			for (ConteudosModel modelo : resultado) {
				if (pos > 1) {
					query += " OR";
				}
				query += " id=?";
				pos++;
			}

			st = conexao.prepareStatement(query);

			pos = 1;
			for (ConteudosModel modelo : resultado) {
				st.setInt(pos, modelo.getId());
				pos++;
			}

			int r = st.executeUpdate();
			if (r != 0) {
				DiarioRepository repositorioDiario = new DiarioRepository(conexao);
				DiarioModel filtroDiario = new DiarioModel();

				for (ConteudosModel modelo : resultado) {
					filtroDiario.setIdConteudo(modelo.getId());
					repositorioDiario.remover(filtroDiario);
				}
			}

			return r != 0;
		}

	}

	public ArrayList consulta(ConteudosModel modelo) throws SQLException {
		return consulta(modelo, null);
	}

	public ArrayList consulta(ConteudosModel modelo, String tipo) throws SQLException {
		String query = "SELECT * FROM conteudos";
		PreparedStatement st;

		Map<String, Object> filtros = new HashMap<>();

		if (modelo.getId() != null) {
			filtros.put("id", modelo.getId());
		} else {
			if (modelo.getIdEtapa() != null) {
				filtros.put("id-etapas", modelo.getIdEtapa());
			}
			if (modelo.getIdDisciplina() != null) {
				filtros.put("id-disciplinas", modelo.getIdDisciplina());
			}
			if (modelo.getData() != null) {
				filtros.put("data", modelo.getData());
			}
			if (modelo.getConteudo() != null) {
				filtros.put("conteudos", modelo.getConteudo());
			}
			if (modelo.getValor() != null) {
				filtros.put("valor", modelo.getValor());
			}
		}

		if (filtros.size() > 0 || tipo != null) {
			query += " WHERE";
		}

		if (tipo != null) {
			if (tipo.equals("conteudo")) {
				query += " valor=0";
			} else if (tipo.equals("atividade")) {
				query += " valor>0.0";
			}

			if (filtros.size() > 0) {
				query += " AND";
			}
		}

		int pos = 1;
		for (String filtro : filtros.keySet()) {
			if (pos > 1) {
				query += " AND";
			}
			query += " `" + filtro + "` = ?";
			pos++;
		}
		query += " ORDER BY `data`";

		st = conexao.prepareStatement(query);

		pos = 1;
		for (String filtro : filtros.keySet()) {
			if (filtro.equals("id-etapas") || filtro.equals("id-disciplinas")) {
				st.setInt(pos, (Integer) filtros.get(filtro));
			}
			if (filtro.equals("data")) {
				st.setDate(pos, (Date) filtros.get(filtro));
			}
			if (filtro.equals("conteudos")) {
				st.setString(pos, (String) filtros.get(filtro));
			}
			if (filtro.equals("valor")) {
				st.setDouble(pos, (Double) filtros.get(filtro));
			}

			pos++;
		}

		ResultSet resultado = st.executeQuery();

		ArrayList<ConteudosModel> lista = new ArrayList<>();
		while (resultado.next()) {
			modelo = new ConteudosModel(resultado.getInt("id"), resultado.getInt("id-etapas"), resultado.getInt("id-disciplinas"), resultado.getString("conteudos"), resultado.getDate("data"), resultado.getDouble("valor"));
			lista.add(modelo);
		}

		st.close();

		return lista;
	}
}
