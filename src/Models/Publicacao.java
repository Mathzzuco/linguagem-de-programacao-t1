package Models;

public class Publicacao {
	private int idPublicacao;
	private String informacoesDoAnimal;
	private String localizacao;
	private Usuario usuario;
	
	public int getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	public String getInformacoesDoAnimal() {
		return informacoesDoAnimal;
	}
	public void setInformacoesDoAnimal(String informacoesDoAnimal) {
		this.informacoesDoAnimal = informacoesDoAnimal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Publicacao() {
		super();
	}
	
	public Publicacao(int idPublicacao, String informacoesDoAnimal, String localizacao, Usuario usuario) {
		super();
		this.idPublicacao = idPublicacao;
		this.informacoesDoAnimal = informacoesDoAnimal;
		this.localizacao = localizacao;
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Publicacao [idPublicacao = " + idPublicacao + ", informacoesDoAnimal = " + informacoesDoAnimal
				+ ", localizacao = " + localizacao + ", usuario = " + usuario + "]";
	}
}
