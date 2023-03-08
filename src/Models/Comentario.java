package Models;

public class Comentario {
	private int idComentario;
	private Usuario usuario;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Comentario() {
		super();
	}
	
	public Comentario(int idComentario, Usuario usuario) {
		super();
		this.idComentario = idComentario;
		this.usuario = usuario;
	}
}
