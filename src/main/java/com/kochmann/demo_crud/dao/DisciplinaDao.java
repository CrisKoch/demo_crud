package com.kochmann.demo_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kochmann.demo_crud.modelo.Disciplina;

public class DisciplinaDao {
	public void inserir(Disciplina d) {
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "insert into disciplina" + "(periodo,nome,professor,codigo_sala_classroom)" + " values (?,?,?,?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, d.getPeriodo());
			stmt.setString(2, d.getNome());
			stmt.setString(3, d.getProfessor());
			stmt.setString(4, d.getCodigo_sala_classroom());

			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Disciplina> todos() {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from disciplina";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet retorno = stmt.executeQuery();
			while (retorno.next()) {
				int id = retorno.getInt("id");
				int per = retorno.getInt("periodo");
				String nome = retorno.getString("nome");
				String pro = retorno.getString("professor");
				String codigo = retorno.getString("codigo_sala_classroom");
				Disciplina disciplina = new Disciplina(id, per, nome, pro, codigo);
				lista.add(disciplina);
			}
			retorno.close();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	public void excluir(int id) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "delete from disciplina where id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Disciplina disciplina) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "update disciplina set nome=?,professor=?,periodo=?,codigo_sala_classroom=?" + " where id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, disciplina.getNome());
			stmt.setString(2, disciplina.getProfessor());
			stmt.setInt(3, disciplina.getPeriodo());
			stmt.setString(4, disciplina.getCodigo_sala_classroom());
			stmt.setInt(5, disciplina.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Disciplina buscaPorId(int id) {
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from disciplina where id = ?;";
		Disciplina disciplina = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet retorno = stmt.executeQuery();
			retorno.next();
			String nomeDisciplina = retorno.getString("nome");
			int periodo = retorno.getInt("periodo");
			String professor = retorno.getString("professor");
			String cod = retorno.getString("codigo_sala_classroom");
			disciplina = new Disciplina(id, periodo, nomeDisciplina, professor, cod);
			stmt.close();
			conexao.close();
		} catch (

		SQLException e) {
			System.out.println(e.getMessage());
		}
		return disciplina;
	}

}
