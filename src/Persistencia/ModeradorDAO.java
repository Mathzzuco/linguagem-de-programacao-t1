package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Moderador;
import Models.Usuario;

public class ModeradorDAO {
	
	private ConexaoMysql conexao;
	
	public ModeradorDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA, BdConfigs.NOME_BD);
	}
	
	public void adicionar(Moderador moderador) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO Moderador (nome_mod, codigo_especial, senha_mod) VALUES(?, ?, ?);";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, moderador.getNomeMod());
			st.setInt(2, moderador.getCodigoEspecial());
			st.setString(3, moderador.getSenhaMod());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void editar(Moderador moderador) {
		this.conexao.abrirConexao();
		String sql = "UPDATE Usuario SET nome_mod?, codigo_especial=?, senha_mod=? WHERE id_moderador=?;";
		
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, moderador.getNomeMod());
			st.setInt(2, moderador.getCodigoEspecial());
			st.setString(3, moderador.getSenhaMod());
			st.setInt(4, moderador.getIdModerador());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void excluir(int idModerador) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM Moderador WHERE id_moderador=?;";
		
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idModerador);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public Moderador buscarPorId(int idModerador) {
		this.conexao.abrirConexao();
		Moderador moderador = null;
		String sql = "SELECT * FROM Moderador WHERE id_moderador=?;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idModerador);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				moderador = new Moderador();
				moderador.setIdModerador(rs.getInt("id_moderador"));
				moderador.setNomeMod(rs.getString("nome_mod"));
				moderador.setSenhaMod(rs.getString("senha_mod"));
				moderador.setCodigoEspecial(rs.getInt("codigo_especial"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return moderador;
	}
	
	public List<Moderador> buscarTodos() {
		this.conexao.abrirConexao();
		List<Moderador> listModeradores = new ArrayList();
		String sql = "SELECT * FROM Moderador;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Moderador moderador = new Moderador();
				moderador.setIdModerador(rs.getInt("id_moderador"));
				moderador.setNomeMod(rs.getString("nome_mod"));
				moderador.setCodigoEspecial(rs.getInt("codigo_especial"));
				moderador.setSenhaMod(rs.getString("senha_Mod"));
				listModeradores.add(moderador);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listModeradores;
	}
}
