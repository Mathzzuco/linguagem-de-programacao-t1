package Models;

public class Moderador {
	private int idModerador;
	private String nomeMod;
	private int codigoEspecial;
	private String senhaMod;
	
	public int getIdModerador() {
		return idModerador;
	}
	public void setIdModerador(int idModerador) {
		this.idModerador = idModerador;
	}
	public String getNomeMod() {
		return nomeMod;
	}
	public void setNomeMod(String nomeMod) {
		this.nomeMod = nomeMod;
	}
	public int getCodigoEspecial() {
		return codigoEspecial;
	}
	public void setCodigoEspecial(int codigoEspecial) {
		this.codigoEspecial = codigoEspecial;
	}
	public String getSenhaMod() {
		return senhaMod;
	}
	public void setSenhaMod(String senhaMod) {
		this.senhaMod = senhaMod;
	}
	public Moderador() {
		super();
	}
	
	public Moderador(int idModerador, String nomeMod, int codigo_especial, String senhaMod) {
		super();
		this.idModerador = idModerador;
		this.nomeMod = nomeMod;
		this.codigoEspecial = codigo_especial;
		this.senhaMod = senhaMod;
	}
	@Override
	public String toString() {
		return "Moderador [idModerador=" + idModerador + ", nome=" + nomeMod + ", codigoEspecial=" + codigoEspecial
				+ ", senha=" + senhaMod + "]";
	}
}
