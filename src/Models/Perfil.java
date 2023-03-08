package Models;

public class Perfil {
	private int idPerfil;
	private String publicacoes;
	private String nomeDoUsuario;
	
	public int getId_perfil() {
		return idPerfil;
	}
	public void setId_perfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(String publicacoes) {
		this.publicacoes = publicacoes;
	}
	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}
	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}
	public Perfil() {
		super();
	}
	
	public Perfil(int idPerfil, String publicacoes, String nomeDoUsuario) {
		super();
		this.idPerfil = idPerfil;
		this.publicacoes = publicacoes;
		this.nomeDoUsuario = nomeDoUsuario;
	}
}
