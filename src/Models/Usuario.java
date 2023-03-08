package Models;

public class Usuario {
	private int idUsuario;
	private String email;
	private String senhaUsu;
	private String nomeUsu;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenhaUsu() {
		return senhaUsu;
	}
	public void setSenhaUsu(String senhaUsu) {
		this.senhaUsu = senhaUsu;
	}
	public String getNomeUsu() {
		return nomeUsu;
	}
	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}
	public Usuario() {
		super();
	}
	
	public Usuario(int idUsuario, String email, String senhaUsu, String nomeUsu) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senhaUsu = senhaUsu;
		this.nomeUsu = nomeUsu;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario = " + idUsuario + ", email = " + email + ", senha = " + senhaUsu + ", nome = "
				+ nomeUsu + "]";
	}
}
