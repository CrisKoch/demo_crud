package com.kochmann.demo_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kochmann.demo_crud.modelo.LugarNaFila;


public class DisciplinaDao {
	public void inserir(LugarNaFila d) {
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

	public List<LugarNaFila> todos() {
		List<LugarNaFila> lista = new ArrayList<LugarNaFila>();
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from disciplina order by timestamp";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet retorno = stmt.executeQuery();
			while (retorno.next()) {
				int id = retorno.getInt("id");
				Timestamp timestamp = retorno.getTimestamp("timestamp");
				int per = retorno.getInt("periodo");
				String nome = retorno.getString("nome");
				String pro = retorno.getString("professor");
				String codigo = retorno.getString("codigo_sala_classroom");
				LugarNaFila disciplina = new LugarNaFila(id, per, nome, pro, codigo, timestamp);
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

	public void atualizar(LugarNaFila disciplina) {
		Connection conexao = FabricaDeConexao.getConnection();
		PreparedStatement stmt;
		String sql = "update disciplina set nome=?,professor=?,periodo=?,codigo_sala_classroom=? where id = ?";
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

	public LugarNaFila buscaPorId(int id) {
		Connection conexao = FabricaDeConexao.getConnection();
		String sql = "select * from disciplina where id = ?;";
		LugarNaFila disciplina = null;
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet retorno = stmt.executeQuery();
			retorno.next();
			String nomeDisciplina = retorno.getString("nome");
			int periodo = retorno.getInt("periodo");
			String professor = retorno.getString("professor");
			String cod = retorno.getString("codigo_sala_classroom");
			disciplina = new LugarNaFila(id, periodo, nomeDisciplina, professor, cod);
			stmt.close();
			conexao.close();
		} catch (

		SQLException e) {
			System.out.println(e.getMessage());
		}
		return disciplina;
	}

}
