package servlets.admin;

import java.util.Date;
import java.util.List;

public class ComandaUI {
	Integer idComanda;
	Integer nrMasa;
	String numeOspatar;
	Date dataCreare;
	Date dataLivrare;
	Double pretTotal;
	List liniiTabelComandaOspatar;
	
	public ComandaUI() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Integer getNrMasa() {
		return nrMasa;
	}

	public void setNrMasa(Integer nrMasa) {
		this.nrMasa = nrMasa;
	}

	public String getNumeOspatar() {
		return numeOspatar;
	}

	public void setNumeOspatar(String numeOspatar) {
		this.numeOspatar = numeOspatar;
	}

	public Date getDataCreare() {
		return dataCreare;
	}

	public void setDataCreare(Date dataCreare) {
		this.dataCreare = dataCreare;
	}

	public Date getDataLivrare() {
		return dataLivrare;
	}

	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}

	public Double getPretTotal() {
		return pretTotal;
	}

	public void setPretTotal(Double pretTotal) {
		this.pretTotal = pretTotal;
	}

	public List getLiniiTabelComandaOspatar() {
		return liniiTabelComandaOspatar;
	}

	public void setLiniiTabelComandaOspatar(List liniiTabelComandaOspatar) {
		this.liniiTabelComandaOspatar = liniiTabelComandaOspatar;
	}

	
	
}
