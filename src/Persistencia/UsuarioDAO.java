package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Usuario;

public class UsuarioDAO {
	
	private ConexaoMysql conexao;
	
	public UsuarioDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA, BdConfigs.NOME_BD);
	}
	
	public void adicionar(Usuario usuario) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO Usuario (email, senha_usu, nome_usu) VALUES(?, ?, ?);";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, usuario.getEmail());
			st.setString(2, usuario.getSenhaUsu());
			st.setString(3, usuario.getNomeUsu());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void editar(Usuario usuario) {
		this.conexao.abrirConexao();
		String sql = "UPDATE Usuario SET email=?, senha_usu=?, nome_usu=? WHERE id_usuario=?;";
		
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, usuario.getEmail());
			st.setString(2, usuario.getSenhaUsu());
			st.setString(3, usuario.getNomeUsu());
			st.setInt(4, usuario.getIdUsuario());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void excluir(int idUsuario) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM Usuario WHERE id_usuario=?;";
		
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idUsuario);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public Usuario buscarPorId(int idUsuario) {
		this.conexao.abrirConexao();
		Usuario usuario = null;
		String sql = "SELECT * FROM Usuario WHERE id_usuario=?;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idUsuario);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNomeUsu(rs.getString("nome_usu"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenhaUsu(rs.getString("senha_usu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return usuario;
	}
	
	public List<Usuario> buscarTodos() {
		this.conexao.abrirConexao();
		List<Usuario> listUsuarios = new ArrayList();
		String sql = "SELECT * FROM Usuario;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNomeUsu(rs.getString("nome_usu"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenhaUsu(rs.getString("senha_usu"));
				listUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listUsuarios;
	}
}
