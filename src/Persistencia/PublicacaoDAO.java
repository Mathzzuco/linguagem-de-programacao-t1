package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Publicacao;
import Models.Usuario;

public class PublicacaoDAO {
	
	private ConexaoMysql conexao;
	
	public PublicacaoDAO() {
		this.conexao = new ConexaoMysql(BdConfigs.IP, BdConfigs.PORTA, BdConfigs.LOGIN, BdConfigs.SENHA, BdConfigs.NOME_BD);
	}
	
	public void adicionar(Publicacao publicacao) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO Publicacao (informacoes_do_animal, localizacao, id_usuario) VALUES(?, ?, ?);";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, publicacao.getInformacoesDoAnimal());
			st.setString(2, publicacao.getLocalizacao());
			st.setInt(3, publicacao.getUsuario().getIdUsuario());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void editar(Publicacao publicacao) {
		this.conexao.abrirConexao();
		String sql = "UPDATE Publicacao SET informacoes_do_animal=?, localizacao=?, id_usuario=? WHERE id_publicacao=?;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, publicacao.getInformacoesDoAnimal());
			st.setString(2, publicacao.getLocalizacao());
			st.setInt(3, publicacao.getUsuario().getIdUsuario());
			st.setInt(4, publicacao.getIdPublicacao());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public void excluir(int idPublicacao) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM Publicacao WHERE id_publicacao=?;";
		
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idPublicacao);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public Publicacao buscarPorId(int idPublicacao) {
		this.conexao.abrirConexao();
		Publicacao publicacao = null;
		String sql = "SELECT * FROM Publicacao WHERE id_publicacao=?;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idPublicacao);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				publicacao = new Publicacao();
				publicacao.setIdPublicacao(rs.getInt("id_publicacao"));
				publicacao.setInformacoesDoAnimal(rs.getString("informacoes_do_animal"));
				publicacao.setLocalizacao(rs.getString("localizacao"));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarPorId(rs.getInt("id_usuario"));
				publicacao.setUsuario(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return publicacao;
	}
	
	public Publicacao buscarPorLocal(String localizacao) {
		this.conexao.abrirConexao();
		Publicacao publicacao = null;
		String sql = "SELECT * FROM Publicacao WHERE localizacao=?;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			st.setString(1, localizacao);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				publicacao = new Publicacao();
				publicacao.setIdPublicacao(rs.getInt("id_publicacao"));
				publicacao.setInformacoesDoAnimal(rs.getString("informacoes_do_animal"));
				publicacao.setLocalizacao(rs.getString("localizacao"));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarPorId(rs.getInt("id_usuario"));
				publicacao.setUsuario(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return publicacao;
	}
	
	public List<Publicacao> buscarTodos() {
		this.conexao.abrirConexao();
		List<Publicacao> listPublicacoes = new ArrayList();
		String sql = "SELECT * FROM Publicacao;";
		try {
			PreparedStatement st = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Publicacao publicacao = new Publicacao();
				publicacao.setIdPublicacao(rs.getInt("id_publicacao"));
				publicacao.setInformacoesDoAnimal(rs.getString("informacoes_do_animal"));
				publicacao.setLocalizacao(rs.getString("localizacao"));
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarPorId(rs.getInt("id_usuario"));
				publicacao.setUsuario(usuario);
				listPublicacoes.add(publicacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listPublicacoes;
	}
}
